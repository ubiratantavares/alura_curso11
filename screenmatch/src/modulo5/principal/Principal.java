package modulo5.principal;

import modulo5.aula.arquivo.Arquivo;
import modulo5.aula.modelos.CEP;
import modulo5.aula.modelos.EnderecoAPI;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        CEP cep = new CEP();
        System.out.println("Digite o número do CEP: ");
        String cepBuscado = leitura.nextLine();
        while (!cep.validarFormatoPadrao(cepBuscado)) {
            System.out.println("Número de CEP com formato inválido. Entre somente com 8 dígitos numéricos.");
            System.out.println("Digite o número do CEP: ");
            cepBuscado = leitura.nextLine();
        }
        try {
            EnderecoAPI enderecoApi = cep.pesquisar(cepBuscado);
            System.out.println(enderecoApi);
            Arquivo arquivoJson = new Arquivo();
            arquivoJson.salvarJson(enderecoApi);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizando o buscador de CEP.");
        }
    }
}
