package modulo4.aula.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modulo4.aula.modelos.Titulo;

import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class FileWriterHandler {
    private final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public void writeToFile(List<Titulo> titulos) throws IOException {
            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
    }
}
