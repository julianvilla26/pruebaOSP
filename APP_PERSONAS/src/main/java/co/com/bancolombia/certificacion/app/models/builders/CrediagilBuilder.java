package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.productos.Crediagil;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

public class CrediagilBuilder implements Builder<Crediagil> {
    private String tipoProducto;
    private String cupoDisponible;
    private String cupoAsignado;
    private String cupoUtilizado;
    private String cupoCanje;
    private String cupoDisponibleSobrecupo;
    private String valorMaximoDesembolsar;
    private String valorMinimoDesembolsar;

    public CrediagilBuilder() {
        this.tipoProducto = "";
        this.cupoDisponible = "";
        this.cupoAsignado = "";
        this.cupoUtilizado = "";
        this.cupoCanje = "";
        this.cupoDisponibleSobrecupo = "";
        this.valorMaximoDesembolsar = "";
        this.valorMinimoDesembolsar = "";
    }

    public static CrediagilBuilder crediagil(){
        return new CrediagilBuilder();
    }

    public CrediagilBuilder deTipo(String tipoProducto){
        this.tipoProducto = tipoProducto;
        return this;
    }

    public CrediagilBuilder conCupoDisponible(String cupoDisponible){
        this.cupoDisponible = cupoDisponible;
        return this;
    }

    public CrediagilBuilder conCupoAsignado(String cupoAsignado) {
        this.cupoAsignado = cupoAsignado;
        return this;
    }

    public CrediagilBuilder conCupoUtilizado(String cupoUtilizado) {
        this.cupoUtilizado = cupoUtilizado;
        return this;
    }

    public CrediagilBuilder conCupoCanje(String cupoCanje) {
        this.cupoCanje = cupoCanje;
        return this;
    }

    public CrediagilBuilder conCupoDisponibleSobrecupo(String cupoDisponibleSobrecupo) {
        this.cupoDisponibleSobrecupo = cupoDisponibleSobrecupo;
        return this;
    }

    public CrediagilBuilder conValorMaximoDesembolsar(String valorMaximoDesembolsar) {
        this.valorMaximoDesembolsar = valorMaximoDesembolsar;
        return this;
    }

    public CrediagilBuilder conValorMinimoDesembolsar(String valorMinimoDesembolsar) {
        this.valorMinimoDesembolsar = valorMinimoDesembolsar;
        return this;
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

    @Override
    public Crediagil build() {
        return new Crediagil(this);
    }
}
