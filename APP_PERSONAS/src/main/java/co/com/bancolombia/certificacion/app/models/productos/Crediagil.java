package co.com.bancolombia.certificacion.app.models.productos;

import co.com.bancolombia.certificacion.app.models.builders.CrediagilBuilder;

public class Crediagil extends Producto {
    private String tipoProducto;
    private String cupoDisponible;
    private String cupoAsignado;
    private String cupoUtilizado;
    private String cupoCanje;
    private String cupoDisponibleSobrecupo;
    private String valorMaximoDesembolsar;
    private String valorMinimoDesembolsar;

    public Crediagil(CrediagilBuilder crediagilBuilder){
        this.tipoProducto = crediagilBuilder.getTipoProducto();
        this.cupoDisponible = crediagilBuilder.getCupoDisponible();
        this.cupoAsignado = crediagilBuilder.getCupoAsignado();
        this.cupoUtilizado= crediagilBuilder.getCupoUtilizado();
        this.cupoCanje = crediagilBuilder.getCupoCanje();
        this.cupoDisponibleSobrecupo = crediagilBuilder.getCupoDisponibleSobrecupo();
        this.valorMaximoDesembolsar = crediagilBuilder.getValorMaximoDesembolsar();
        this.valorMinimoDesembolsar = crediagilBuilder.getValorMinimoDesembolsar();
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public String getCupoDisponible() {
        return cupoDisponible;
    }

    public String getCupoAsignado() {
        return cupoAsignado;
    }

    public String getCupoUtilizado() {
        return cupoUtilizado;
    }

    public String getCupoCanje() {
        return cupoCanje;
    }

    public String getCupoDisponibleSobrecupo() {
        return cupoDisponibleSobrecupo;
    }

    public String getValorMaximoDesembolsar() {
        return valorMaximoDesembolsar;
    }

    public String getValorMinimoDesembolsar() {
        return valorMinimoDesembolsar;
    }
}
