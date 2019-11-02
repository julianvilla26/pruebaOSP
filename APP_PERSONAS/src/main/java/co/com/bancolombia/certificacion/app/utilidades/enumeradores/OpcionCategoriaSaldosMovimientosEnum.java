package co.com.bancolombia.certificacion.app.utilidades.enumeradores;

public enum OpcionCategoriaSaldosMovimientosEnum {
    TARJETAS_CREDITO("Tarjetas de crédito"),
    CUENTAS("Cuentas"),
    EPREPAGO("e-Prepago"),
    INVERSIONES("Inversiones");

    private String categoria;

     OpcionCategoriaSaldosMovimientosEnum(String categoria){
        this.categoria =categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}