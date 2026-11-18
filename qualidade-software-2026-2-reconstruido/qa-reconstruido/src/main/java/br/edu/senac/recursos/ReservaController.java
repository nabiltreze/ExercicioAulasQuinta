package br.edu.senac.recursos;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
 private final ReservaService service;
 public ReservaController(ReservaService service){this.service=service;}
 public record CriarReserva(String recursoId,LocalDateTime inicio,LocalDateTime fim){}
 @PostMapping public ResponseEntity<Reserva> criar(@RequestBody CriarReserva entrada){
  return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entrada.recursoId(),entrada.inicio(),entrada.fim()));
 }
 @GetMapping public List<Reserva> listar(){return service.listar();}
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<String> invalido(IllegalArgumentException e){return ResponseEntity.badRequest().body(e.getMessage());}
 @ExceptionHandler(IllegalStateException.class) public ResponseEntity<String> conflito(IllegalStateException e){return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}
}
