package co.com.bancolombia.certificacion.app.models.builders;


import co.com.bancolombia.certificacion.app.models.cheque.Cheque;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;

public class ChequeBuilder implements Builder<Cheque> {
    private String tipoContraordenacion;
    private String numeroCheque;
    private String rangoDesde;
    private String rangoHasta;
    Producto producto = new Producto();

    public ChequeBuilder() {
        this.tipoContraordenacion = "";
        this.numeroCheque = "";
    }

    public static ChequeBuilder cheque(){
        return new ChequeBuilder();
    }

    public ChequeBuilder conTipoCheque(List<Map<String, String>> datos){
        this.tipoContraordenacion = datos.get(0).get("tipoContraordenacion");
        return this;
    }

    public ChequeBuilder conNumeroCheque(List<Map<String, String>> datos){
        this.numeroCheque = datos.get(0).get("numeroCheque");
        return this;
    }

    public ChequeBuilder contipoCuenta(List<Map<String, String>> datos){
        this.producto = elProducto().conNumero(datos.get(0).get("numeroCuenta"))
                .conTipoCuenta(datos.get(0).get("tipoCuenta"))
                .build();
        return this;
    }

    public ChequeBuilder conRangoDesde(List<Map<String, String>> datos){
        this.rangoDesde = datos.get(0).get("rangoDesde");
        return this;
    }

    public ChequeBuilder conRangoHasta(List<Map<String, String>> datos){
        this.rangoHasta = datos.get(0).get("rangoHasta");
        return this;
    }

    public String getRangoDesde() {
        return rangoDesde;
    }

    public String getRangoHasta() {
        return rangoHasta;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getTipoContraordenacion() {
        return tipoContraordenacion;
    }

    public String getNumeroCheque() {
        return numeroCheque;
    }

    @Override
    public Cheque build() {
        return  new Cheque(this);
    }
}