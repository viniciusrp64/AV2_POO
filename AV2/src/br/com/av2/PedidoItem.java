package br.com.av2;

public class PedidoItem {
    private Evento evento;
    private int qtdeIngresso;
    private double precoIngresso;

    // Construtor que inicializa todos os atributos da classe
    public PedidoItem(Evento evento, int qtdeIngresso, double precoIngresso) {
        this.evento = evento;
        this.qtdeIngresso = qtdeIngresso;
        this.precoIngresso = precoIngresso;
    }

    public PedidoItem(Evento eventoSelecionado, int qtdeIngressos) {
        this.evento = eventoSelecionado;
        this.qtdeIngresso = qtdeIngressos;
        // Supondo que o preço do ingresso é obtido do evento
        this.precoIngresso = eventoSelecionado.getPrecoEvento();
    }



    // Método para atualizar o estoque de ingressos do evento
    public void atualizaEstoqueIngresso() {
        int estoqueAtual = evento.getQtdeIngresso() - this.qtdeIngresso;
        evento.setQtdeIngresso(estoqueAtual);
    }

    // Getters e Setters para todos os atributos
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getQtdeIngresso() {
        return qtdeIngresso;
    }

    public void setQtdeIngresso(int qtdeIngresso) {
        this.qtdeIngresso = qtdeIngresso;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
}

