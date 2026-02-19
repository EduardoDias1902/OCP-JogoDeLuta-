package CódigoBaseCerto.model;
public class Bau {
    private String id;
    private String tipo; // Ex: "Lendário", "Comum", "Épico"
    private double valorBase;
    private int quantidadeItens;
    private String playerEmail;

    public Bau(String id, String tipo, double valorBase, int quantidadeItens, String playerEmail) {
        this.id = id;
        this.tipo = tipo;
        this.valorBase = valorBase;
        this.quantidadeItens = quantidadeItens;
        this.playerEmail = playerEmail;
    }

    // Getters
    public String getTipo() { return tipo; }
    public double getValorBase() { return valorBase; }
    public int getQuantidadeItens() { return quantidadeItens; }
    public String getPlayerEmail() { return playerEmail; }
    public String getId() { return id; }
}