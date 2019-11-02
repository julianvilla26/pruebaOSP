package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.terminos;

import co.com.bancolombia.backend.iseries.personas.usuario.BackRegistroAPP;
import co.com.bancolombia.backend.modelo.usuario.UsuarioRegistro;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;

public class Registro {

    public static final Logger LOGGER = LogManager.getLogger(Registro.class.getName());

    public Registro() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

    public static UsuarioRegistro verifoEmailRegistrado(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
        usuario.setTipoDocumento(datosPrincipales.getUsuario().getTipoDocumento());
        BackRegistroAPP registroAPP = new BackRegistroAPP();
        UsuarioRegistro consultaEmailRegister = null;

        try {
            consultaEmailRegister = registroAPP.consultarCorreoRegistro(usuario);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return consultaEmailRegister;

    }

    public Boolean verificoUsuarioVirtual(Actor actor) {
        boolean result = false;
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
        usuario.setTipoDocumento(datosPrincipales.getUsuario().getTipoDocumento());

        BackRegistroAPP registroAPP = new BackRegistroAPP();
        UsuarioRegistro consultarRegistroVirtual = null;
        try {
            consultarRegistroVirtual = registroAPP.consultarUsuarioVirtual(usuario);
            if (datosPrincipales.getUsuario().getEstadoClave().equals(consultarRegistroVirtual.getStatusUser())) {
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public Boolean verificoTerminosYCondiciones(Actor actor) {
        ConfiguracionTransaccion datosPrincipales = actor.recall(MODELO_DATOS_TRANSACCION);
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(datosPrincipales.getUsuario().getNumeroDocumento());
        usuario.setTipoDocumento(datosPrincipales.getUsuario().getTipoDocumento());
        BackRegistroAPP registroAPP = new BackRegistroAPP();
        boolean result = false;
        try {
            boolean consultaTermConditional = registroAPP.consultarTerminosyCondicionesRegistro(usuario);
            result = consultaTermConditional;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }
}
