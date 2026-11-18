"""Testes didáticos da aula: equivalência, fronteira e tabela de decisão."""
import pytest
from acesso import Conteudo, Sessao, verificar_acesso


def sessao(plano="premium", segundos=20):
    return Sessao(plano=plano, segundos_desde_login=segundos)


@pytest.mark.parametrize("plano,resultado", [
    ("free", "ASSINATURA_NECESSARIA"),
    ("premium", "LIBERADO"),
    ("invalido", "PLANO_INVALIDO"),
])
def test_classes_equivalentes_de_plano(plano, resultado):
    assert verificar_acesso(sessao(plano), Conteudo(exclusivo=True)) == resultado


@pytest.mark.parametrize("segundos,resultado", [
    (1799, "LIBERADO"),
    (1800, "LIBERADO"),
    (1801, "SESSAO_INVALIDA"),
])
def test_limite_de_trinta_minutos(segundos, resultado):
    assert verificar_acesso(sessao(segundos=segundos), Conteudo(exclusivo=False)) == resultado


@pytest.mark.parametrize("autenticado,premium,exclusivo,resultado", [
    (False, False, False, "SESSAO_INVALIDA"),
    (True, False, False, "LIBERADO"),
    (True, False, True, "ASSINATURA_NECESSARIA"),
    (True, True, True, "LIBERADO"),
])
def test_tabela_de_decisao(autenticado, premium, exclusivo, resultado):
    usuario = sessao("premium" if premium else "free") if autenticado else None
    assert verificar_acesso(usuario, Conteudo(exclusivo=exclusivo)) == resultado
