package co.com.bancolombia.certificacion.app.models.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;

public class Factura {
    private String valorFactura;
    private String empresaServicio;
    private String fechaFactura;
    private String periodicidad;
    private String numeroIntento;
    private String fechaInicio;
    private String fechaFin;
    private Producto producto;
    private String convenio;
    private String referencia;
    private String frecuenciaPago;
    private String descripcionFactura;
    private String duracionProgramacion;
    private String mesProgramacion;
    private String estadoFactura;
    private String nitFactura;
    private String negocio;
    private String numeroFactura;
    private String canalInscripcionFactura;
    private String fechaVencimiento;
    private String valorFacturaReferenciaPago;

    public Factura(FacturaBuilder programarFacturaBuilder) {
        this.valorFactura = programarFacturaBuilder.getValorFactura();
        this.empresaServicio = programarFacturaBuilder.getEmpresaServicio();
        this.fechaFactura = programarFacturaBuilder.getFechaFactura();
        this.periodicidad = programarFacturaBuilder.getPeriodicidad();
        this.numeroIntento = programarFacturaBuilder.getNumeroIntento();
        this.fechaInicio = programarFacturaBuilder.getFechaInicio();
        this.fechaFin = programarFacturaBuilder.getFechaFin();
        this.producto = programarFacturaBuilder.getProducto();
        this.convenio = programarFacturaBuilder.getConvenio();
        this.referencia = programarFacturaBuilder.getReferencia();
        this.frecuenciaPago=programarFacturaBuilder.getFrecuenciaPago();
        this.descripcionFactura=programarFacturaBuilder.getDescripcionFactura();
        this.duracionProgramacion=programarFacturaBuilder.getDuracionProgramacion();
        this.mesProgramacion=programarFacturaBuilder.getMesProgramacion();
        this.estadoFactura=programarFacturaBuilder.getEstadoFactura();
        this.nitFactura=programarFacturaBuilder.getNitFactura();
        this.negocio=programarFacturaBuilder.getNegocio();
        this.numeroFactura=programarFacturaBuilder.getNumeroFactura();
        this.canalInscripcionFactura=programarFacturaBuilder.getCanalInscripcionFactura();
        this.fechaVencimiento=programarFacturaBuilder.getFechaVencimiento();
        this.valorFacturaReferenciaPago =programarFacturaBuilder.getValorFacturaReferenciaPagar();
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNitFactura() {
        return nitFactura;
    }

    public void setNitFactura(String nitFactura) {
        this.nitFactura = nitFactura;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCanalInscripcionFactura() {
        return canalInscripcionFactura;
    }

    public void setCanalInscripcionFactura(String canalInscripcionFactura) {
        this.canalInscripcionFactura = canalInscripcionFactura;
    }

    public void setValorFactura(String valorFactura) {
        this.valorFactura = valorFactura;
    }

    public void setEmpresaServicio(String empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public void setNumeroIntento(String numeroIntento) {
        this.numeroIntento = numeroIntento;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public String getMesProgramacion() {
        return mesProgramacion;
    }

    public void setMesProgramacion(String mesProgramacion) {
        this.mesProgramacion = mesProgramacion;
    }

    public String getDuracionProgramacion() {
        return duracionProgramacion;
    }

    public void setDuracionProgramacion(String duracionProgramacion) {
        this.duracionProgramacion = duracionProgramacion;
    }

    public String getValorFacturaReferenciaPago() {
        return valorFacturaReferenciaPago;
    }

    public void setValorFacturaReferenciaPago(String valorFacturaReferenciaPago) {
        this.valorFacturaReferenciaPago = valorFacturaReferenciaPago;
    }

    public String getDescripcionFactura() {
        return descripcionFactura;
    }

    public void setDescripcionFactura(String descripcionFactura) {
        this.descripcionFactura = descripcionFactura;
    }

    public String getValorFactura() {
        return valorFactura;
    }

    public String getEmpresaServicio() {
        return empresaServicio;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public String getNumeroIntento() {
        return numeroIntento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getConvenio() {
        return convenio;
    }

    public String getReferencia() {
        return referencia;
    }
}