package co.com.bancolombia.certificacion.app.models.transaccion;

import co.com.bancolombia.certificacion.app.models.builders.ConfiguracionTransaccionBuilder;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ConfiguracionTransaccion {
    private String identificadorCaso;
    private String orientacionCaso;
    private String codigoTransaccion;
    private String codigoError;
    private String resultadoEsperado;
    private String codigoCanal;
    private String codigoSistema;
    private String tipoTransaccion;
    private String horaTransaccion;
    private String tipoLogCanal;
    private String codigoOperacion;
    private String trace;
    private Usuario usuario;

    public ConfiguracionTransaccion(ConfiguracionTransaccionBuilder configuracionTransaccionBuilder) {
        this.identificadorCaso = configuracionTransaccionBuilder.getIdentificadorCaso();
        this.orientacionCaso = configuracionTransaccionBuilder.getOrientacionCaso();
        this.codigoTransaccion = configuracionTransaccionBuilder.getCodigoTransaccion();
        this.codigoError = configuracionTransaccionBuilder.getCodigoError();
        this.resultadoEsperado = configuracionTransaccionBuilder.getResultadoEsperado();
        this.codigoCanal = configuracionTransaccionBuilder.getCodigoCanal();
        this.codigoSistema = configuracionTransaccionBuilder.getCodigoSistema();
        this.tipoTransaccion = configuracionTransaccionBuilder.getTipoTransaccion();
        this.horaTransaccion = configuracionTransaccionBuilder.getHoraTransaccion();
        this.tipoLogCanal = configuracionTransaccionBuilder.getTipoLogCanal();
        this.codigoOperacion = configuracionTransaccionBuilder.getCodigoOperacion();
        this.usuario = configuracionTransaccionBuilder.getUsuario();
    }

    public ConfiguracionTransaccion() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) { this.trace = trace; }

    public String getIdentificadorCaso() {
        return identificadorCaso;
    }

    public void setIdentificadorCaso(String identificadorCaso) {
        this.identificadorCaso = identificadorCaso;
    }

    public String getOrientacionCaso() {
        return orientacionCaso;
    }

    public void setOrientacionCaso(String orientationCase) {
        this.orientacionCaso = orientationCase;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String transactionCode) {
        this.codigoTransaccion = transactionCode;
    }

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String errorCode) {
        this.codigoError = errorCode;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String expectedResult) {
        this.resultadoEsperado = expectedResult;
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public void setCodigoCanal(String canalCode) {
        this.codigoCanal = canalCode;
    }

    public String getCodigoSistema() {
        return codigoSistema;
    }

    public void setCodigoSistema(String systemCode) {
        this.codigoSistema = systemCode;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getHoraTransaccion() {
        return horaTransaccion;
    }

    public void setHoraTransaccion(String transactionHour) {
        this.horaTransaccion = transactionHour;
    }

    public String getTipoLogCanal() {
        return tipoLogCanal;
    }

    public void setTipoLogCanal(String typeLogCanal) {
        this.tipoLogCanal = typeLogCanal;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ConfiguracionTransaccion)) {
            return false;
        }

        ConfiguracionTransaccion that = (ConfiguracionTransaccion) o;

        return new EqualsBuilder()
                .append(getIdentificadorCaso(), that.getIdentificadorCaso())
                .append(getOrientacionCaso(), that.getOrientacionCaso())
                .append(getCodigoTransaccion(), that.getCodigoTransaccion())
                .append(getCodigoError(), that.getCodigoError())
                .append(getResultadoEsperado(), that.getResultadoEsperado())
                .append(getCodigoCanal(), that.getCodigoCanal())
                .append(getCodigoSistema(), that.getCodigoSistema())
                .append(getTipoTransaccion(), that.getTipoTransaccion())
                .append(getHoraTransaccion(), that.getHoraTransaccion())
                .append(getTipoLogCanal(), that.getTipoLogCanal())
                .append(getCodigoOperacion(), that.getCodigoOperacion())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getIdentificadorCaso())
                .append(getOrientacionCaso())
                .append(getCodigoTransaccion())
                .append(getCodigoError())
                .append(getResultadoEsperado())
                .append(getCodigoCanal())
                .append(getCodigoSistema())
                .append(getTipoTransaccion())
                .append(getHoraTransaccion())
                .append(getTipoLogCanal())
                .append(getCodigoOperacion())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("identificadorCaso", identificadorCaso)
                .append("orientacionCaso", orientacionCaso)
                .append("codigoTransaccion", codigoTransaccion)
                .append("codigoError", codigoError)
                .append("resultadoEsperado", resultadoEsperado)
                .append("codigoCanal", codigoCanal)
                .append("codigoSistema", codigoSistema)
                .append("tipoTransaccion", tipoTransaccion)
                .append("horaTransaccion", horaTransaccion)
                .append("tipoLogCanal", tipoLogCanal)
                .append("codigoOperacion", codigoOperacion)
                .toString();
    }
}
