package service;

import model.TipoTransacao;
import model.Transacao;
import repository.TransacaoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public void adicionar(Transacao transacao) {
        repository.salvar(transacao);
    }

    public List<Transacao> listar() {
        return repository.listarTodas();
    }

    public BigDecimal calcularSaldo() {
        BigDecimal saldo = BigDecimal.ZERO;
        for (Transacao t : listar()) {
            if (t.getTipo() == TipoTransacao.RECEITA) {
                saldo = saldo.add(t.getValor());
            } else {
                saldo = saldo.subtract(t.getValor());
            }
        }
        return saldo;
    }
}
