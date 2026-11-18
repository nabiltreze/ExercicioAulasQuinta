package br.senac.qualidade.reservas;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.senac.qualidade.reservas.ReservaService.Reserva;

class ReservaServiceTest {
    private ReservaService service;
    private final LocalDateTime base = LocalDateTime.of(2026, 9, 3, 10, 0);

    @BeforeEach void preparar() { service = new ReservaService(); }

    @Test @DisplayName("RN-TEMPO-01: período válido é aceito")
    void rnTempo01AceitaPeriodoValido() {
        // Arrange
        var inicio = base;
        var fim = base.plusHours(1);
        // Act + Assert
        assertDoesNotThrow(() -> service.validarPeriodo(inicio, fim));
    }

    @Test @DisplayName("RN-TEMPO-01: término igual ao início é rejeitado")
    void rnTempo01RejeitaDuracaoZero() {
        // Arrange
        var inicio = base;
        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> service.validarPeriodo(inicio, inicio));
    }

    @Test @DisplayName("RN-TEMPO-01: término anterior ao início é rejeitado")
    void rnTempo01RejeitaPeriodoInvertido() {
        // Arrange
        var inicio = base;
        var fim = base.minusMinutes(1);
        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> service.validarPeriodo(inicio, fim));
    }

    @Test @DisplayName("RN-CONFLITO-01: horários sobrepostos para o mesmo recurso geram conflito")
    void rnConflito01DetectaSobreposicao() {
        // Arrange
        var existente = new Reserva("SALA-01", base, base.plusHours(2));
        var solicitada = new Reserva("SALA-01", base.plusHours(1), base.plusHours(3));
        // Act
        var conflito = service.existeConflito(existente, solicitada);
        // Assert
        assertTrue(conflito);
    }

    @Test @DisplayName("RN-CONFLITO-01: recursos diferentes não conflitam")
    void rnConflito01RecursosDiferentes() {
        // Arrange
        var existente = new Reserva("SALA-01", base, base.plusHours(2));
        var solicitada = new Reserva("SALA-02", base, base.plusHours(1), base.plusHours(3));
        // Act + Assert
        assertFalse(service.existeConflito(existente, solicitada));
    }

    @Test @DisplayName("RN-CONFLITO-01: reservas consecutivas não conflitam")
    void rnConflito01ReservasAdjacentes() {
        // Arrange
        var existente = new Reserva("SALA-01", base, base.plusHours(1));
        var solicitada = new Reserva("SALA-01", base.plusHours(1), base.plusHours(2));
        // Act + Assert
        assertFalse(service.existeConflito(existente, solicitada));
    }

    @Test @DisplayName("RN-MANUT-01: recurso em manutenção é bloqueado")
    void rnManut01BloqueiaRecursoEmManutencao() {
        // Arrange + Act + Assert
        assertFalse(service.podeReservar(true));
    }

    @Test @DisplayName("RN-MANUT-01: recurso fora de manutenção está apto nesta verificação")
    void rnManut01RecursoDisponivelNaVerificacaoDeManutencao() {
        // Arrange + Act + Assert
        assertTrue(service.podeReservar(false));
    }
}
