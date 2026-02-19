package CodigoBaseCerto.service;

import CodigoBaseCerto.model.Bau;

public class InventarioRepository {
    public void salvarNoInventario(Bau bau, double valorFinal) {
        // Simula persistência no banco de dados
        System.out.println("DB: Item do baú " + bau.getId() + " persistido com valor " + valorFinal);
    }
}