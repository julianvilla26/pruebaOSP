package co.com.bancolombia.certificacion.app.integration;

import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.backend.iseries.personas.usuario.BackRegistroAPP;
import co.com.bancolombia.backend.modelo.usuario.UsuarioRegistro;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class FachadaRegistro {


    /**
     * The type Backend integration.
     */

    private static final Logger LOGGER = LogManager.getLogger(FachadaRegistro.class.getName());

    /**
     * Verify email register.
     *
     * @return the email of gegister
     */


    public static UsuarioRegistro verifyEmailRegister() {
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());
        BackRegistroAPP registroAPP = new BackRegistroAPP();
        UsuarioRegistro consultaEmailRegister = null;

        try {
            consultaEmailRegister = registroAPP.consultarCorreoRegistro(usuario);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return consultaEmailRegister;

    }

    /**
     * Verify email register.
     *
     * @return the email of gegister
     */


    public Boolean verifyUserVirtual() {
        boolean result = false;
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());

        BackRegistroAPP registroAPP = new BackRegistroAPP();
        UsuarioRegistro consultarRegistroVirtual = null;
        try {
            consultarRegistroVirtual = registroAPP.consultarUsuarioVirtual(usuario);
            if (user.getEstadoClave().equals(consultarRegistroVirtual.getStatusUser())) {
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public Boolean verifyTermCond() {
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());
        BackRegistroAPP registroAPP = new BackRegistroAPP();
        boolean result = false;
        try {
            boolean consultaTermConditional = registroAPP.consultarTerminosyCondicionesRegistro(usuario);
            if (consultaTermConditional) result = true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
}
