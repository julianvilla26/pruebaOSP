package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Current usuario entity.
 */
public class CargarEntidadUsuario {

    private static Usuario usuario = new Usuario();

    private CargarEntidadUsuario() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets usuario.
     *
     * @return the usuario
     */
    public static Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets usuario.
     *
     * @param data the data
     */
    public static void conEstos(List<String> data) {
        usuario.setNumeroDocumento(data.get(0));
        usuario.setTipoDocumento(data.get(1));
        usuario.setNombreUsuario(data.get(2));
        usuario.setClave(data.get(3));
        usuario.setSegundaClave(data.get(4));
        if (data.size() > 5) {
            usuario.setCorreo(data.get(5));
            usuario.setEstadoClave(data.get(6));
        }
    }
}