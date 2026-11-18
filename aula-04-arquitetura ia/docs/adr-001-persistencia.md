# ADR-001 — Persistência transacional de reservas

- **Status:** proposto, não aprovado
- **Data:** 2026-11-18 (data de reconstrução)

## Contexto
O sistema precisa impedir reservas conflitantes do mesmo recurso, inclusive com solicitações concorrentes, além de registrar mudanças de estado para auditoria.

## Decisão proposta
Avaliar um banco relacional com transações e uma estratégia explícita de consistência concorrente para a gravação de reservas. Escolher a técnica concreta (bloqueio pessimista, restrição no banco ou mecanismo equivalente) após estudo do SGBD e teste de concorrência.

## Alternativas
- Verificação somente na aplicação: simples, mas vulnerável a condições de corrida se não houver proteção transacional.
- Bloqueio transacional e/ou restrição no banco: maior garantia de integridade, com possível custo de contenção.

## Consequências
**Positivas:** possibilidade de garantir atomicidade e preservar integridade.
**Negativas:** exige testes de concorrência, conhecimento do SGBD e observação de desempenho.

## Validação futura
Teste automatizado com requisições concorrentes; confirmar que uma única reserva conflitante é aceita e que os dados permanecem consistentes.
