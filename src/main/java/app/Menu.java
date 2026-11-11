package app;

import model.Transacao;
import service.TransacaoService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final TransacaoService service;

    private final Scanner scanner = new Scanner(System.in);

    public Menu(TransacaoService service) {
        this.service = service;
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println();
            System.out.println("=== Financeiro Pessoal ===");
            System.out.println("1. Listar transações");
            System.out.println("2. Ver saldo");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opcao: ");
            opcao = letInteiro();

            switch (opcao) {
                case 1 -> listarTransacoes();
                case 2 -> mostrarSaldo();
                case 0 -> System.out.println("Até mais!");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void listarTransacoes() {
        List<Transacao> transacoes = service.listar();
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada.");
            return;
        }
        for (Transacao t : transacoes) {
            System.out.println(t.getId() + " - " + t);
        }
    }

    private void mostrarSaldo() {
        System.out.println("Saldo atual: R$ " + service.calcularSaldo());
    }

    private int letInteiro() {
        String entrada = scanner.nextLine().trim();
        try {
            return Integer.parseInt(entrada);
        }  catch (NumberFormatException e) {
            return -1;
        }
    }
}
