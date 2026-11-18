# Arquitetura atual e evolução

## Atual
API Spring Boot -> Controller -> ReservaService -> coleção em memória.

## Limites
- Estado perde-se ao reiniciar.
- synchronized funciona apenas nesta instância Java; não resolve concorrência em várias réplicas.
- Não há identidade, autorização, auditoria ou infraestrutura persistente.

## Próxima evolução (a implementar)
PostgreSQL + JPA, transação, constraint/locking para sobreposição, autenticação Spring Security, Testcontainers, WireMock e auditoria persistente.

## ADR-001 — Modelo didático
O protótipo inicial usa armazenamento em memória para exercitar primeiro as regras de intervalo e concorrência. Essa decisão **não** atende aos requisitos de produção nem substitui a implementação persistente exigida pelo projeto final.
