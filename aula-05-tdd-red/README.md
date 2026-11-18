# Aula 05 — Gestão de Erros e Bugs / TDD (fase RED)

**Atividade reconstruída**, com base no [material da Aula 05](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/material/material_gestao-erros-bugs.html) e na [especificação do projeto Organização de Recursos](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/especificacao-projeto.html).

O professor solicita: (1) inventariar as regras de negócio em `docs/testes/plano-tdd.md`, citando sua fonte; (2) escrever testes JUnit 5 para os casos do plano, sem implementar as regras; (3) executar a suíte e confirmar as falhas esperadas. **Esta reconstrução cobre apenas um subconjunto demonstrativo das regras oficiais, e a suíte NÃO foi executada ou verificada.** As atividades de inspeção integral do repositório e confirmação das falhas permanecem pendentes.

## Conteúdo
- `pom.xml`: estrutura Maven com JUnit 5.
- `src/main/java/.../ReservaService.java`: assinaturas e implementação deliberadamente incompleta (fase RED).
- `src/test/java/.../ReservaServiceTest.java`: testes unitários para regras críticas de reservas.
- `docs/testes/plano-tdd.md`: inventário rastreável dos casos selecionados.
- `docs/testes/evidencia-red.md`: roteiro de verificação sem evidência inventada.
- `.github/ISSUE_TEMPLATE/relato-defeito.md`: modelo de relato de defeito.
- `docs/prompts-da-aula.md`: síntese dos prompts do professor e referência ao original.

## Execução opcional
Abra esta pasta no terminal e rode `mvn test`, com Java 21 e Maven instalados. A intenção da fase RED é que os testes compilem mas falhem por `UnsupportedOperationException`. **Não há execução comprovada neste repositório.** A fase GREEN fica para a Aula 06.

## Observação sobre a continuidade
Este módulo Java é independente do exemplo Python da Aula 03. Para as aulas seguintes, a intenção é evoluir **este mesmo código Java**, em vez de criar um módulo de produção novo a cada aula. Não confunda a reconstrução com uma entrega realizada no semestre.
