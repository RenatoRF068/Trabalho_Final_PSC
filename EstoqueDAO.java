import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    private static final String ARQUIVO_ESTOQUE = "estoque.txt";

    public static void salvarEstoque(List<Produto> produtos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Produto produto : produtos) {
                writer.println(produto.getNome() + "," +
                        produto.getTipo() + "," +
                        produto.getQuantidade() + "," +
                        produto.getPreco());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o estoque: " + e.getMessage());
        }
    }

    public static List<Produto> carregarEstoque() {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_ESTOQUE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                produtos.add(new Produto(partes[0], partes[1],
                        Integer.parseInt(partes[2]), Double.parseDouble(partes[3])));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o estoque: " + e.getMessage());
        }
        return produtos;
    }
}