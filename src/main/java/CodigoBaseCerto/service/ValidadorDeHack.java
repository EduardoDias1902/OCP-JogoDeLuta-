package CodigoBaseCerto.service;
public class ValidadorDeHack {
    public static void validar(int quantidade) throws Exception {
        if (quantidade > 100) {
            throw new Exception("ALERTA: Tentativa de gerar itens excessivos!");
        }
    }
}
