package modulo4.aula.util;

import modulo4.aula.modelos.Titulo;
import modulo4.aula.modelos.TituloOMDb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    public List<Titulo> handleInput() throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String pesquisa;
        List<Titulo> titulos = new ArrayList<>();
        while (true) {
            System.out.println("Digite o titulo de um filme para busca: ");
            pesquisa = leitura.nextLine();
            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            TituloOMDb tituloOmdb = new APIClient().fetchTituloOMDb(pesquisa);
            Titulo titulo = new TituloConverter().convertToTitulo(tituloOmdb);
            titulos.add(titulo);
        }
        return titulos;
    }
}
