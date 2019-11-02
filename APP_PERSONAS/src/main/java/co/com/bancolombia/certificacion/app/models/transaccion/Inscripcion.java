package co.com.bancolombia.certificacion.app.models.transaccion;


import co.com.bancolombia.certificacion.app.models.builders.InscripcionBuilder;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;

public class Inscripcion {
    private String nombreBanco;
    private Producto producto;
    private Usuario usuario;
    private String tipoFondo;

    public Inscripcion(InscripcionBuilder inscripcionBuilder) {
        this.nombreBanco = inscripcionBuilder.getNombreBanco();
        this.producto = inscripcionBuilder.getProducto();
        this.usuario = inscripcionBuilder.getUsuario();
        this.tipoFondo=inscripcionBuilder.getTipoFondo();
    }

    public Inscripcion() {
    }

    public String getTipoFondo() {
        return tipoFondo;
    }

    public void setTipoFondo(String tipoFondo) {
        this.tipoFondo = tipoFondo;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
