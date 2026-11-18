# Utility Tree — Sistema de Reservas de Recursos

Raiz: **Utilidade / Qualidade do sistema**.

A escala (I,D) representa **Importância** para o negócio e **Dificuldade** de atender ao cenário: A = alta, M = média, B = baixa.

| ID | Atributo ISO/IEC 25010 | Refinamento | Cenário folha (mensurável) | (I,D) | Justificativa |
|---|---|---|---|---|---|
| CEN-01 | Adequação funcional | Correção de reservas | Ao receber duas tentativas de reservar o mesmo recurso no mesmo horário, o sistema confirma exatamente 1 e rejeita 1. | (A,A) | Reserva duplicada compromete a operação; concorrência exige controle transacional. |
| CEN-02 | Segurança | Controle de acesso | Um usuário sem permissão que consulte 10 reservas de terceiros recebe acesso negado em 100% das tentativas. | (A,A) | Exposição de dados é crítica; autorização deve proteger cada recurso. |
| CEN-03 | Eficiência de performance | Tempo de resposta | Sob 100 usuários simultâneos, ao menos 95% das consultas de disponibilidade respondem em até 2 s. | (A,A) | Lentidão em horários de pico impede o uso; depende da consulta ao banco e da carga. |
| CEN-04 | Confiabilidade | Recuperação | Após interrupção de um serviço, a API recupera operação em até 5 min, preservando 100% das reservas confirmadas. | (A,M) | Recuperação é importante, mas a infraestrutura pode usar persistência e reinício controlado. |
| CEN-05 | Manutenibilidade | Modularidade | Alterar a política de cancelamento exige mudanças em no máximo 2 módulos de código. | (M,M) | Alterações de regra são frequentes; modularidade reduz retrabalho. |
| CEN-06 | Capacidade de interação | Facilidade de uso | Em teste com 5 pessoas novas, pelo menos 4 realizam uma reserva sem ajuda em até 3 min. | (M,B) | O fluxo principal deve ser compreensível e pode ser simplificado pela interface. |

> As metas são hipóteses de engenharia propostas para a atividade, **não resultados medidos**.

## Representação textual da árvore

```text
Utilidade
├── Adequação funcional
│   └── Correção → CEN-01 (A,A)
├── Segurança
│   └── Controle de acesso → CEN-02 (A,A)
├── Eficiência de performance
│   └── Tempo de resposta → CEN-03 (A,A)
├── Confiabilidade
│   └── Recuperação → CEN-04 (A,M)
├── Manutenibilidade
│   └── Modularidade → CEN-05 (M,M)
└── Capacidade de interação
    └── Facilidade de uso → CEN-06 (M,B)
```

## Vínculo com a Aula 01

O enunciado pede retomar cinco achados diagnosticados no projeto da Aula 01. **Pendente:** associar os achados reais depois de revisar a análise do código e o relatório da primeira atividade. Não foram criados achados falsos para preencher essa lacuna.
