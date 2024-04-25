package modulo2.aula.util;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() > 4) {
            System.out.println("Está entre os preferidos do momento.");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Está bem avaliado no momento.");
        } else {
            System.out.println("Coloque em sua lista para assistir depois.");
        }
    }
}
