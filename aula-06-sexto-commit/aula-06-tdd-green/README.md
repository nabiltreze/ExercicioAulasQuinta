# Aula 06 — TDD Green, GitHub Actions e ATAM

Reconstrucao didatica da Aula 06 do professor Afonso LeLis.

## Diferenca em relacao a Aula 05

- Aula 05: `ReservaService` lanca `UnsupportedOperationException` (RED).
- Aula 06: **os mesmos oito testes, copiados sem alteracoes**, acompanhados por uma implementacao com validacao de periodo, deteccao de conflito e bloqueio por manutencao (GREEN proposta).
- Os dois modulos estao separados para permitir o upload de cada aula pela interface do GitHub. Em um TDD real, a implementacao evoluiria sobre a mesma arvore de codigo.

## Como o GitHub Actions foi incluido

O arquivo **`.github/workflows/ci.yml` deve ficar na raiz do repositorio**, e nao dentro da pasta da aula. O ZIP ja vem com essa estrutura. O workflow verifica apenas `aula-06-tdd-green`, pois a Aula 05 esta propositalmente vermelha e nao deve ser incluida no build. O `setup-java` configura Java 21, usa cache Maven e publica resultados de testes como artifacts.

### Execucao local (opcional)

```bash
mvn -B -f aula-06-tdd-green/pom.xml verify
```

**Diferenca em relacao ao roteiro:** o professor pede `./mvnw -B verify`, mas o projeto reconstruido da Aula 05 nao continha Maven Wrapper. Para evitar um workflow que nao funciona por falta do wrapper, a versao do GitHub Actions usa o Maven ja disponivel no runner (`mvn -B -f ... verify`). Se voce acrescentar o Maven Wrapper em um projeto unico, podera adaptar o workflow para o comando literal do roteiro.

## O que nao esta comprovado

- Nao foi executado Maven nem foram obtidos resultados de testes.
- Nao foram abertos PRs e nao foram registrados IDs de runs.
- Nao foi provocada a falha intencional nem configurada protecao da main.
- O ATAM e preliminar e nao substitui uma avaliacao baseada em evidencias do projeto completo.

Documentacao: `docs/testes/plano-tdd.md`, `docs/avaliacao-arquitetural/ciclo-01.md` e `docs/prompts-originais-referencia.md`.

Fonte: https://afonsolelis.github.io/aulas_senac/pages/qualidade2/material/material_ci-github-actions.html
