# Plano TDD — Aula 06 (reconstrucao)

Os 8 testes foram copiados **sem alteracoes** de `aula-05-tdd-red` para um modulo demonstrativo independente. O codigo da Aula 05 permanece em estado RED; a Aula 06 mostra a versao GREEN.

| Regra | Casos JUnit | Estado da implementacao | Execucao |
|---|---|---|---|
| RN-TEMPO-01 | `rnTempo01AceitaPeriodoValido`, `rnTempo01RejeitaDuracaoZero`, `rnTempo01RejeitaPeriodoInvertido` | Implementada | Nao validada |
| RN-CONFLITO-01 | `rnConflito01DetectaSobreposicao`, `rnConflito01RecursosDiferentes`, `rnConflito01ReservasAdjacentes` | Implementada | Nao validada |
| RN-MANUT-01 | `rnManut01BloqueiaRecursoEmManutencao`, `rnManut01RecursoDisponivelNaVerificacaoDeManutencao` | Implementada | Nao validada |

**Nao alegar 100% de sucesso:** nao foi executado Maven neste ambiente e ainda nao ha evidencias de runs do GitHub.

## Evidencias pendentes
- Resultado de `mvn -B -f aula-06-tdd-green/pom.xml verify`.
- URL/ID do run vermelho intencional e do run verde restaurado.
- Pull request, revisao e protecao da branch main.
