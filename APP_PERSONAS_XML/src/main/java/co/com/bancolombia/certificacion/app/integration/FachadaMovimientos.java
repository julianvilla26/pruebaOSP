package co.com.bancolombia.certificacion.app.integration;

import co.com.bancolombia.certificacion.app.models.productos.EPrepago;
import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransaccion;
import co.com.bancolombia.certificacion.app.models.entidades.eprepago.CreateLoadEPrepagoEntity;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.backend.iseries.transversal.productos.eprepago.BackMovimientosEprepago;
import co.com.bancolombia.backend.modelo.productos.TarjetaEPrepago;
import co.com.bancolombia.backend.modelo.transversal.Movimiento;
import co.com.bancolombia.backend.modelo.transversal.Transaccion;
import co.com.bancolombia.backend.utilidades.managers.DateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class FachadaMovimientos {

    private static final Logger LOGGER = LogManager.getLogger(FachadaIseries.class.getName());

    FachadaMovimientos() {
    }

    /**
     * List movements eprepago consolidated.
     *
     * @return the List
     */
    public static List<Movimiento> verifyMovementsEprepagoConsolidated(String strNumtarjeta, String strFecha) {
        BackMovimientosEprepago ePrepago = new BackMovimientosEprepago();
        List<Movimiento> movimientosConsolidado = null;
        try {
            movimientosConsolidado = ePrepago.consultarMovimientosConsolidado(
                    AdministradorConstante.NUMERO_BASE_EPREPAGO + strNumtarjeta, strFecha);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return movimientosConsolidado;
    }

    /**
     * List movements eprepago description.
     *
     * @return the List
     */
    public static List<Movimiento> verifyMovementsEprepagoDescription(String strNumtarjeta, String strDescripcion) {
        BackMovimientosEprepago ePrepago = new BackMovimientosEprepago();
        List<Movimiento> movimientosDescripcion = null;
        try {
            movimientosDescripcion = ePrepago.consultarMovimientosPorDescripcion(
                    AdministradorConstante.NUMERO_BASE_EPREPAGO + strNumtarjeta, strDescripcion);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return movimientosDescripcion;
    }

    /**
     * List movements eprepago dates.
     *
     * @return the List
     */
    public static List<Movimiento> verifyMovementsEprepagoDates(String strNumtarjeta, String strFechaDesde,
                                                                String strFechaHasta) {
        String[] listDateDesde = strFechaDesde.split("/");
        String[] listDateHasta = strFechaHasta.split("/");
        String strFechaDesdeBack = listDateDesde[2] + listDateDesde[0] + listDateDesde[1];
        String strFechaHastaBack = listDateHasta[2] + listDateHasta[0] + listDateHasta[1];
        BackMovimientosEprepago ePrepago = new BackMovimientosEprepago();
        List<Movimiento> movimientosFechas = null;
        try {
            movimientosFechas = ePrepago.movimientosPorFechas(
                    AdministradorConstante.NUMERO_BASE_EPREPAGO + strNumtarjeta, strFechaDesdeBack, strFechaHastaBack);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return movimientosFechas;
    }

    /**
     * List movements eprepago description and dates.
     *
     * @return the List
     */
    public static List<Movimiento> verifyMovementsEprepagoDescriptionAndDates(String strNumtarjeta,
                                                                              String strFechaDesde, String strFechaHasta, String strDescripcion) {
        String[] listDateDesde = strFechaDesde.split("/");
        String[] listDateHasta = strFechaHasta.split("/");
        String strFechaDesdeBack = listDateDesde[2] + listDateDesde[0] + listDateDesde[1];
        String strFechaHastaBack = listDateHasta[2] + listDateHasta[0] + listDateHasta[1];
        BackMovimientosEprepago ePrepago = new BackMovimientosEprepago();
        List<Movimiento> movimientosFechasyDescripcion = null;
        try {
            movimientosFechasyDescripcion = ePrepago.movimientosPorFechasyDescripcion(
                    AdministradorConstante.NUMERO_BASE_EPREPAGO + strNumtarjeta,
                    strFechaDesdeBack, strFechaHastaBack, strDescripcion);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return movimientosFechasyDescripcion;
    }


    /**
     * Verify the movement of the eprepago.
     *
     * @return the boolean
     */

  /**
          * Verify the movement of the eprepago.
            *
            * @return the boolean
 */

    public static boolean verifyTheMovementsEprepago() throws SQLException {
        boolean result = false;

        BackMovimientosEprepago registroMovimiento = new BackMovimientosEprepago();
        TarjetaEPrepago numeroTarjeta = FachadaEprepago.verifyEprepagoRegistry();
        Transaccion transaccion = new Transaccion();
        EPrepago datosEprepago = CreateLoadEPrepagoEntity.getLoadEPrepago();
        transaccion.setHoraTransaccion(CargarEntidadTransaccion.getConfiguracionTransaccion().getHoraTransaccion());
        transaccion.setValorTransaccion(datosEprepago.getAmount().substring(1));

        boolean verificarRegistroMovimiento = registroMovimiento.consultarMovimientosRegistro(AdministradorConstante.NUMERO_BASE_EPREPAGO + numeroTarjeta.getNumero(),
                DateManager.obtenerFechaSistema("yyyyMMdd"),transaccion.getHoraTransaccion(),transaccion.getValorTransaccion());
        if (verificarRegistroMovimiento) {
            result = true;
        }
        return result;
    }
}
