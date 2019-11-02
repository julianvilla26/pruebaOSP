package co.com.bancolombia.certificacion.app.models.transaccion;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The type Transaction config.
 */
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

    /**
     * Gets trace.
     *
     * @return the trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * Sets trace.
     *
     * @param trace
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * Gets id case.
     *
     * @return the id case
     */
    public String getIdentificadorCaso() {
        return identificadorCaso;
    }

    /**
     * Sets id case.
     *
     * @param identificadorCaso the id case
     */
    public void setIdentificadorCaso(String identificadorCaso) {
        this.identificadorCaso = identificadorCaso;
    }

    /**
     * Gets orientation case.
     *
     * @return the orientation case
     */
    public String getOrientacionCaso() {
        return orientacionCaso;
    }

    /**
     * Sets orientation case.
     *
     * @param orientacionCaso the orientation case
     */
    public void setOrientacionCaso(String orientacionCaso) {
        this.orientacionCaso = orientacionCaso;
    }

    /**
     * Gets transaccion code.
     *
     * @return the transaccion code
     */
    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    /**
     * Sets transaccion code.
     *
     * @param codigoTransaccion the transaccion code
     */
    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    /**
     * Gets error code.
     *
     * @return the error code
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Sets error code.
     *
     * @param codigoError the error code
     */
    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    /**
     * Gets expected result.
     *
     * @return the expected result
     */
    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    /**
     * Sets expected result.
     *
     * @param resultadoEsperado the expected result
     */
    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    /**
     * Gets canal code.
     *
     * @return the canal code
     */
    public String getCodigoCanal() {
        return codigoCanal;
    }

    /**
     * Sets canal code.
     *
     * @param codigoCanal the canal code
     */
    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    /**
     * Gets system code.
     *
     * @return the system code
     */
    public String getCodigoSistema() {
        return codigoSistema;
    }

    /**
     * Sets system code.
     *
     * @param codigoSistema the system code
     */
    public void setCodigoSistema(String codigoSistema) {
        this.codigoSistema = codigoSistema;
    }

    /**
     * Gets transaccion type.
     *
     * @return the transaccion type
     */
    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * Sets transaccion type.
     *
     * @param tipoTransaccion the transaccion type
     */
    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    /**
     * Gets transaccion hour.
     *
     * @return the transaccion hour
     */
    public String getHoraTransaccion() {
        return horaTransaccion;
    }

    /**
     * Sets transaccion hour.
     *
     * @param horaTransaccion the transaccion hour
     */
    public void setHoraTransaccion(String horaTransaccion) {
        this.horaTransaccion = horaTransaccion;
    }

    /**
     * Gets type log canal.
     *
     * @return the type log canal
     */
    public String getTipoLogCanal() {
        return tipoLogCanal;
    }

    /**
     * Sets type log canal.
     *
     * @param tipoLogCanal the type log canal
     */
    public void setTipoLogCanal(String tipoLogCanal) {
        this.tipoLogCanal = tipoLogCanal;
    }

    /**
     * Gets operation code.
     *
     * @return the operation code
     */
    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    /**
     * Sets operation code.
     *
     * @param codigoOperacion the operation code
     */
    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }

        if (!(o instanceof ConfiguracionTransaccion)) { return false; }

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
