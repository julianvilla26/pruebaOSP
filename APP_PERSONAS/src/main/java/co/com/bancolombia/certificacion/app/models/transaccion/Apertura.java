package co.com.bancolombia.certificacion.app.models.transaccion;

import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Apertura {

    private Producto producto;
    private String nombreFondoInversion;
    private String montoApertura;
    private String terminos;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getNombreFondoInversion() {
        return nombreFondoInversion;
    }

    public void setNombreFondoInversion(String nombreFondoInversion) {
        this.nombreFondoInversion = nombreFondoInversion;
    }

    public String getMontoApertura() {
        return montoApertura;
    }

    public void setMontoApertura(String montoApertura) {
        this.montoApertura = montoApertura;
    }

    public String getTerminos() {
        return terminos;
    }

    public void setTerminos(String terminos) {
        this.terminos = terminos;
    }
}
