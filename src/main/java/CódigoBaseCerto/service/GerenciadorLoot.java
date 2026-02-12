package CódigoBaseCerto.service;

import CódigoBaseCerto.model.Bau;
import CódigoBaseCerto.interfaces.*;

public class GerenciadorLoot {
    private ValidadorDeHack validador;
    private CalculadoraDeStatus calculadora;
    private InventarioRepository repo;
    private ServicoNotificacao notificacao;

    public GerenciadorLoot(ValidadorDeHack v, CalculadoraDeStatus c,
                           InventarioRepository r, ServicoNotificacao n) {
        this.validador = v;
        this.calculadora = c;
        this.repo = r;
        this.notificacao = n;
    }

    public void processarAbertura(Bau bau) throws Exception {
        validador.validar(bau.getQuantidadeItens());

        double valorFinal = calculadora.calcular(bau.getValorBase());

        repo.salvarNoInventario(bau, valorFinal);

        notificacao.enviar("Loot recebido! Valor total: " + valorFinal, bau.getPlayerEmail());
    }
}