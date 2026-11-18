# Qualidade de Software 2026.2 — reconstrução didática

> **Atenção:** reconstrução independente de atividades com base no hub público do professor Afonso LeLis. Não é uma submissão histórica, nem comprova execução/avaliação das atividades em aula. **Algumas atividades estão em roteiro, ainda não implementadas**.

## Contexto
- **Case de demonstração das aulas:** Foot Fanatics.
- **Projeto semestral avaliado:** Organização de Recursos (salas, professores e materiais).
- Este repositório usa Organização de Recursos como base e inclui um **protótipo executável parcial**.

## Funcionalidades implementadas no protótipo
- API REST para criar/listar reservas de recursos.
- Validação de intervalo e indisponibilidade por sobreposição.
- Bloqueio de manutenção em serviço.
- Testes unitários e parametrizados JUnit 5.
- Teste de concorrência de 20 solicitações: uma reserva aceita em uma única instância.
- Testes HTTP com MockMvc.
- Workflow de CI e JaCoCo (metas 80% linhas / 70% branches).

## Pendências importantes
Autenticação e autorização, persistência PostgreSQL, Testcontainers, WireMock, SonarCloud, Cucumber, JMeter, auditoria, notificações, relatórios, interface responsiva e outros requisitos **não estão implementados**. A CI só poderá ser atestada após execução no GitHub; metas de cobertura não foram verificadas localmente.

## Executar
Requisitos: JDK 21, Maven 3.9+.
```bash
mvn clean test
mvn clean verify
mvn spring-boot:run
```
Exemplo para API:
```bash
curl -X POST http://localhost:8080/api/reservas -H 'Content-Type: application/json' -d '{"recursoId":"sala-101","inicio":"2026-11-18T10:00:00","fim":"2026-11-18T11:00:00"}'
```

## Aulas / exercícios
A pasta [`atividades/`](atividades/) contém um roteiro **por aula** com tarefas e critérios de verificação. A pasta [`docs/`](docs/) reúne o planejamento e uma RTM inicial.

## Fontes oficiais
- [Hub das aulas](https://afonsolelis.github.io/aulas_senac/pages/home_qualidade_2026_2.html)
- [Especificação do projeto de Organização de Recursos](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/especificacao-projeto.html)

## Publicar no seu GitHub
1. Crie um repositório vazio no GitHub (não marque README ou .gitignore).
2. Descompacte o ZIP e abra a pasta em VS Code.
3. Execute os comandos:
```bash
git init
git add .
git commit -m "Reconstrucao inicial das atividades de Qualidade de Software"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
git push -u origin main
```
4. Confira o workflow em **Actions**. Se falhar, corrija conforme os logs; não declare testes verdes sem verificar.
