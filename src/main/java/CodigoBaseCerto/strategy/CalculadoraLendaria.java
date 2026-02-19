package CodigoBaseCerto.strategy;

import CodigoBaseCerto.interfaces.CalculadoraDeStatus;

public class CalculadoraLendaria implements CalculadoraDeStatus {
    @Override
    public double calcular(double valorBase) {
        double bonusLendario = 100.00;
        double taxaSorte = valorBase * 0.15; // 15% de bônus
        return valorBase + bonusLendario + taxaSorte;
    }
}