package br.edu.senac.recursos;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class ReservaService {
 private final List<Reserva> reservas = new ArrayList<>();
 private final Set<String> emManutencao = new HashSet<>();
 // Implementação didática em memória; uma única instância. Não substitui locking transacional em produção.
 public synchronized Reserva criar(String recursoId, LocalDateTime inicio, LocalDateTime fim) {
  if (recursoId == null || recursoId.isBlank() || inicio == null || fim == null) throw new IllegalArgumentException("Dados obrigatórios ausentes");
  if (!fim.isAfter(inicio)) throw new IllegalArgumentException("O fim deve ser posterior ao início");
  if (emManutencao.contains(recursoId)) throw new IllegalStateException("Recurso em manutenção");
  boolean conflito = reservas.stream().anyMatch(r -> r.recursoId().equals(recursoId)
   && r.status()!=Reserva.Status.CANCELADA && inicio.isBefore(r.fim()) && fim.isAfter(r.inicio()));
  if (conflito) throw new IllegalStateException("Horário indisponível");
  Reserva reserva=new Reserva(UUID.randomUUID(),recursoId,inicio,fim,Reserva.Status.SOLICITADA);
  reservas.add(reserva); return reserva;
 }
 public synchronized void definirManutencao(String recursoId, boolean ativo) {
  if (ativo) emManutencao.add(recursoId); else emManutencao.remove(recursoId);
 }
 public synchronized List<Reserva> listar() { return List.copyOf(reservas); }
}
