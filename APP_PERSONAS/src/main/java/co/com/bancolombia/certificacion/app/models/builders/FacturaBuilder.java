package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;

public class FacturaBuilder implements Builder<Factura> {
    private String valorFactura;
    private String empresaServicio;
    private String fechaFactura;
    private String periodicidad;
    private String numeroIntento;
    private String fechaInicio;
    private String fechaFin;
    private String frecuenciaPago;
    private String referencia;
    private Producto producto = new Producto();
    private String convenio;
    private String descripcionFactura;
    private String duracionProgramacion;
    private String mesProgramacion;
    private String estadoFactura;
    private String nitFactura;
    private String negocio;
    private String numeroFactura;
    private String canalInscripcionFactura;
    private String fechaVencimiento;
    private String valorFacturaReferenciaPagar;

    public FacturaBuilder() {
        this.valorFactura = "";
        this.empresaServicio = "";
        this.fechaFactura = "";
        this.periodicidad = "";
        this.numeroIntento = "";
        this.fechaInicio = "";
        this.fechaFin = "";
        this.convenio = "";
        this.referencia = "";
        this.frecuenciaPago = "";
        this.referencia = "";
        this.descripcionFactura = "";
        this.duracionProgramacion = "";
        this.mesProgramacion = "";
        this.estadoFactura = "";
        this.nitFactura = "";
        this.negocio = "";
        this.numeroFactura = "";
        this.canalInscripcionFactura = "";
        this.fechaVencimiento = "";
    }

    public static FacturaBuilder factura() {
        return new FacturaBuilder();
    }

    public FacturaBuilder conValor(List<Map<String, String>> datos) {
        this.valorFactura = datos.get(0).get("valorFactura");
        return this;
    }

    public FacturaBuilder conFechaVencimiento(List<Map<String, String>> datos) {
        this.fechaVencimiento = datos.get(0).get("fechaVencimiento");
        return this;
    }

    public FacturaBuilder conValor(String datos) {
        this.valorFactura = datos;
        return this;
    }

    public FacturaBuilder conEmpresaServicio(List<Map<String, String>> datos) {
        this.empresaServicio = datos.get(0).get("empresaServicio");
        return this;
    }

    public FacturaBuilder conEmpresaServicio(String datos) {
        this.empresaServicio = datos;
        return this;
    }

    public FacturaBuilder conFechaFactura(List<Map<String, String>> datos) {
        this.fechaFactura = datos.get(0).get("fechaFactura");
        return this;
    }

    public FacturaBuilder conFechaFactura(String datos) {
        this.fechaFactura = datos;
        return this;
    }

    public FacturaBuilder conNumeroFactura(String datos) {
        this.numeroFactura = datos;
        return this;
    }

    public FacturaBuilder conCanalInscripcionFactura(String datos) {
        this.canalInscripcionFactura = datos;
        return this;
    }

    public FacturaBuilder conEstadoHistorico(String datos) {
        this.estadoFactura = datos;
        return this;
    }

    public FacturaBuilder conPeriodicidad(List<Map<String, String>> datos) {
        this.periodicidad = datos.get(0).get("periodicidad");
        return this;
    }

    public FacturaBuilder conNumeroIntento(List<Map<String, String>> datos) {
        this.numeroIntento = datos.get(0).get("numeroIntento");
        return this;
    }

    public FacturaBuilder conFechaInicio(List<Map<String, String>> datos) {
        this.fechaInicio = datos.get(0).get("fechaInicio");
        return this;
    }

    public FacturaBuilder conFechaFin(List<Map<String, String>> datos) {
        this.fechaFin = datos.get(0).get("fechaFin");
        return this;
    }

    public FacturaBuilder conMes(List<Map<String, String>> datos) {
        this.mesProgramacion = datos.get(0).get("<mesProgramacion>");
        return this;
    }

    public FacturaBuilder conFechaInicio(String datos) {
        this.fechaInicio = datos;
        return this;
    }

    public FacturaBuilder conFechaFin(String datos) {
        this.fechaFin = datos;
        return this;
    }

    public FacturaBuilder conProducto(List<Map<String, String>> datos) {
        this.producto = elProducto().conNumero(datos.get(0).get("numeroCuenta"))
                .conTipoCuenta(datos.get(0).get("tipoCuenta"))
                .build();
        return this;
    }

    public FacturaBuilder conTipoCuenta(String datos) {
        this.producto = elProducto().conTipoCuenta(datos).build();
        return this;
    }

    public FacturaBuilder conNumeroCuenta(String datos) {
        this.producto = elProducto().conNumero(datos).build();
        return this;
    }

    public FacturaBuilder conFrecuenciaPago(List<Map<String, String>> datos) {
        this.frecuenciaPago = datos.get(0).get("frecuenciaPago");
        return this;
    }

    public FacturaBuilder conReferencia(List<Map<String, String>> datos) {
        this.referencia = datos.get(0).get("referencia");
        return this;
    }

    public FacturaBuilder conNit(String datos) {
        this.nitFactura = datos;
        return this;
    }

    public FacturaBuilder conNegocio(String datos) {
        this.negocio = datos;
        return this;
    }

    public FacturaBuilder conReferencia(String datos) {
        this.referencia = datos;
        return this;
    }

    public FacturaBuilder conConvenio(List<Map<String, String>> datos) {
        this.convenio = datos.get(0).get("convenio");
        return this;
    }

    public FacturaBuilder conDescripcionFactura(List<Map<String, String>> datos) {
        this.descripcionFactura = datos.get(0).get("descripcionFactura");
        return this;
    }

    public FacturaBuilder conDescripcionFactura(String datos) {
        this.descripcionFactura = datos;
        return this;
    }

    public FacturaBuilder conDuracionProgramacion(List<Map<String, String>> datos) {
        this.duracionProgramacion = datos.get(0).get("duracionProgramacion");
        return this;
    }

    public FacturaBuilder conMesProgramacion(List<Map<String, String>> datos) {
        this.mesProgramacion = datos.get(0).get("mesProgramacion");
        return this;
    }

    public FacturaBuilder conValorFacturaReferencia(List<Map<String, String>> datos) {
        this.valorFacturaReferenciaPagar = datos.get(0).get("valorFacturaReferenciaPagar");
        return this;
    }

    public String getValorFacturaReferenciaPagar() {
        return valorFacturaReferenciaPagar;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getNitFactura() {
        return nitFactura;
    }

    public String getNegocio() {
        return negocio;
    }

    public String getCanalInscripcionFactura() {
        return canalInscripcionFactura;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public String getDuracionProgramacion() {
        return duracionProgramacion;
    }

    public String getMesProgramacion() {
        return mesProgramacion;
    }

    public String getDescripcionFactura() {
        return descripcionFactura;
    }

    public String getValorFactura() {
        return valorFactura;
    }

    public String getEmpresaServicio() {
        return empresaServicio;
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

    public String getConvenio() {
        return convenio;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    @Override
    public Factura build() {
        return new Factura(this);
    }
}