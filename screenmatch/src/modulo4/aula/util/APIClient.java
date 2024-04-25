package modulo4.aula.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modulo4.aula.modelos.TituloOMDb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIClient {
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public TituloOMDb fetchTituloOMDb(String pesquisa) throws IOException, InterruptedException {
        String endereco = String.format("https://www.omdbapi.com/?t=%s&apikey=201cedb8", pesquisa.replace(" ", "_"));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        return gson.fromJson(json, TituloOMDb.class);
    }
}
