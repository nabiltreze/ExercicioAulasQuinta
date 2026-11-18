# Três cenários ATAM prioritários (A,A)

## CEN-01 — Impedir reserva duplicada

1. **Fonte do estímulo:** dois usuários autenticados.
2. **Estímulo:** envios simultâneos de solicitação para o mesmo recurso e intervalo.
3. **Ambiente:** operação normal, recurso inicialmente disponível, banco de dados ativo.
4. **Artefato:** serviço de reservas e persistência.
5. **Resposta:** aceitar uma solicitação e negar a outra por conflito de horário.
6. **Medida da resposta:** exatamente uma reserva confirmada e uma negada; zero duplicidades persistidas.

## CEN-02 — Bloquear acesso indevido

1. **Fonte do estímulo:** usuário autenticado sem permissão sobre reservas de terceiros.
2. **Estímulo:** dez consultas a IDs pertencentes a outros usuários.
3. **Ambiente:** operação normal, usuário com perfil básico, reservas já cadastradas.
4. **Artefato:** endpoint de consulta, camada de autorização e serviço de reservas.
5. **Resposta:** rejeitar cada consulta sem revelar os dados da reserva.
6. **Medida da resposta:** 10 de 10 consultas bloqueadas (HTTP 403 ou 404 conforme política documentada); zero dados de terceiros retornados.

## CEN-03 — Responder consultas no pico

1. **Fonte do estímulo:** 100 usuários virtuais simultâneos.
2. **Estímulo:** requisições repetidas para consultar disponibilidade dos recursos.
3. **Ambiente:** ambiente de homologação com base de dados previamente populada e carga estável.
4. **Artefato:** API de disponibilidade e banco de dados.
5. **Resposta:** processar as consultas corretamente sem sobrecarregar o serviço.
6. **Medida da resposta:** 95% das respostas em até 2 segundos, com taxa de erro menor que 1%.

**Status:** especificações de teste planejadas. Nenhum resultado de execução é declarado.
