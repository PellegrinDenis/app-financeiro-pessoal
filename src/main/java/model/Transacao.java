package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

    private String descricao;
    private LocalDate data;
    private BigDecimal valor;
    private Categoria categoria;
    private TipoTransacao tipo;

    public Transacao(String descricao, BigDecimal valor, LocalDate data, TipoTransacao tipo, Categoria categoria) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    @Override
    public String toString() {
        return data + " | " + tipo + " | " + categoria + " | " + descricao + " | R$" + valor;
    }


}