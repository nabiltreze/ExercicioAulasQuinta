package br.senac.qualidade.reservas;

import java.time.LocalDateTime;
import java.util.Objects;

/** Implementacao GREEN das tres regras demonstrativas da Aula 05. */
public class ReservaService {
    public record Reserva(String recursoId, LocalDateTime inicio, LocalDateTime fim) {}

    /** RN-TEMPO-01: o fim deve ser posterior ao inicio. */
    public void validarPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        Objects.requireNonNull(inicio, "inicio nao pode ser nulo");
        Objects.requireNonNull(fim, "fim nao pode ser nulo");
        if (!fim.isAfter(inicio)) {
            throw new IllegalArgumentException("fim deve ser posterior ao inicio");
        }
    }

    /** RN-CONFLITO-01: sobreposicao apenas quando o recurso coincide. */
    public boolean existeConflito(Reserva existente, Reserva solicitada) {
        Objects.requireNonNull(existente, "reserva existente nao pode ser nula");
        Objects.requireNonNull(solicitada, "reserva solicitada nao pode ser nula");
        validarPeriodo(existente.inicio(), existente.fim());
        validarPeriodo(solicitada.inicio(), solicitada.fim());
        return Objects.equals(existente.recursoId(), solicitada.recursoId())
                && existente.inicio().isBefore(solicitada.fim())
                && solicitada.inicio().isBefore(existente.fim());
    }

    /** RN-MANUT-01: sem manutencao, passa por esta verificacao isolada. */
    public boolean podeReservar(boolean emManutencao) {
        return !emManutencao;
    }
}
