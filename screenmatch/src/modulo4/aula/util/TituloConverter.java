package modulo4.aula.util;

import modulo4.aula.erro.ErroDeConversaoDeAnoException;
import modulo4.aula.modelos.Titulo;
import modulo4.aula.modelos.TituloOMDb;

public class TituloConverter {
    public Titulo convertToTitulo(TituloOMDb tituloOMDb) throws ErroDeConversaoDeAnoException {
        return new Titulo(tituloOMDb);
    }
}

