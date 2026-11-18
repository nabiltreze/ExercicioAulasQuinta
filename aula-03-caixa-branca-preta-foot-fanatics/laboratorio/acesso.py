"""Modelo didático de autorização de conteúdo do Foot Fanatics (Aula 03)."""
from dataclasses import dataclass

TEMPO_MAXIMO = 30 * 60
PLANOS_VALIDOS = {"free", "premium"}


@dataclass(frozen=True)
class Sessao:
    plano: str
    segundos_desde_login: int
    renovacoes: int = 0


@dataclass(frozen=True)
class Conteudo:
    exclusivo: bool


def verificar_acesso(sessao: Sessao | None, conteudo: Conteudo) -> str:
    """Retorna um código de decisão, permitindo testar limites e ramos."""
    if sessao is None or sessao.segundos_desde_login > TEMPO_MAXIMO:
        return "SESSAO_INVALIDA"
    if sessao.plano not in PLANOS_VALIDOS:
        return "PLANO_INVALIDO"
    if conteudo.exclusivo and sessao.plano != "premium":
        return "ASSINATURA_NECESSARIA"
    # Regra adicional intencional: detectar caminhos não cobertos no relatório.
    if sessao.renovacoes > 3:
        return "SESSAO_INVALIDA"
    return "LIBERADO"
