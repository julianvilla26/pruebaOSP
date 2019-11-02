package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.productos.Credito;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;
import java.util.Map;

public class CreditoBuilder implements Builder<Credito>{
    private String deudaFechaCredito;
    private String capitalVigente;
    private String fechaProximoPago;
    private String interesesCorrientes;
    private String saldoMora;
    private String interesesMora;
    private String otrosCargos;
    private String fechasDesembolso;
    private String valorDesembolso;
    private String tipoPago;
    private String valorPago;
    private String tipoPrestamo;
    private String numeroPrestamo;

    private CreditoBuilder() {
        this.deudaFechaCredito = "";
        this.capitalVigente = "";
        this.fechaProximoPago = "";
        this.interesesCorrientes = "";
        this.saldoMora = "";
        this.interesesMora = "";
        this.otrosCargos = "";
        this.fechasDesembolso = "";
        this.valorDesembolso = "";
        this.tipoPago = "";
        this.valorPago = "";
        this.tipoPrestamo = "";
        this.numeroPrestamo = "";
    }

    public static CreditoBuilder credito(){
        return new CreditoBuilder();
    }

    public CreditoBuilder conDeudaFechaCredito(String deuda){
        this.deudaFechaCredito = deuda;
        return this;
    }

    public CreditoBuilder conCapitalVigente(String capitalVigente){
        this.capitalVigente = capitalVigente;
        return this;
    }

    public CreditoBuilder conFechaProximoPago(String fechaProximoPago){
        this.fechaProximoPago = fechaProximoPago;
        return this;
    }

    public CreditoBuilder conInteresesCorrientes(String interesesCorrientes){
        this.interesesCorrientes = interesesCorrientes;
        return this;
    }

    public CreditoBuilder conSaldoMora(String saldoMora){
        this.saldoMora = saldoMora;
        return this;
    }

    public CreditoBuilder conInteresesMora(String interesesMora){
        this.interesesMora = interesesMora;
        return this;
    }

    public CreditoBuilder conOtrosCargos(String otrosCargos){
        this.otrosCargos = otrosCargos;
        return this;
    }

    public CreditoBuilder conFechasDesembolso(String fechasDesembolso){
        this.fechasDesembolso = fechasDesembolso;
        return this;
    }

    public CreditoBuilder conValorDesembolso(String valorDesembolso){
        this.valorDesembolso = valorDesembolso;
        return this;
    }

    public CreditoBuilder conTipoPago(List<Map<String, String>> datos){
        this.tipoPago = datos.get(0).get("tipoPago");
        return this;
    }

    public CreditoBuilder conValor(List<Map<String, String>> datos){
        this.valorPago = datos.get(0).get("valorPago");
        return this;
    }

    public CreditoBuilder conCredito(List<Map<String, String>> datos){
        this.tipoPrestamo = datos.get(0).get("tipoPrestamo");
        this.numeroPrestamo = datos.get(0).get("numeroPrestamo");
        return this;
    }

    public String getDeudaFechaCredito() {
        return deudaFechaCredito;
    }

    public String getCapitalVigente() {
        return capitalVigente;
    }

    public String getFechaProximoPago() {
        return fechaProximoPago;
    }

    public String getInteresesCorrientes() {
        return interesesCorrientes;
    }

    public String getSaldoMora() {
        return saldoMora;
    }

    public String getInteresesMora() {
        return interesesMora;
    }

    public String getOtrosCargos() {
        return otrosCargos;
    }

    public String getFechasDesembolso() {
        return fechasDesembolso;
    }

    public String getValorDesembolso() {
        return valorDesembolso;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public String getValorPago() {
        return valorPago;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    @Override
    public Credito build() {
        return new Credito(this);
    }
}
