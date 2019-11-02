package co.com.bancolombia.certificacion.app.models.usuario;

import co.com.bancolombia.certificacion.app.models.builders.UsuarioBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;

import java.util.List;

public class Usuario {
    private String nombreUsuario;
    private String clave;
    private String segundaClave;
    private String numeroDocumento;
    private String tipoDocumento;
    private String primeraPregunta;
    private String estadoClave;
    private String correo;
    private String nombrePersonalizado;
    private String numeroCelular;
    private String tipoCorreo;
    private List<Producto> productos;

    public Usuario(UsuarioBuilder usuarioBuilder) {
        this.nombreUsuario = usuarioBuilder.getNombreUsuario();
        this.clave = usuarioBuilder.getClave();
        this.segundaClave = usuarioBuilder.getSegundaClave();
        this.numeroDocumento = usuarioBuilder.getNumeroDocumento();
        this.tipoDocumento = usuarioBuilder.getTipoDocumento();
        this.primeraPregunta = usuarioBuilder.getPrimeraPregunta();
        this.estadoClave = usuarioBuilder.getEstadoClave();
        this.correo = usuarioBuilder.getCorreo();
        this.nombrePersonalizado = usuarioBuilder.getNombrePersonalizado();
        this.numeroCelular = usuarioBuilder.getNumeroCelular();
        this.tipoCorreo = usuarioBuilder.getTipoCorreo();
        this.productos = usuarioBuilder.getProductos();
    }

    public Usuario(){}

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombrePersonalizado() {
        return nombrePersonalizado;
    }

    public void setNombrePersonalizado(String nombrePersonalizado) {
        this.nombrePersonalizado = nombrePersonalizado;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(String tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSegundaClave() {
        return segundaClave;
    }

    public void setSegundaClave(String segundaClave) {
        this.segundaClave = segundaClave;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getPrimeraPregunta() {
        return primeraPregunta;
    }

    public void setPrimeraPregunta(String primeraPregunta) {
        this.primeraPregunta = primeraPregunta;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getEstadoClave() {
        return estadoClave;
    }

    public void setEstadoClave(String estadoClave) {
        this.estadoClave = estadoClave;
    }
}