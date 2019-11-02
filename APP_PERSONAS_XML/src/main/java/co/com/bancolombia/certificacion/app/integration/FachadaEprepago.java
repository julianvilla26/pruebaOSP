package co.com.bancolombia.certificacion.app.integration;

import co.com.bancolombia.certificacion.app.models.productos.EPrepago;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadUsuario;
import co.com.bancolombia.certificacion.app.models.entidades.eprepago.CreateLoadEPrepagoEntity;
import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.models.usuario.Usuario;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.backend.iseries.transversal.productos.eprepago.BackTarjetaEPrepago;
import co.com.bancolombia.backend.modelo.productos.TarjetaEPrepago;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class FachadaEprepago {

    private static final Logger LOGGER = LogManager.getLogger(FachadaIseries.class.getName());

    /**
     * Verify eprepago detail tarjeta e prepago.
     *
     * @return the tarjeta e prepago
     */
    public static TarjetaEPrepago verifyEprepagoDetail() {
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());
        usuario.setUsername(user.getNombreUsuario());
        usuario.setPassword(user.getClave());
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago consultarDetalleEprepago = null;
        try {
            consultarDetalleEprepago = ePrepago.consultarDetalleEprepago(usuario,
                    AdministradorConstante.CODIGO_BANCO_EPREPAGO);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return consultarDetalleEprepago;
    }

    /**
     * Verify eprepago state activation tarjeta e prepago.
     *
     * @return the boolean
     */
    public static boolean verifyEprepagoStateActivation() {
        boolean result = false;
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());
        usuario.setUsername(user.getNombreUsuario());
        usuario.setPassword(user.getClave());
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago stateEprepago = null;
        try {
            stateEprepago = ePrepago.consultarDetalleEprepago(usuario, AdministradorConstante.CODIGO_BANCO_EPREPAGO);
            if (stateEprepago != null && AdministradorConstante.STATE_CARD_ACTIVE.equals(stateEprepago.getEstado())){
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Verify eprepago state activation tarjeta e prepago.
     *
     * @return the boolean
     */
    public static boolean verifyEprepagoStateInactivation() {
        boolean result = false;
        Usuario user = CargarEntidadUsuario.getUsuario();
        co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
        usuario.setDocumento(user.getNumeroDocumento());
        usuario.setTipoDocumento(user.getTipoDocumento());
        usuario.setUsername(user.getNombreUsuario());
        usuario.setPassword(user.getClave());
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago stateEprepago = null;
        try {
            stateEprepago = ePrepago.consultarDetalleEprepago(usuario, AdministradorConstante.CODIGO_BANCO_EPREPAGO);
            if (stateEprepago != null && AdministradorConstante.STATE_CARD_INACTIVE.equals(stateEprepago.getEstado())){
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Verify eprepago registry tarjeta e prepago.
     *
     * @return the tarjeta e prepago
     */
    public static TarjetaEPrepago verifyEprepagoRegistry() {
        Usuario usuario = CargarEntidadUsuario.getUsuario();
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago validarRegistroEprepago = null;
        try {
            validarRegistroEprepago = ePrepago.verifcarRegistroEprepago(usuario.getNumeroDocumento());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return validarRegistroEprepago;
    }

    /**
     * Verify eprepago register boolean.
     *
     * @return the boolean
     */
    public static boolean verifyEprepagoRegister() {
        Usuario usuario = CargarEntidadUsuario.getUsuario();
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        boolean validarRegistroEprepago = false;
        try {
            validarRegistroEprepago = ePrepago.verificarRegistroEprepagoTarj(usuario.getNumeroDocumento());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return validarRegistroEprepago;
    }

    /**
     * Verify existence eprepago boolean.
     *
     * @param actor the actor
     * @return the boolean
     */
    public boolean verifyExistenceEprepago(Actor actor) {
        boolean result = false;
        Usuario user = CargarEntidadUsuario.getUsuario();
        BackTarjetaEPrepago ePrepago = new BackTarjetaEPrepago();
        TarjetaEPrepago existenceEprepago = null;

        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        try {
            co.com.bancolombia.backend.modelo.usuario.Usuario usuario = new co.com.bancolombia.backend.modelo.usuario.Usuario();
            usuario.setDocumento(user.getNumeroDocumento());
            usuario.setTipoDocumento(user.getTipoDocumento());
            existenceEprepago = ePrepago.consultarDetalleEprepago(usuario, AdministradorConstante.CODIGO_BANCO_EPREPAGO);
            if (existenceEprepago != null
                    && AdministradorConstante.ALTERNATE.equalsIgnoreCase(configuracionTransaccion.getOrientacionCaso())
                    && AdministradorConstante.LABEL_NOT_EXIST.equalsIgnoreCase(configuracionTransaccion.getResultadoEsperado())) {
                result = true;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    /**
     * Verify the credit of the card eprepago.
     *
     * @return the boolean
     */
    public static boolean verifyTheCreditOfTheCardEprepago(){
        boolean result = false;
        EPrepago datosEprepago = CreateLoadEPrepagoEntity.getLoadEPrepago();
        ConfiguracionTransaccion configuracionTransaccion = CargarEntidadTransaccion.getConfiguracionTransaccion();
        DecimalFormat formatter = new DecimalFormat("##0");

        boolean verificarCreditoEprepago = validarCreditoEprepago(formatter.format(datosEprepago.getBalnceBefore()),
                formatter.format(datosEprepago.getBalanceAfter()),
                datosEprepago.getAmount().substring(1), configuracionTransaccion.getOrientacionCaso());

        if (verificarCreditoEprepago) {
            result = true;
        }
        return result;
    }

    /**
     * Verify the balances the credit the card eprepago.
     *
     * @return the boolean
     */
    public static boolean validarCreditoEprepago(String saldoAntes, String saldoDespues, String monto, String orientacion) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(monto);
        return AdministradorConstante.SUCCESS.equalsIgnoreCase(orientacion) ? saldoAnterior.add(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }

    /**
     * Verify the balances the debit the card eprepago.
     *
     * @return the boolean
     */
    public static boolean validarDebitoEprepago(String saldoAntes, String saldoDespues, String monto, String orientacion) {
        BigDecimal saldoAnterior = new BigDecimal(saldoAntes);
        BigDecimal saldoPosterior = new BigDecimal(saldoDespues);
        BigDecimal valorTransaccion = new BigDecimal(monto);
        return AdministradorConstante.SUCCESS.equalsIgnoreCase(orientacion) ? saldoAnterior.subtract(valorTransaccion).equals(saldoPosterior) : saldoAnterior.equals(saldoPosterior);
    }


}
