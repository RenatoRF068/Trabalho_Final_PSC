public class Movimentacao {
    private Produto produto;
    private int quantidade;
    private String tipo; // "Entrada" ou "Saída"

    public Movimentacao(Produto produto, int quantidade, String tipo) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    // Getters e Setters

    @Override
    public String toString() {
        return "Movimentacao{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}