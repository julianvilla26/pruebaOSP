package co.com.bancolombia.certificacion.app.tasks.autenticacion;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_CERRAR;
import static co.com.bancolombia.certificacion.app.userinterface.pages.MenuPage.OPT_MENU_PRINCIPAL;
import static co.com.bancolombia.certificacion.app.userinterface.pages.autenticacion.InicioSesionPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.MenuConstantes.PERFIL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CerrarSesion implements Task {

    public static Performable exitosamente() {
        return instrumented(CerrarSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, BTN_VOLVER)).andIfSo(
                        Click.on(BTN_VOLVER)
                ).otherwise(
                        Check.whether(!elementoVisible(actor, OPT_MENU_PRINCIPAL.of(PERFIL))).andIfSo
                                (Click.on(LNK_CERRAR))),
                Esperar.unTiempo(5000),
                Click.on(OPT_MENU_PRINCIPAL.of(PERFIL)),
                Esperar.unTiempo(5000),
                Click.on(BTN_CERRAR_SESION)
        );
        actor.attemptsTo(
Click.on(BTN_SI_CERRAR_SESION),
                        Click.on(BTN_SI_CERRAR_SESION)

        );
    }
}