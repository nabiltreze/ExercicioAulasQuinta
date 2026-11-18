# Prompts usados como referência — Aula 05

O [material original](https://afonsolelis.github.io/aulas_senac/pages/qualidade2/material/material_gestao-erros-bugs.html) traz dois prompts completos para uso com IA agêntica e terminal.

1. **Inventário:** localizar arquivos de personas, requisitos, regras, arquitetura, ADRs, código e testes; apenas inspecionar; gerar `docs/testes/plano-tdd.md` vinculando cada regra à origem, com casos positivos, limites, conflitos e estados proibidos. Registrar lacunas sem inventar regras.
2. **Fase RED:** reler a fonte, escrever testes com JUnit 5 e identificadores das regras, sem implementar a lógica; criar só assinaturas mínimas, executar a suíte, documentar as falhas e atualizar a rastreabilidade.

Este pacote recria uma **amostra** desse fluxo com base na especificação pública. Os prompts não foram executados por agente com acesso ao projeto da equipe. Para o texto literal dos prompts, consultar o link acima.
