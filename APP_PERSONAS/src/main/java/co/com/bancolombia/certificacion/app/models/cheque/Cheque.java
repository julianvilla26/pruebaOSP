package co.com.bancolombia.certificacion.app.models.cheque;

import co.com.bancolombia.certificacion.app.models.builders.ChequeBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Cheque {
    private String tipoContraordenacion;
    private String numeroCheque;
    private String rangoDesde;
    private String rangoHasta;
    Producto producto;

    public Cheque(ChequeBuilder chequeBuilder){
        this.tipoContraordenacion =chequeBuilder.getTipoContraordenacion();
        this.numeroCheque=chequeBuilder.getNumeroCheque();
        this.rangoDesde=chequeBuilder.getRangoDesde();
        this.rangoHasta=chequeBuilder.getRangoHasta();
        this.producto=chequeBuilder.getProducto();
    }

    public String getRangoDesde() {
        return rangoDesde;
    }

    public void setRangoDesde(String rangoDesde) {
        this.rangoDesde = rangoDesde;
    }

    public String getRangoHasta() {
        return rangoHasta;
    }

    public void setRangoHasta(String rangoHasta) {
        this.rangoHasta = rangoHasta;
    }

    public String getTipoContraordenacion() {
        return tipoContraordenacion;
    }

    public void setTipoContraordenacion(String tipoContraordenacion) {
        this.tipoContraordenacion = tipoContraordenacion;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.numeroCheque = numeroCheque;
    }
}