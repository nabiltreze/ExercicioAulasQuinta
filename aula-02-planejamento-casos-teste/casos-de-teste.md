# Casos de teste derivados dos cenários ATAM

## CT-01 — Concorrência em reserva do mesmo recurso

- **ID:** CT-01
- **Título:** impedir duas reservas do mesmo recurso e horário.
- **Pré-condições:** API e banco disponíveis; recurso `SALA-101` livre de 10:00 a 11:00 em 2026-12-10; dois usuários autenticados e habilitados.
- **Dados de entrada:** recurso `SALA-101`, início `2026-12-10T10:00`, fim `2026-12-10T11:00`, usuários `U001` e `U002`.
- **Passos:** (1) limpar reservas do intervalo; (2) disparar dois POSTs de reserva simultaneamente; (3) aguardar as respostas; (4) consultar reservas persistidas no intervalo.
- **Resultado esperado:** uma solicitação aceita, uma negada por conflito, exatamente uma reserva persistida.
- **Rastreabilidade:** CEN-01.
- **Status:** não executado.

## CT-02 — Negar leitura de reservas de terceiros

- **ID:** CT-02
- **Título:** impedir consulta indevida a reservas de outro usuário.
- **Pré-condições:** API disponível; usuário `U001` autenticado sem privilégio administrativo; dez reservas de `U002` previamente criadas.
- **Dados de entrada:** token de `U001` e IDs `R001` a `R010`, pertencentes a `U002`.
- **Passos:** (1) autenticar `U001`; (2) fazer GET para cada ID de reserva; (3) registrar código HTTP e corpo das dez respostas.
- **Resultado esperado:** dez respostas de acesso negado conforme política adotada; nenhum conteúdo privado de `U002` revelado.
- **Rastreabilidade:** CEN-02.
- **Status:** não executado.

## CT-03 — Tempo de consulta de disponibilidade

- **ID:** CT-03
- **Título:** validar desempenho da API com 100 usuários simultâneos.
- **Pré-condições:** ambiente de homologação estável, API no ar, banco com pelo menos 1.000 reservas de teste; ferramenta de carga configurada.
- **Dados de entrada:** endpoint `GET /recursos/disponibilidade?data=2026-12-10`, 100 usuários virtuais, duração de 5 minutos, autenticações de teste válidas.
- **Passos:** (1) inicializar o ambiente; (2) executar teste de carga por cinco minutos com 100 usuários virtuais; (3) coletar latências e taxa de erros; (4) calcular p95.
- **Resultado esperado:** p95 de no máximo 2.000 ms e taxa de erros inferior a 1%.
- **Rastreabilidade:** CEN-03.
- **Status:** não executado.

**Observação:** URLs, rotas, códigos de erro e IDs são exemplos. Ajustar aos endpoints e contratos efetivos do projeto antes da execução.
