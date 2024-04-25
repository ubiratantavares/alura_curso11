package modulo5.aula.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEP {

    public boolean validarFormatoPadrao(String cep) {
        // Expressão regular para validar CEP no formato "12345678"
        String regex = "\\d{8}";

        // Compilando a expressão regular
        Pattern pattern = Pattern.compile(regex);

        // Criando um Matcher para o CEP fornecido
        Matcher matcher = pattern.matcher(cep);

        // Verificando se o CEP corresponde ao padrão
        return matcher.matches();
    }
    public EnderecoAPI pesquisar(String cep) {
        URI enderecoEletronico = URI.create(String.format("https://viacep.com.br/ws/%s/json/", cep));
        HttpRequest request = HttpRequest.newBuilder().uri(enderecoEletronico).build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), EnderecoAPI.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter o endereço eletrônico a partir deste CEP");
        }
    }
}
