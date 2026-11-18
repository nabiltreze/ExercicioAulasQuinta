package br.edu.senac.recursos;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
class ReservaServiceTest {
 private ReservaService service;
 private final LocalDateTime inicio=LocalDateTime.of(2026,11,18,10,0);
 @BeforeEach void setup(){service=new ReservaService();}
 @Test void criaReservaValida(){assertEquals(Reserva.Status.SOLICITADA,service.criar("sala-1",inicio,inicio.plusHours(1)).status());}
 @Test void rejeitaFimAnterior(){assertThrows(IllegalArgumentException.class,()->service.criar("sala-1",inicio,inicio.minusMinutes(1)));}
 @Test void rejeitaIntervaloIgual(){assertThrows(IllegalArgumentException.class,()->service.criar("sala-1",inicio,inicio));}
 @Test void rejeitaConflito(){service.criar("sala-1",inicio,inicio.plusHours(1)); assertThrows(IllegalStateException.class,()->service.criar("sala-1",inicio.plusMinutes(15),inicio.plusHours(2)));}
 @Test void permiteReservasAdjacentes(){service.criar("sala-1",inicio,inicio.plusHours(1));assertDoesNotThrow(()->service.criar("sala-1",inicio.plusHours(1),inicio.plusHours(2)));}
 @Test void permiteOutroRecurso(){service.criar("sala-1",inicio,inicio.plusHours(1));assertDoesNotThrow(()->service.criar("sala-2",inicio,inicio.plusHours(1)));}
 @Test void bloqueiaManutencao(){service.definirManutencao("sala-1",true);assertThrows(IllegalStateException.class,()->service.criar("sala-1",inicio,inicio.plusHours(1)));}
 @ParameterizedTest @ValueSource(strings={""," ","  "}) void rejeitaRecursoVazio(String id){assertThrows(IllegalArgumentException.class,()->service.criar(id,inicio,inicio.plusHours(1)));}
 @Test void apenasUmaReservaSimultanea() throws Exception {
  int n=20;ExecutorService executor=Executors.newFixedThreadPool(n); CountDownLatch comecar=new CountDownLatch(1);CountDownLatch prontos=new CountDownLatch(n);AtomicInteger aceitas=new AtomicInteger();
  try {var tarefas=new java.util.ArrayList<Future<?>>();for(int i=0;i<n;i++) tarefas.add(executor.submit(()->{prontos.countDown();try{comecar.await();service.criar("sala-1",inicio,inicio.plusHours(1));aceitas.incrementAndGet();}catch(IllegalStateException esperado){}catch(InterruptedException e){Thread.currentThread().interrupt();}}));
   assertTrue(prontos.await(10,TimeUnit.SECONDS));comecar.countDown();for(var t:tarefas)t.get(10,TimeUnit.SECONDS);assertEquals(1,aceitas.get());
  }finally{comecar.countDown();executor.shutdownNow();}
 }
}
