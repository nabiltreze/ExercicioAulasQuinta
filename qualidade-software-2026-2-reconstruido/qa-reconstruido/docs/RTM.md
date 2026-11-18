# Matriz de rastreabilidade inicial (RTM)

**Status:** modelo parcial. Não representa validação completa dos 14 requisitos.

| Requisito | Risco | Testes/evidência | Status |
| --- | --- | --- | --- |
| RF04 Criar reserva | Reserva inválida | ReservaServiceTest.criaReservaValida; ReservaControllerTest | Implementação parcial |
| RF05 Impedir sobreposição | Dupla alocação | rejeitaConflito; permiteReservasAdjacentes | Implementado em memória |
| RF06 Proteger concorrência | Dupla reserva simultânea | apenasUmaReservaSimultanea | Coberto em instância única |
| RF08 Manutenção | Reserva de recurso bloqueado | bloqueiaManutencao | Implementação parcial |
| RF01–03, RF07, RF09–14 | Variados | Não disponíveis | Pendente |

Para cada requisito, preencher risco, teste, link para evidência real e resultados do pipeline após execução.
