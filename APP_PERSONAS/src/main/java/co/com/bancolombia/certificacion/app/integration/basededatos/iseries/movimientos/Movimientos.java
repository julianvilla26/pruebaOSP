package co.com.bancolombia.certificacion.app.integration.basededatos.iseries.movimientos;

import co.com.bancolombia.backend.iseries.transversal.productos.eprepago.BackMovimientosEprepago;
import co.com.bancolombia.backend.modelo.transversal.Movimiento;
import co.com.bancolombia.certificacion.app.utilidades.constantes.AdministradorConstante;
import co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante;
import net.serenitybdd.screenplay.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class Movimientos {

    public static final Logger LOGGER = LogManager.getLogger(Movimientos.class.getName());

    private Movimientos() {
        throw new IllegalStateException(TipoClaseConstante.CLASE_UTILIDAD);
    }

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

    public static boolean verifyTheMovementsEprepago(Actor actor) throws SQLException {
        return false;
    }

}
