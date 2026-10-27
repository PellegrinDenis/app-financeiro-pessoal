package service;

import model.TipoTransacao;
import model.Transacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransacaoService {

    private final List<Transacao> transacoes = new ArrayList<>();

    public void adicionar(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> listar() {
        return new ArrayList<>(transacoes);
    }

    public BigDecimal calcularSaldo() {
        BigDecimal saldo = BigDecimal.ZERO;
        for (Transacao t : transacoes) {
            if (t.getTipo() == TipoTransacao.RECEITA) {
                saldo = saldo.add(t.getValor());
            } else {
                saldo = saldo.subtract(t.getValor());
            }
        }
        return saldo;
    }
}
