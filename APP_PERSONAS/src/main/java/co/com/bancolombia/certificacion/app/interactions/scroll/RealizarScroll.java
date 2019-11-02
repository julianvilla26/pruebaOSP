package co.com.bancolombia.certificacion.app.interactions.scroll;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarScroll {
    public static Performable hastaPosicionDeTarget(Target elemento) {
        return instrumented(HastaElTarget.class, elemento);
    }

    public static Performable adicional(Target elemento) {
        return instrumented(ScrollAdicional.class, elemento);
    }
}