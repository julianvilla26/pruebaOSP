package co.com.bancolombia.certificacion.app.models.saldo;

import co.com.bancolombia.certificacion.app.models.builders.SaldoBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Saldo extends Producto {
    private String saldoTotal;
    private String saldoEnCanje;
    private String saldoDisponible;
    private String monto;

    protected Saldo(String numero, String tipoProducto) {
        super(numero, tipoProducto);
    }

    public Saldo() {
    }

    public Saldo(SaldoBuilder saldoBuilder){
        this.saldoTotal = saldoBuilder.getSaldoTotal();
        this.saldoEnCanje = saldoBuilder.getSaldoEnCanje();
        this.saldoDisponible = saldoBuilder.getSaldoDisponible();
        this.monto = saldoBuilder.getMonto();
    }

    public String getSaldoTotal() {
        return saldoTotal;
    }
    public String getSaldoEnCanje() {
        return saldoEnCanje;
    }
    public String getSaldoDisponible() { return saldoDisponible; }
    public String getMonto() { return monto; }

    public void setSaldoTotal(String saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    public void setSaldoEnCanje(String saldoEnCanje) {
        this.saldoEnCanje = saldoEnCanje;
    }
    public void setSaldoDisponible(String saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    public void setMonto(String monto) {
        this.monto = monto;
    }

}