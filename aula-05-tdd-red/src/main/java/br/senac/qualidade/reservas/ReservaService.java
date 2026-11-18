package br.senac.qualidade.reservas;

import java.time.LocalDateTime;

/** Contrato mínimo para a fase RED. Regras não implementadas propositalmente. */
public class ReservaService {

    public record Reserva(String recursoId, LocalDateTime inicio, LocalDateTime fim) {}

    /** RN-TEMPO-01: término posterior ao início. */
    public void validarPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        throw new UnsupportedOperationException("RED: validarPeriodo ainda não implementado");
    }

    /** RN-CONFLITO-01: reservas do mesmo recurso não podem se sobrepor. */
    public boolean existeConflito(Reserva existente, Reserva solicitada) {
        throw new UnsupportedOperationException("RED: existeConflito ainda não implementado");
    }

    /** RN-MANUT-01: recursos em manutenção não podem ser reservados. */
    public boolean podeReservar(boolean emManutencao) {
        throw new UnsupportedOperationException("RED: podeReservar ainda não implementado");
    }
}
