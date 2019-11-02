package co.com.bancolombia.certificacion.app.models.transaccion;

public class TerminosCondiciones {

    private String versionTermCond;
    private String fecha;
    private ConfiguracionTransaccion configuracionTransaccion;

    public String getVersionTermCond() {
        return versionTermCond;
    }
    public void setVersionTermCond(String versionTermCond) {
        this.versionTermCond = versionTermCond;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ConfiguracionTransaccion getConfiguracionTransaccion() {
        return configuracionTransaccion;
    }

    public void setConfiguracionTransaccion(ConfiguracionTransaccion configuracionTransaccion) {
        this.configuracionTransaccion = configuracionTransaccion;
    }


}
