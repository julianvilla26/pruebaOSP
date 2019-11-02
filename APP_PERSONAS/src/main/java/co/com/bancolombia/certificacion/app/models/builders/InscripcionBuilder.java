package co.com.bancolombia.certificacion.app.models.builders;

import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.transaccion.Inscripcion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.Builder;

import java.util.List;

public class InscripcionBuilder implements Builder<Inscripcion> {
    private String nombreBanco;
    private String tipoFondo;
    private Producto producto = new Producto();
    private Usuario usuario = new Usuario();

    public InscripcionBuilder(List<String> datos) {
        this.nombreBanco = datos.get(0).trim();
        this.producto.setTipo(datos.get(1));
        this.producto.setNumero(datos.get(2));
        this.usuario.setTipoDocumento(datos.get(3));
        this.usuario.setNumeroDocumento(datos.get(4));
        this.tipoFondo=datos.get(5);
    }

    public static InscripcionBuilder inscripcionProductos(List<String> datos) {
        return new InscripcionBuilder(datos);
    }

    public String getTipoFondo() {
        return tipoFondo;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public Producto getProducto() {
        return producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Inscripcion build() {
        return new Inscripcion(this);
    }
}