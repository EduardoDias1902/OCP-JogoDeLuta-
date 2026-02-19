package CódigoBaseCerto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import CódigoBaseCerto.model.Bau;
import CódigoBaseCerto.service.*;
import CódigoBaseCerto.strategy.CalculadoraLendaria;
import CódigoBaseCerto.interfaces.ServicoNotificacao;

public class Main {
    public static void main(String[] args) {
        ValidadorDeHack validador = new ValidadorDeHack();
        CalculadoraLendaria calcLendaria = new CalculadoraLendaria();
        InventarioRepository repo = new InventarioRepository();

        ServicoNotificacao sistemaChat = (msg, destino) ->
                System.out.println("CHAT para " + destino + ": " + msg);

        GerenciadorLoot gameEngine = new GerenciadorLoot(validador, calcLendaria, repo, sistemaChat);

        Bau bauIniciante = new Bau("BAU-001", "Lendário", 500.0, 10, "odin@valhalla.com");

        try {
            gameEngine.processarAbertura(bauIniciante);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}