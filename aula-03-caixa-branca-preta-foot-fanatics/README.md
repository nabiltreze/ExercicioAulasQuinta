# Aula 03 — Caixa Branca, Caixa Preta e Foot Fanatics

Reconstrução educacional baseada no [material da Aula 03 do professor Afonso LeLis](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/material/material_caixa-branca-preta.html).

## Parte 1 — Laboratório com Python / pytest

O diretório `laboratorio/` traz um modelo simples de acesso a conteúdo e testes de:

- Particionamento de equivalência (planos free, premium e inválido);
- Valores limite (1799, 1800 e 1801 segundos);
- Tabela de decisão (sessão, assinatura e conteúdo exclusivo).

### Rodar, caso queira validar depois

```bash
python -m pip install -r requirements.txt
cd laboratorio
python -m pytest -v --cov=acesso --cov-branch --cov-report=term-missing
```

A função contém um ramo adicional para renovação de sessão que esses testes não exercitam. O exercício de caixa branca consiste em notar o ramo no relatório e questionar sua origem. Não foram registrados resultados fictícios de execução.

### Experimento sugerido pelo material (não realizado)

1. Alterar temporariamente o comparador do tempo de sessão de `>` para `>=` e observar o teste no limite.
2. Desativar temporariamente a verificação de assinatura e observar o teste de plano free.
3. Comparar a cobertura de um teste sem `assert` com sua capacidade de detectar defeitos.
4. Reverter as mudanças após cada experimento.

## Parte 2 — Preparação do Foot Fanatics

`docs/` contém os **esqueletos** de PRD, arquitetura e plano de teste pedidos na aula. Os dados das três personas realizadas anteriormente ainda precisam ser recuperados.

**Ainda não feito neste pacote:** instalação do AIOX (`npx aiox-core@latest install`), geração do Spring Boot Java 21/Maven no Spring Initializr, configuração PostgreSQL e execução de testes Java. Não é correto afirmar que já foram configurados.

Configuração prescrita no material: Group `br.senac`, Artifact `foot-fanatics`, Java 21, Spring Boot 3.x e dependências Spring Web, Spring Security, Spring Data JPA, Validation, PostgreSQL Driver e Testcontainers.

## Estado

- [x] Reconstrução de laboratório com código e testes escritos
- [x] Esqueletos de documentação inicial
- [ ] Testes executados/validados
- [ ] AIOX instalado
- [ ] Aplicação Spring Boot gerada e executada
- [ ] Três personas originais incorporadas ao PRD

O pacote foi preparado para envio manual via **GitHub → Add file → Upload files**, como um commit de reconstrução da Aula 03.
