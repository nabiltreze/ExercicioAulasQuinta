# Relatório de diagnóstico de qualidade — Aula 01

**Disciplina:** Qualidade de Software — 2026.2  
**Projeto analisado:** https://github.com/afonsolelis/qualidade_software  
**Referência:** ISO/IEC 25010 (modelo com nove características apresentado na aula)  
**Situação:** análise inicial, **não concluída**.

## 1. Execução da suíte de testes

Não executada nesta reconstrução. Não há log nem contagens verificadas.

| Situação | Quantidade |
| --- | --- |
| Aprovados | Não apurado |
| Falhos | Não apurado |
| Ignorados (skipped) | Não apurado |
| Funcionalidades sem testes | Ainda não inspecionadas |

Comando indicado no README do projeto-base: `mvn test` (ou `./mvnw test` em sistemas compatíveis). O resultado deve ser anexado aqui **somente após uma execução real**.

## 2. Achados

### Achado 01 — Informação sensível exposta no README público

- **Onde:** `README.md`, seção de conexão ao banco de dados do repositório do professor, que publica uma URI de conexão com usuário e senha embutidos.
- **Problema:** uma credencial de conexão é disponibilizada em documentação pública. Mesmo quando destinada ao ensino ou já revogada, esta prática normaliza o versionamento de segredos.
- **Impacto:** risco de uso indevido das credenciais caso ainda estejam válidas e de exposição do banco associado.
- **ISO/IEC 25010:** **Segurança**, sobretudo confidencialidade.
- **Prioridade proposta:** **Alta**, pela possibilidade de acesso não autorizado, condicionada à validade e às permissões da credencial.
- **Recomendação (não implementada nesta atividade):** revogar/rotacionar o segredo se ativo, removê-lo do histórico e usar variáveis de ambiente ou gerenciador de segredos.
- **Nota de verificação:** o README público foi consultado; **não foi testada a validade da credencial** e nenhum acesso ao banco foi realizado. A credencial não é reproduzida neste relatório.

### Achados 02 a 05 — Pendentes de inspeção do código

O enunciado exige pelo menos cinco achados. Os outros quatro não foram inventados: sua identificação requer inspecionar o código e a suíte do projeto-base.

| Nº | Localização | Problema e evidência | Característica ISO/IEC 25010 | Prioridade e justificativa |
| --- | --- | --- | --- | --- |
| 02 | A verificar | A verificar | A definir | A definir |
| 03 | A verificar | A verificar | A definir | A definir |
| 04 | A verificar | A verificar | A definir | A definir |
| 05 | A verificar | A verificar | A definir | A definir |

## 3. Critério de priorização

Sugestão para a conclusão do relatório: priorizar pela combinação de **impacto**, **probabilidade de ocorrência**, **exposição dos usuários/dados** e **dificuldade de detecção**. A ordem final só poderá ser definida depois da confirmação dos cinco achados.

## 4. Conclusão parcial

Até aqui, foi identificado um risco de segurança verificável no README público do projeto-base. Sem inspeção completa do repositório e sem execução dos testes, não é possível concluir sobre cobertura, falhas observadas ou qualidade geral do software.

## Fontes

- Enunciado: https://afonsolelis.github.io/aulas_senac/pages/qualidade2/material/material_introducao-qualidade.html
- Projeto-base e README: https://github.com/afonsolelis/qualidade_software
