package co.com.bancolombia.certificacion.app.utilidades.constantes;

public enum TipoCuentas {

    AHORRO("S" , "7"),
    CORRIENTE("D" , "1");


    private String letra;
    private String numero;

   private TipoCuentas(String letra, String numero) {
        this.letra = letra;
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public String getNumero() {
        return numero;
    }


}
