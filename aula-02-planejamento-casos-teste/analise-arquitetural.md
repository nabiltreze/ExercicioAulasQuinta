# Análise arquitetural simplificada (ATAM)

## Ponto de sensibilidade

**Parâmetro:** estratégia de bloqueio e isolamento transacional na persistência de reservas. Uma alteração na estratégia afeta diretamente a taxa de reservas duplicadas sob concorrência (CEN-01). Caso não haja exclusão/controle no ponto de gravação, duas solicitações podem enxergar o mesmo recurso como livre.

## Ponto de trade-off

**Conflito:** consistência da reserva × tempo de resposta. Aumentar a serialização e os bloqueios transacionais reduz a chance de conflitos não detectados, mas pode elevar a latência quando vários usuários reservam o mesmo recurso. A decisão exige medir CEN-01 e CEN-03 juntos.

## Não-risco condicional

**Decisão:** manter histórico das reservas em banco persistente, em vez de armazená-las apenas em memória da aplicação. **Premissa:** o banco tem backups e recuperação verificados. Sob essa premissa, reiniciar a aplicação não deve apagar reservas confirmadas. Se a premissa falhar, o não-risco deixa de ser válido.

Estes itens representam uma análise *proposta* de arquitetura, sem inspeção ou validação de implementação.
