package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.productos.Eprepago;
import co.com.bancolombia.certificacion.app.models.saldo.Saldo;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;
import java.util.Map;

public class EprepagoBuilder implements Builder<Eprepago> {
    private Saldo saldo = new Saldo();
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String cvc;
    private String tipoCuenta;

    private EprepagoBuilder() {
        this.numeroTarjeta = "";
        this.fechaVencimiento = "";
        this.cvc = "";
        this.tipoCuenta = "";
    }

    public static EprepagoBuilder eprepago() {
        return new EprepagoBuilder();
    }

    public EprepagoBuilder conSaldoDisponible(Saldo saldoDisponible) {
        this.saldo = saldoDisponible;
        return this;
    }

    public EprepagoBuilder conNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        return this;
    }

    public EprepagoBuilder conFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        return this;
    }

    public EprepagoBuilder conTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this;
    }

    public EprepagoBuilder conCvc(String cvc) {
        this.cvc = cvc;
        return this;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCvc() {
        return cvc;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    @Override
    public Eprepago build() {
        return new Eprepago(this);
    }
}
