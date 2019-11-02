package co.com.bancolombia.certificacion.app.utilidades.administradores;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public class Verificar {

    public static boolean elementoHabilitado(Actor actor, Target target) {
        try {
            return target.resolveFor(actor).isEnabled();
        } catch (Throwable e) {
            return false;
        }
    }

    public static boolean elementoVisible(Actor actor, Target target) {
        try {
            return target.resolveFor(actor).isVisible();
        } catch (Throwable e) {
            return false;
        }
    }

    public static boolean elementoPresente(Actor actor, Target target) {
        try {
            return target.resolveFor(actor).isPresent();
        } catch (Throwable e) {
            return false;
        }
    }
}