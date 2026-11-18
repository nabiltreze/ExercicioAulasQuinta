# ATAM — ciclo 01 (rascunho de reconstrucao)

**Base:** exemplo simplificado de reservas Java; nao constitui avaliacao do projeto semestral completo.

## Direcionadores
- Impedir reservas com periodo invalido e sobreposicao do mesmo recurso.
- Bloquear recursos em manutencao.
- Dar feedback automatico rapido em alteracoes via GitHub Actions.

## Cenarios de qualidade (6 partes)

| Fonte | Estimulo | Artefato | Ambiente | Resposta | Medida |
|---|---|---|---|---|---|
| Solicitante | Envia reserva com fim igual ao inicio | `ReservaService` | Uso normal | Rejeita periodo | `IllegalArgumentException` |
| Solicitante | Envia reserva sobreposta para mesma sala | `ReservaService` | Uso normal | Detecta conflito | `existeConflito` retorna `true` |
| Equipe | Abre PR com mudanca de logica | Workflow `qualidade` | CI | Executa verificacao Maven | Job `test` finaliza com sucesso ou falha detectavel |

## Utility tree — prioridades propostas
| Atributo | Cenario | Importancia | Dificuldade |
|---|---|---|---|
| Correcao funcional | Impedir periodo invalido | A | B |
| Confiabilidade | Detectar sobreposicao | A | M |
| Manutenibilidade | Feedback no PR | M | B |

## Taticas observaveis no codigo entregue
- Validacao de limites em `ReservaService.validarPeriodo`.
- Comparacao de intervalos semiabertos `[inicio, fim)` em `ReservaService.existeConflito`.
- Testes JUnit para limites em `ReservaServiceTest`.
- Workflow por PR e push na main em `.github/workflows/ci.yml` na **raiz do repositorio**.

## Sensibilidade, trade-offs, riscos e nao riscos
- **Sensibilidade:** a semantica de intervalo `[inicio, fim)` determina se reservas consecutivas conflitam.
- **Trade-off:** verificacao em memoria e simples, mas nao impede concorrencia quando persistida em um banco de dados.
- **Risco:** nenhuma protecao transacional de dupla reserva foi implementada neste exemplo.
- **Risco:** `podeReservar` so verifica manutencao, nao disponibilidade completa.
- **Nao risco no escopo dos 8 testes:** horarios consecutivos nao sao considerados sobrepostos pelo algoritmo proposto.
- **Tema de risco:** integridade de reservas sob concorrencia e em persistencia real.

## Divergencias e proximas acoes
- Os requisitos completos do semestre incluem autorizacao, auditoria, dupla reserva simultanea e banco real, ainda nao implementados neste modulo.
- Proximo ciclo: testar concorrencia, adicionar integracao/persistencia e documentar evidencias reais da CI.
- Sem logs/runs disponiveis, nao e possivel avaliar conformidade operacional.
