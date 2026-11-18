# Plano TDD reconstruído

## Cenários iniciais
- Dado recurso livre, quando solicito período válido, então uma reserva é criada.
- Dado recurso reservado, quando solicito período sobreposto, então a tentativa é negada.
- Dado recurso livre, quando solicito período adjacente, então a reserva é permitida.
- Dado recurso em manutenção, quando solicito reserva, então ela é negada.
- Dadas 20 solicitações simultâneas, somente uma deve ser aceita.

## Evidência histórica
**Não disponível.** Os arquivos atuais foram reconstruídos; não existe comprovação de commits Red → Green → Refactor originais. Para registrar um novo ciclo, crie branches e commits reais.
