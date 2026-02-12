package CódigoBaseErrado;

class Bau {
    public String tipo = "Lendário";
    public double raridadeBase = 100.0;
    public int quantidadeItens = 5;
    public String playerEmail = "player1@valhalla.com";
}

public class ProcessadorDeLoot {

    public void processarLoot(Bau bau) throws Exception {
        if (bau.quantidadeItens > 50) {
            throw new Exception("Baú suspeito! Limite de itens excedido para evitar hacks.");
        }


        double bonusSorte = 0.0;
        if (bau.tipo.equals("Lendário")) {
            bonusSorte = 50.0; // Bônus fixo
        }
        double taxaDropInimigo = bau.raridadeBase * 0.20; // 20% de taxa fixa
        double valorFinalItem = bau.raridadeBase + bonusSorte + taxaDropInimigo;


        System.out.println("LOG: Item de valor " + valorFinalItem + " salvo no Inventário SQL do Player.");
        System.out.println("NOTIFICAÇÃO: Enviando e-mail de recompensa para " + bau.playerEmail);
    }

    public static void main(String[] args) {
        ProcessadorDeLoot engine = new ProcessadorDeLoot();
        Bau bauRaro = new Bau();

        try {
            engine.processarLoot(bauRaro);
            System.out.println("Loot processado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro no sistema: " + e.getMessage());
        }
    }
}
