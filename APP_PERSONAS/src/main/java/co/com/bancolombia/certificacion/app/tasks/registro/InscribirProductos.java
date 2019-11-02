package co.com.bancolombia.certificacion.app.tasks.registro;

import co.com.bancolombia.certificacion.app.interactions.comunes.Esperar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.builders.InscripcionBuilder;
import co.com.bancolombia.certificacion.app.models.transaccion.Inscripcion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.registro.InscripcionProductoPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_INSCRIPCION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InscribirProductos implements Task {
    private Inscripcion inscripcion;

    public InscribirProductos(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_NUMERO_PRODUCTO, isVisible()),
                Enter.theValue(inscripcion.getProducto().getNumero()).into(TXT_NUMERO_PRODUCTO),
                Click.on(TXT_BANCO),
                Esperar.unTiempo(3000),
                WaitUntil.the(TXT_BUSCAR_NOMBRE_BANCO, isVisible()),
                Type.theValue(inscripcion.getNombreBanco()).into(TXT_BUSCAR_NOMBRE_BANCO),
                RealizarScroll.hastaPosicionDeTarget(ITEM_NOMBRE_BANCO),
                Click.on(ITEM_NOMBRE_BANCO),
                Click.on(BTN_CERRAR_SELECCION_BANCO),
                Click.on(FOCO),
                Click.on(CHK_TIPO_CUENTA.of(inscripcion.getProducto().getTipo())),
                Esperar.unTiempo(1000),
                WaitUntil.the(BTN_SIGUIENTE, isEnabled()),
                Click.on(BTN_SIGUIENTE),
                Click.on(TXT_TIPO_DOCUMENTO),
                Click.on(ITEM_TIPO_DOCUMENTO.of(inscripcion.getUsuario().getTipoDocumento().trim())),
                Enter.theValue(inscripcion.getUsuario().getNumeroDocumento()).into(TXT_NUMERO_DOCUMENTO),
                Click.on(FOCO),
                Esperar.unTiempo(1000),
                WaitUntil.the(BTN_SIGUIENTE, isEnabled()),
                Click.on(BTN_SIGUIENTE),
                Click.on(BTN_INSCRIBIR),
                Validar.carga()
        );
        actor.remember(MODELO_INSCRIPCION, inscripcion);
    }

    public static InscribirProductos conInformacion(InscripcionBuilder inscripcionBuilder) {
        return instrumented(InscribirProductos.class, inscripcionBuilder.build());
    }
}