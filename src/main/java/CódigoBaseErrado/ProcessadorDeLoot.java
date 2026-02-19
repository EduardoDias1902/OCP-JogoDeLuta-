package CódigoBaseErrado;

class Bau {
    private String id;
    private double valorBase;
    private int quantidadeItens;
    private boolean isAberto;
    private String playerEmail;

    public Bau(String id, double valorBase, int quantidadeItens, String playerEmail) {
        this.id = id;
        this.valorBase = valorBase;
        this.quantidadeItens = quantidadeItens;
        this.isAberto = false;
        this.playerEmail = playerEmail;
    }

    public String getId() { return id; }
    public double getValorBase() { return valorBase; }
    public int getQuantidadeItens() { return quantidadeItens; }
    public boolean isAberto() { return isAberto; }
    public void setAberto(boolean aberto) { isAberto = aberto; }
    public String getPlayerEmail() { return playerEmail; }
}

public class ProcessadorDeLoot {

    public double processarAbertura(Bau bau) throws Exception {

        if (bau.getQuantidadeItens() > 100) {
            throw new Exception("ALERTA DE HACK: Muitos itens para um único baú!");
        }

        double bonusSorte = 0.0;
        if (bau.getValorBase() < 500.00) {
            bonusSorte = 50.00;
        } else {
            bonusSorte = 0.0;
        }

        double taxaServidor = bau.getValorBase() * 0.15;
        double valorFinal = bau.getValorBase() + bonusSorte - taxaServidor;

        bau.setAberto(true);

        salvarNoInventarioSQL(bau, valorFinal);

        notificarPlayerViaChat(bau.getPlayerEmail(), bau.getId());

        return valorFinal;
    }

    private void salvarNoInventarioSQL(Bau bau, double valorFinal) {
        System.out.println("LOG DB: Inserindo item " + bau.getId() + " com valor R$" + valorFinal + " no MySQL.");
    }

    private void notificarPlayerViaChat(String email, String idBau) {
        System.out.println("CHAT: [SISTEMA] Player " + email + ", seu baú " + idBau + " foi aberto com sucesso!");
    }

    public static void main(String[] args) {
        ProcessadorDeLoot engine = new ProcessadorDeLoot();
        Bau bauLendario = new Bau("BAU-999", 600.00, 5, "arthas@lichking.com");

        try {
            double total = engine.processarAbertura(bauLendario);
            System.out.println("Sucesso! Valor final da recompensa: R$" + total);
        } catch (Exception e) {
            System.out.println("ERRO CRÍTICO NO JOGO: " + e.getMessage());
        }
    }
}