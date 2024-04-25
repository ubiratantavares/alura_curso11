package modulo2.aula.modelos;

import modulo2.aula.util.Classificavel;

public class Episodio implements Classificavel {

    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public Episodio(int numero, String nome, Serie serie) {
        this.numero = numero;
        this.nome = nome;
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    @Override
    public int getClassificacao() {
        if (this.totalVisualizacoes > 100) {
            return 4;
        }
        return 2;
    }
}
