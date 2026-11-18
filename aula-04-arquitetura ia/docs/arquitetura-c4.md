# Arquitetura proposta — Modelo C4 simplificado

## Contexto
```mermaid
flowchart LR
  Solicitante[Solicitante] --> Sistema[Sistema de Organização de Recursos]
  Responsavel[Responsável pelo recurso] --> Sistema
  Admin[Administrador] --> Sistema
```

## Contêineres
```mermaid
flowchart LR
  Usuario[Usuário web] --> API[API REST Spring Boot]
  API --> Servico[Serviços de reserva e aprovação]
  Servico --> BD[(Banco relacional)]
  Servico --> Auditoria[Registro de auditoria]
  Auditoria --> BD
```

## Responsabilidades (proposta)
- API: validação de entrada, autenticação e autorização na borda.
- Serviços: regras de horário, conflito, fluxo de aprovação e manutenção.
- Banco: persistência transacional; mecanismos de exclusão de sobreposição precisam ser definidos segundo o SGBD.
- Auditoria: registro imutável ou controlado de mudanças de estado.

**Status:** diagrama conceitual, não comprovadamente implementado.
