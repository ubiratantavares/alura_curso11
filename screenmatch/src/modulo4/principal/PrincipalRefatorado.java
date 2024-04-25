package modulo4.principal;

import modulo4.aula.modelos.Titulo;
import modulo4.aula.util.FileWriterHandler;
import modulo4.aula.util.InputHandler;

import java.io.IOException;
import java.util.List;

public class PrincipalRefatorado {
    public static void main(String[] args) {
        FileWriterHandler file = new FileWriterHandler();
        try {
            List<Titulo> titulos = new InputHandler().handleInput();
            file.writeToFile(titulos);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
