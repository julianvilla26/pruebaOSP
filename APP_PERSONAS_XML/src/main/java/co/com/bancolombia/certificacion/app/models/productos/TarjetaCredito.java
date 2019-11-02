package co.com.bancolombia.certificacion.app.models.productos;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.formatoTarjetaCredito;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.AdministradorUtilidades.tipoTarjetaCreditoEnNumero;

public class TarjetaCredito extends Producto {

    private String formatoTarjetaCredito;
    private String tipoTarjetaCreditoEnNumero;
    private String fechaLimitePago;
    private String pagoMinimoEnPesos;
    private String pagoTotalEnPesos;
    private String deudaALaFechaEnPesos;
    private String avancesDisponiblesEnPesos;
    private String totalDisponibleEnPesos;
    private String pagoMinimoEnDolares;
    private String totalPagoEnDolares;
    private String deudaTotalEnDolares;

    public TarjetaCredito() { super(); }

    public TarjetaCredito(String numero, String tipoProducto) {
        super(numero, tipoProducto);
    }

    public String getFormatoTarjetaCredito() {
        return formatoTarjetaCredito;
    }

    public void setFormatoTarjetaCredito(String number, String accountType) {
        this.formatoTarjetaCredito = formatoTarjetaCredito(number, accountType);
    }

    public void setTipoTarjetaCreditoEnNumero(String accountType) {
        this.tipoTarjetaCreditoEnNumero = tipoTarjetaCreditoEnNumero(accountType);
    }

    public String getTipoTarjetaCreditoEnNumero() {
        return tipoTarjetaCreditoEnNumero;
    }

    public void setFormatoTarjetaCredito(String creditCardFormat) {
        this.formatoTarjetaCredito = creditCardFormat;
    }

    public String getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(String fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public String getMinimumPaymentPesos() {
        return pagoMinimoEnPesos;
    }

    public void setMinimumPaymentPesos(String minimumPaymentPesos) {
        this.pagoMinimoEnPesos = minimumPaymentPesos;
    }

    public String getPagoTotalEnPesos() {
        return pagoTotalEnPesos;
    }

    public void setPagoTotalEnPesos(String pagoTotalEnPesos) {
        this.pagoTotalEnPesos = pagoTotalEnPesos;
    }

    public String getDeudaALaFechaEnPesos() {
        return deudaALaFechaEnPesos;
    }

    public void setDeudaALaFechaEnPesos(String deudaALaFechaEnPesos) {
        this.deudaALaFechaEnPesos = deudaALaFechaEnPesos;
    }

    public String getAvancesDisponiblesEnPesos() {
        return avancesDisponiblesEnPesos;
    }

    public void setAvancesDisponiblesEnPesos(String avancesDisponiblesEnPesos) {
        this.avancesDisponiblesEnPesos = avancesDisponiblesEnPesos;
    }

    public String getTotalDisponibleEnPesos() {
        return totalDisponibleEnPesos;
    }

    public void setTotalDisponibleEnPesos(String totalDisponibleEnPesos) {
        this.totalDisponibleEnPesos = totalDisponibleEnPesos;
    }

    public String getPagoMinimoEnDolares() {
        return pagoMinimoEnDolares;
    }

    public void setPagoMinimoEnDolares(String pagoMinimoEnDolares) {
        this.pagoMinimoEnDolares = pagoMinimoEnDolares;
    }

    public String getTotalPagoEnDolares() {
        return totalPagoEnDolares;
    }

    public void setTotalPagoEnDolares(String totalPagoEnDolares) {
        this.totalPagoEnDolares = totalPagoEnDolares;
    }

    public String getDeudaTotalEnDolares() {
        return deudaTotalEnDolares;
    }

    public void setDeudaTotalEnDolares(String deudaTotalEnDolares) {
        this.deudaTotalEnDolares = deudaTotalEnDolares;
    }
}
