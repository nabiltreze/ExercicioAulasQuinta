# Requisitos propostos — Organização de Recursos

| ID | Requisito | Critério de aceite proposto |
|---|---|---|
| RF-01 | Solicitar reserva para um recurso | Um solicitante autorizado informa recurso, início e término |
| RF-02 | Impedir horários inválidos | Rejeitar término menor ou igual ao início |
| RF-03 | Impedir reserva sobreposta | Não permitir duas reservas ativas para o mesmo recurso em intervalos coincidentes |
| RF-04 | Bloquear recurso em manutenção | Solicitação de reserva não é aprovada para recurso indisponível |
| RF-05 | Controlar estados de reserva | Suportar SOLICITADA, APROVADA, EM_USO e CONCLUÍDA, mais estados alternativos aplicáveis |
| RF-06 | Registrar alterações | Transições de estado registram quem, quando e a mudança ocorrida |
| RNF-01 | Integridade concorrente | Em duas solicitações simultâneas conflitantes, no máximo uma é aceita |
| RNF-02 | Segurança de acesso | Apenas responsável autorizado pode aprovar recurso restrito |

**Observação:** esta é uma seleção resumida para o exercício, não o inventário integral dos 14 requisitos da especificação.
