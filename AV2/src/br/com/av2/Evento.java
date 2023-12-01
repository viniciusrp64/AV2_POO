package br.com.av2;

import java.util.Date;

public class Evento {
    private String nomeEvento;
    private Date dataEvento;
    private double precoEvento;
    private String descEvento;
    private int qtdeIngresso;
    private Categoria categoria;

    // Construtor que age como o método inserirEvento, inicializando todos os atributos
    public Evento(String nomeEvento, Date dataEvento, double precoEvento, String descEvento, int qtdeIngresso, Categoria categoria) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.precoEvento = precoEvento;
        this.descEvento = descEvento;
        this.qtdeIngresso = qtdeIngresso;
        this.categoria = categoria;
    }

    // Getters e Setters para todos os atributos
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    public String getDescEvento() {
        return descEvento;
    }

    public void setDescEvento(String descEvento) {
        this.descEvento = descEvento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Método buscarEvento que compara o nome do evento com outro objeto Evento
    public boolean buscarEvento(Evento evento) {
        return this.nomeEvento.equals(evento.getNomeEvento());
    }
}
