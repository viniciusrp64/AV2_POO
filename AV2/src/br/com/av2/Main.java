package br.com.av2;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação das categorias
        Categoria categoriaConcerto = new Categoria("Concerto");
        Categoria categoriaTeatro = new Categoria("Teatro");
        Categoria categoriaEsporte = new Categoria("Esporte");
        Categoria categoriaCinema = new Categoria("Cinema");
        Categoria categoriaFestival = new Categoria("Festival");

        // Lista de eventos
        ArrayList<Evento> listaEventos = new ArrayList<>();
        listaEventos.add(new Evento("Rock in Rio", new Date(), 500.0, "Festival de música", 1000, categoriaFestival));
        listaEventos.add(new Evento("Jogo de Futebol - Final", new Date(), 150.0, "Campeonato Brasileiro", 800, categoriaEsporte));
        listaEventos.add(new Evento("Peça Hamlet", new Date(), 200.0, "Peça de teatro clássica", 300, categoriaTeatro));
        listaEventos.add(new Evento("Concerto de Piano", new Date(), 350.0, "Concerto de música clássica", 200, categoriaConcerto));
        listaEventos.add(new Evento("Estreia do Filme 'Aventura no Espaço'", new Date(), 50.0, "Estreia mundial", 500, categoriaCinema));

        // Lista de pedidos
        ArrayList<Pedido> listaPedidos = new ArrayList<>();

        System.out.println("Bem-vindo ao sistema de pedidos de ingressos!");

        // Criar pedidos com base na entrada do usuário
        System.out.println("Quantos pedidos você gostaria de criar?");
        int numeroDePedidos = scanner.nextInt();

        for (int i = 1; i <= numeroDePedidos; i++) {
            System.out.println("Criando Pedido " + i);
            Pedido pedido = new Pedido(i, new Date(), 0.0, Pedido.STATUS_EM_PROCESSAMENTO);

            System.out.println("Quantos itens deseja adicionar ao pedido?");
            int numeroDeItens = scanner.nextInt();

            for (int j = 0; j < numeroDeItens; j++) {
                System.out.println("Selecione o evento para o item " + (j + 1) + ":");
                for (int k = 0; k < listaEventos.size(); k++) {
                    Evento evento = listaEventos.get(k);
                    System.out.println((k + 1) + ": " + evento.getNomeEvento() + " - Preço: " + evento.getPrecoEvento());
                }

                int escolhaEvento = scanner.nextInt();
                while (escolhaEvento < 1 || escolhaEvento > listaEventos.size()) {
                    System.out.println("Seleção inválida. Por favor, escolha um número entre 1 e " + listaEventos.size());
                    escolhaEvento = scanner.nextInt();
                }
                Evento eventoSelecionado = listaEventos.get(escolhaEvento - 1);

                System.out.println("Você selecionou: " + eventoSelecionado.getNomeEvento());
                System.out.println("Quantos ingressos você deseja comprar?");
                int qtdeIngressos = scanner.nextInt();

                PedidoItem item = new PedidoItem(eventoSelecionado, qtdeIngressos);
                item.atualizaEstoqueIngresso(); // Supondo que exista um método para adicionar itens ao pedido

                pedido.inserirItensPedido(item);
                // Atualizar a quantidade de ingressos do evento
            }

            // Calcular o total do pedido e atualizar o status
            pedido.calculaTotalPagar();
            pedido.alterarStatus(Pedido.STATUS_COMPLETO); // Supondo que exista um método para atualizar o status

            // Adicionando o pedido à lista de pedidos
            listaPedidos.add(pedido);


            double totalPagar = pedido.calculaTotalPagar();
            pedido.setPrecoTotal(totalPagar);

            System.out.println("Pedido " + (i+1) + " criado com sucesso!");

            System.out.println("O valor total do Pedido " + (i+1) + " é: R$ " + pedido.calculaTotalPagar());
        }

        // Finalizando
        System.out.println("Todos os pedidos foram criados. Obrigado por usar nosso sistema!");

        scanner.close();
    }
}
