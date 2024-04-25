package modulo4.principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modulo4.aula.erro.ErroDeConversaoDeAnoException;
import modulo4.aula.modelos.Titulo;
import modulo4.aula.modelos.TituloOMDb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String pesquisa;
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true) {
            System.out.println("Digite o titulo de um filme para busca: ");
            pesquisa = leitura.nextLine();
            if (pesquisa.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                String endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=201cedb8",
                        pesquisa.replace(" ", "_"));
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().
                        uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);
                TituloOMDb tituloOmdb = gson.fromJson(json, TituloOMDb.class);
                System.out.println(tituloOmdb);
                Titulo titulo = new Titulo(tituloOmdb);
                titulos.add(titulo);
            } catch (NumberFormatException | ErroDeConversaoDeAnoException e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço da URL: " + e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }
}
