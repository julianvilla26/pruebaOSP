package co.com.bancolombia.certificacion.app.interactions.esperartiempo;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * The type Wait interaction.
 */
public class EsperarIteraccion implements Interaction {

    private int var;

    /**
     * Instantiates a new Wait interaction.
     *
     * @param var the var
     */
    protected EsperarIteraccion(int var) {
        this.var = var;
    }

    /**
     * Wait class wait interaction.
     *
     * @param var the var
     * @return the wait interaction
     */
    public static EsperarIteraccion waitClass(int var) {
        return instrumented(EsperarIteraccion.class, var);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(var);

    }

}
