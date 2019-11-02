package co.com.bancolombia.certificacion.app.models.productos;

public class InversionVirtual {


    private String valorInversion;
    private String terminoDias;
    private String periodicidadPagoInteres;
    private int periodicidadPagoInteresNumero;
    private CuentaDeposito cuentaDeposito;
    private String terminosYCondiciones;
    private String numeroInversion;
    private String stockTrade;
    private String fechaApertura;
    private String fechaExpiracion;
    private String tasaEfectivaAnual;
    private String tasaNomina;
    private String pagoInteres;
    private String periodoInteres;
    private String periodicidadInteres;

    public String getValorInversion() {
        return valorInversion;
    }

    public void setValorInversion(String investmentValue) {
        this.valorInversion = investmentValue;
    }

    public String getTerminoDias() {
        return terminoDias;
    }

    public void setTerminoDias(String daysTerm) {
        this.terminoDias = daysTerm;
    }

    public String getPeriodicidadPagoInteres() {
        return periodicidadPagoInteres;
    }

    public void setPeriodicidadPagoInteres(String periodicityPaymentInterest) {
        this.periodicidadPagoInteres = periodicityPaymentInterest;
    }

    public String getTerminosYCondiciones() {
        return terminosYCondiciones;
    }

    public void setTerminosYCondiciones(String terminosYCondiciones) {
        this.terminosYCondiciones = terminosYCondiciones;
    }

    public int getPeriodicidadPagoInteresNumero() {
        return periodicidadPagoInteresNumero;
    }

    public void setPeriodicidadPagoInteresNumero(int periodicityPaymentInterestNumber) {
        this.periodicidadPagoInteresNumero = periodicityPaymentInterestNumber;
    }

    public CuentaDeposito getCuentaDeposito() {
        return cuentaDeposito;
    }

    public void setCuentaDeposito(CuentaDeposito depositAccount) {
        this.cuentaDeposito = depositAccount;
    }

    public String getNumeroInversion() {
        return numeroInversion;
    }

    public void setNumeroInversion(String numeroInversion) {
        this.numeroInversion = numeroInversion;
    }

    public String getStockTrade() {
        return stockTrade;
    }

    public void setStockTrade(String stockTrade) {
        this.stockTrade = stockTrade;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTasaEfectivaAnual() {
        return tasaEfectivaAnual;
    }

    public void setTasaEfectivaAnual(String tasaEfectivaAnual) {
        this.tasaEfectivaAnual = tasaEfectivaAnual;
    }

    public String getTasaNomina() {
        return tasaNomina;
    }

    public void setTasaNomina(String tasaNomina) {
        this.tasaNomina = tasaNomina;
    }

    public String getPagoInteres() {
        return pagoInteres;
    }

    public void setPagoInteres(String pagoInteres) {
        this.pagoInteres = pagoInteres;
    }

    public String getPeriodoInteres() {
        return periodoInteres;
    }

    public void setPeriodoInteres(String periodoInteres) {
        this.periodoInteres = periodoInteres;
    }

    public String getPeriodicidadInteres() {
        return periodicidadInteres;
    }

    public void setPeriodicidadInteres(String periodicidadInteres) {
        this.periodicidadInteres = periodicidadInteres;
    }
}

