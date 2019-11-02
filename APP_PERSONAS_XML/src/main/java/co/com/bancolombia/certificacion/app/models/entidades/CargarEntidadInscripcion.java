package co.com.bancolombia.certificacion.app.models.entidades;


import co.com.bancolombia.certificacion.app.models.transaccion.Inscripcion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.models.productos.CuentaDeposito;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;

import java.util.List;

/**
 * The type Inscripcion entity.
 */
public class CargarEntidadInscripcion {

    /**
     * The constantes inscripcion.
     */
    private static Inscripcion inscripcion = new Inscripcion();

    private CargarEntidadInscripcion() {
        throw new IllegalStateException(TipoClaseConstante.ENTITY_CLASS);
    }

    /**
     * Gets insciption.
     *
     * @return the insciption
     */
    public static Inscripcion getInsciption() {
        return inscripcion;
    }

    /**
     * Sets insciption.
     *
     * @param data the data
     */
    public static void setInsciption(List<String> data) {
        CuentaDeposito depositAccount = new CuentaDeposito();
        Usuario usuario = new Usuario();

        inscripcion.setBankName(data.get(0));
        depositAccount.setTipo(data.get(1));
        depositAccount.setAccountNumberFormat(data.get(2));
        inscripcion.setCustomName(data.get(3));
        usuario.setTipoDocumento(data.get(4));
        usuario.setNumeroDocumento(data.get(5));

        inscripcion.setUsuario(usuario);
        inscripcion.setDepositAccount(depositAccount);
    }
}
