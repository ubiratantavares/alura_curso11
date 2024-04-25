package modulo5.aula.arquivo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modulo5.aula.modelos.EnderecoAPI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

    public void salvarJson(EnderecoAPI endereco) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        FileWriter arquivoJson = new FileWriter(String.format("..//modulo5//aula//arquivo/%s.json", endereco.cep()));
        arquivoJson.write(gson.toJson(endereco));
        arquivoJson.close();
    }
}
