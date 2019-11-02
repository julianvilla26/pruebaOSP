package co.com.bancolombia.certificacion.app.tasks.constructor;

import co.com.bancolombia.certificacion.app.tasks.saldos.ObtenerSaldoDelDepositoDespues;
import co.com.bancolombia.certificacion.app.tasks.saldos.ObtenerSaldoDelDepositoAntes;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Get balance fabrica.
 */
public class ObtenerElSaldoDelDeposito {

    private ObtenerElSaldoDelDeposito() {
    }

    /**
     * Deposito before get deposit balance before.
     *
     * @return the get deposit balance before
     */
    public static ObtenerSaldoDelDepositoAntes depositoAntes() {
        return instrumented(ObtenerSaldoDelDepositoAntes.class);
    }

    /**
     * Deposito after get deposit balance after.
     *
     * @return the get deposit balance after
     */
    public static ObtenerSaldoDelDepositoDespues depositoDespues() {
        return instrumented(ObtenerSaldoDelDepositoDespues.class);
    }

}
