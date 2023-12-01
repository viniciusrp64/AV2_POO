package br.com.av2;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private Date dataHoraPedido;
    private double precoTotal;
    private int statusPedido; // Suponho que haja um sistema de status definidos por inteiros
    private List<PedidoItem> itens;

    // Construtor que age como o método inserirPedido, inicializando todos os atributos
    public Pedido(int numeroPedido, Date dataHoraPedido, double precoTotal, int statusPedido) {
        this.numeroPedido = numeroPedido;
        this.dataHoraPedido = dataHoraPedido;
        this.precoTotal = precoTotal;
        this.statusPedido = statusPedido;
        this.itens = new ArrayList<>();
    }

    public static final int STATUS_EM_PROCESSAMENTO = 1;
    public static final int STATUS_COMPLETO = 2;

    // Método para alterar o status do pedido
    public void alterarStatus(int novoStatus) {
        this.statusPedido = novoStatus;
    }

    // Método para consultar o pedido comparando o número do pedido
    public boolean consultarPedido(Pedido outroPedido) {
        return this.numeroPedido == outroPedido.numeroPedido;
    }

    // Método para inserir itens ao pedido
    public void inserirItensPedido(PedidoItem item) {
        this.itens.add(item);
    }

    // Método para excluir itens do pedido
    public void excluirItensPedido(PedidoItem item) {
        this.itens.remove(item);
    }

    // Método para calcular o total a pagar
    public double calculaTotalPagar() {
        double total = 0.0;
        for (PedidoItem item : itens) {
            total += item.getPrecoIngresso() * item.getQtdeIngresso();
        }
        this.precoTotal = total; // Atualiza o atributo precoTotal
        return total;
    }


    // Getters e Setters para todos os atributos
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Date getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(Date dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }


    // Não é costumeiro fornecer um setter para listas em uma relação de agregação
    // em vez disso, métodos para manipular a lista são fornecidos (como inserirItensPedido e excluirItensPedido)
}
