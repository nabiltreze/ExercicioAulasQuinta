package br.edu.senac.recursos;
import java.time.LocalDateTime;
import java.util.UUID;
public record Reserva(UUID id,String recursoId,LocalDateTime inicio,LocalDateTime fim,Status status) {
 public enum Status { SOLICITADA, APROVADA, CANCELADA, EM_USO, CONCLUIDA }
}
