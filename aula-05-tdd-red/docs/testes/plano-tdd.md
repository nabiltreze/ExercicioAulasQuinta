# Plano TDD — Aula 05 (recorte reconstruído)

**Fonte**: [Especificação oficial — Regras críticas](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/especificacao-projeto.html). Os identificadores RN-* abaixo são atribuídos **nesta reconstrução**, não são IDs oficiais publicados pelo professor.

| Regra | Origem | Casos planejados | Testes JUnit | Status |
|---|---|---|---|---|
| RN-TEMPO-01 — fim posterior ao início | Tempo e concorrência | válido; duração zero; invertido | `rnTempo01AceitaPeriodoValido`, `rnTempo01RejeitaDuracaoZero`, `rnTempo01RejeitaPeriodoInvertido` | Escrito; execução pendente |
| RN-CONFLITO-01 — sem sobreposição para mesmo recurso | Tempo e concorrência | sobreposição; recursos diferentes; períodos adjacentes | `rnConflito01DetectaSobreposicao`, `rnConflito01RecursosDiferentes`, `rnConflito01ReservasAdjacentes` | Escrito; execução pendente |
| RN-MANUT-01 — manutenção impede reserva | Tempo e concorrência | em manutenção; disponível nesta condição | `rnManut01BloqueiaRecursoEmManutencao`, `rnManut01RecursoDisponivelNaVerificacaoDeManutencao` | Escrito; execução pendente |

## Lacunas a tratar para completar o enunciado
- Inventariar **todas** as regras da aplicação efetiva, lendo personas, PRD, arquitetura, ADRs e implementação real. A especificação oficial não substitui os artefatos de um grupo.
- Cobrir regras de aprovação, estados, auditoria, concorrência real, entrada inválida e perfis de autorização.
- Inspecionar o repositório com IA/terminal conforme Prompt 1 e executar Maven conforme Prompt 2.
- Registrar testes existentes que já passam, falhas por configuração e falhas por comportamento, sem presumir resultados.

## Ambiguidades
- Uma reserva que termina exatamente quando outra começa foi modelada como **não conflitante** nesta proposta, mas essa convenção não está explícita na especificação. Confirmar com o professor/equipe.
- `podeReservar(false)` verifica só a condição de manutenção, não todas as demais regras necessárias para criar uma reserva.
