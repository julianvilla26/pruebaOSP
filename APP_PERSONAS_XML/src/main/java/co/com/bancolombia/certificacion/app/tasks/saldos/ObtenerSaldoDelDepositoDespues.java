package co.com.bancolombia.certificacion.app.tasks.saldos;

import co.com.bancolombia.certificacion.app.integration.FachadaIseries;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Get deposit balance after.
 */
public class ObtenerSaldoDelDepositoDespues implements Task {

    private static final Logger LOGGER = LogManager.getLogger(ObtenerSaldoDelDepositoDespues.class.getName());

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            FachadaIseries.balanceDepositAfter();
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }
}
