package co.com.bancolombia.certificacion.app.models.productos;

import co.com.bancolombia.certificacion.app.models.builders.EprepagoBuilder;

public class Eprepago extends Producto {
    private String fechaVencimiento;
    private String cvc;

    public Eprepago(EprepagoBuilder eprepagoBuilder) {
        super(eprepagoBuilder.getNumeroTarjeta(), eprepagoBuilder.getTipoCuenta(), eprepagoBuilder.getSaldo());
        this.fechaVencimiento = eprepagoBuilder.getFechaVencimiento();
        this.cvc = eprepagoBuilder.getCvc();
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getCvc() {
        return cvc;
    }
}