package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.movimiento.Movimiento;
import co.com.bancolombia.certificacion.app.utilidades.Builder;


public class MovimientoBuilder implements Builder<Movimiento> {
    private String fecha;
    private String valorMovimiento;
    private String naturaleza;
    private String codigo;
    private String descripcion;
    private String valorPorUnidad;
    private String numeroUnidades;

    public static MovimientoBuilder movimiento() {
        return new MovimientoBuilder();
    }

    public MovimientoBuilder conFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public MovimientoBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public MovimientoBuilder conValorMovimiento(String valor) {
        this.valorMovimiento = valor;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public String getValorMovimiento() {
        return valorMovimiento;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getValorPorUnidad() {
        return valorPorUnidad;
    }

    public String getNumeroUnidades() {
        return numeroUnidades;
    }

    @Override
    public Movimiento build() {
        return new Movimiento(this);
    }
}
