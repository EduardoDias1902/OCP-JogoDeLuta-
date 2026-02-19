package CodigoBaseCerto.service;

import CodigoBaseCerto.model.Bau;
import CodigoBaseCerto.interfaces.*;

public class GerenciadorLoot {
    private static ValidadorDeHack validador;
    private static CalculadoraDeStatus calculadora;
    private static InventarioRepository repo;
    private static ServicoNotificacao notificacao;

    public GerenciadorLoot(ValidadorDeHack v, CalculadoraDeStatus c,
                           InventarioRepository r, ServicoNotificacao n) {
        this.validador = v;
        this.calculadora = c;
        this.repo = r;
        this.notificacao = n;
    }

    public static void processarAbertura(Bau bau) throws Exception {
        validador.validar(bau.getQuantidadeItens());
        double valorFinal = calculadora.calcular(bau.getValorBase());
        repo.salvarNoInventario(bau, valorFinal);
        notificacao.enviar("Loot recebido! Valor total: " + valorFinal, bau.getPlayerEmail());
    }
}


