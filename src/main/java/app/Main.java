package app;

import repository.ConexaoBanco;
import repository.TransacaoRepository;
import service.TransacaoService;

public class Main {

    public static void main(String[] args) {

        ConexaoBanco.criarTabelas();

        TransacaoRepository repository = new TransacaoRepository();
        TransacaoService service = new TransacaoService(repository);

        Menu menu = new Menu(service);

        menu.iniciar();
    }
}
