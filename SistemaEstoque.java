import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaEstoque {

    private static List<Produto> estoque = EstoqueDAO.carregarEstoque();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Gestão de Estoque ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Visualizar Estoque");
            System.out.println("3. Calcular Total do Estoque");
            System.out.println("4. Sair");

            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    adicionarProduto(scanner);
                    break;
                case 2:
                    visualizarEstoque();
                    break;
                case 3:
                    calcularTotalEstoque();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    EstoqueDAO.salvarEstoque(estoque); // Salvar o estoque antes de sair
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarProduto(Scanner scanner) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo do produto: ");
        String tipo = scanner.nextLine();
        System.out.print("Digite a quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do scanner

        Produto novoProduto = new Produto(nome, tipo, quantidade, preco);
        estoque.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void visualizarEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("\n--- Estoque ---");
        for (Produto produto : estoque) {
            System.out.println(produto);
        }
    }

    private static void calcularTotalEstoque() {
    double total = 0;
    for (Produto produto : estoque) {
        double preco = Double.parseDouble(produto.getPreco());
        int quantidade = Integer.parseInt(produto.getQuantidade());
        total += preco * quantidade;
    }
    System.out.println("\nTotal do estoque: R$ " + total);
}
}