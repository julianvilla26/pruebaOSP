package co.com.bancolombia.certificacion.app.models.usuario;


import co.com.bancolombia.certificacion.app.models.productos.Producto;

import java.util.List;

/**
 * The type Usuario.
 */
public class Usuario {

    private String nombreUsuario;
    private String clave;
    private String segundaClave;
    private String numeroDocumento;
    private String tipoDocumento;
    private String primeraPregunta;
    private String estadoClave;
    private String correo;
    private List<Producto> productos;

    /**
     * Gets nombreUsuario.
     *
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Sets nombreUsuario.
     *
     * @param nombreUsuario the nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Gets clave.
     *
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sets clave.
     *
     * @param clave the clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Gets second clave.
     *
     * @return the second clave
     */
    public String getSegundaClave() {
        return segundaClave;
    }

    /**
     * Sets second clave.
     *
     * @param segundaClave the second clave
     */
    public void setSegundaClave(String segundaClave) {
        this.segundaClave = segundaClave;
    }

    /**
     * Gets document number.
     *
     * @return the document number
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Sets document number.
     *
     * @param numeroDocumento the document number
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * Gets documen type.
     *
     * @return the documen type
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Sets documen type.
     *
     * @param tipoDocumento the documen type
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Gets first question.
     *
     * @return the first question
     */
    public String getPrimeraPregunta() {
        return primeraPregunta;
    }

    /**
     * Sets first question.
     *
     * @param primeraPregunta the first question
     */
    public void setPrimeraPregunta(String primeraPregunta) {
        this.primeraPregunta = primeraPregunta;
    }

    /**
     * Gets productos.
     *
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Sets productos.
     *
     * @param productos the productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Gets key status.
     *
     * @return the key status
     */
    public String getEstadoClave() {
        return estadoClave;
    }

    /**
     * Sets key status.
     *
     * @param estadoClave the key status
     */
    public void setEstadoClave(String estadoClave) {
        this.estadoClave = estadoClave;
    }

    /**
     * Gets correo.
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Sets correo.
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}