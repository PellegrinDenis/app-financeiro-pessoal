package app;

import model.Categoria;
import model.TipoTransacao;
import model.Transacao;
import service.TransacaoService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Transacao salario = new Transacao(
                "Salário de Setembro",
                new BigDecimal("2500.00"),
                LocalDate.of(2026, 9, 5),
                TipoTransacao.RECEITA,
                Categoria.SALARIO
        );

        Transacao mercado = new Transacao(
                "Compras do mês",
                new BigDecimal("320.50"),
                LocalDate.now(),
                TipoTransacao.DESPESA,
                Categoria.ALIMENTACAO
        );

        TransacaoService service = new TransacaoService();
        service.adicionar(salario);
        service.adicionar(mercado);

        for (Transacao t : service.listar()) {
            System.out.println(t);
        }

        System.out.println("Saldo: R$ " + service.calcularSaldo());

    }
}
