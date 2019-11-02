package co.com.bancolombia.certificacion.app.tasks.registro;

import co.com.bancolombia.certificacion.app.models.transaccion.ConfiguracionTransaccion;
import co.com.bancolombia.certificacion.app.tasks.autenticacion.IniciarSesion;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_CANCELAR_TRANSACCION;
import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.BTN_SI_CANCELAR_REGISTRO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.MenuPage.OPT_MENU_PRINCIPAL;
import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.RegistroPage.LBL_INICIA_REGISTRO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.MenuConstantes.INICIO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DATOS_TRANSACCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Registrar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ConfiguracionTransaccion configuracionTransaccion = actor.recall(MODELO_DATOS_TRANSACCION);
        actor.attemptsTo(
                Click.on(LBL_INICIA_REGISTRO),
                Click.on(BTN_CANCELAR_TRANSACCION)
        );
        if (Verificar.elementoVisible(actor, BTN_SI_CANCELAR_REGISTRO)) {
            actor.attemptsTo(
                    Click.on(BTN_SI_CANCELAR_REGISTRO)
            );
        }
        actor.attemptsTo(
                Click.on(OPT_MENU_PRINCIPAL.of(INICIO)),
                IniciarSesion.con(configuracionTransaccion.getUsuario().getNombreUsuario(), configuracionTransaccion.getUsuario().getClave())
        );
    }

    public static Performable nuevamenteUsuario() {
        return instrumented(Registrar.class);
    }
}
