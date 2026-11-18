# Utility tree e análise ATAM — proposta

| Prioridade | Atributo | Estímulo e contexto | Resposta mensurável proposta |
|---|---|---|---|
| Alta | Integridade | Duas solicitações simultâneas ao mesmo recurso/horário | No máximo uma reserva confirmada |
| Alta | Segurança | Solicitante tenta aprovar recurso restrito | Operação negada e estado preservado |
| Alta | Confiabilidade | Falha durante transição de estado | Sem atualização parcial de estado/auditoria |
| Média | Desempenho | Consulta de disponibilidade com volume de reservas | Definir alvo de latência após benchmark |
| Média | Manutenibilidade | Nova regra de aprovação | Alteração isolada com testes de regressão |
| Média | Auditabilidade | Auditor investiga alteração | Evento exibe responsável, data, origem e estado |

## Pontos de sensibilidade
- Mecanismo de bloqueio/transação por recurso influencia diretamente a proteção contra dupla reserva.
- Modelo de permissões influencia a segurança de transições.

## Trade-offs
- Bloqueios mais fortes podem reduzir concorrência, mas protegem a integridade.
- Auditoria detalhada melhora rastreabilidade, mas acrescenta armazenamento e complexidade.

## Riscos a investigar
1. Corrida de gravação entre duas solicitações simultâneas.
2. Aprovação por usuário sem permissão.
3. Atualização da reserva sem registro correspondente de auditoria.

**Status:** hipóteses arquiteturais; ainda sem evidência de execução ou testes.
