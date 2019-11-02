package co.com.bancolombia.certificacion.app.tasks.cheque;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.models.builders.ChequeBuilder;
import co.com.bancolombia.certificacion.app.models.cheque.Cheque;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.userinterface.pages.cheque.ChequePage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CHEQUE;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.VariablesSesionConstantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContraordenarCheque implements Task {
    private Cheque cheque;

    public ContraordenarCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SeleccionarProducto.desdeSaldosMovimientos(cheque.getProducto().getTipo(), cheque.getProducto().getNumero(), OPT_CUENTA_ASOCIADA),
                WaitUntil.the(CHK_CHEQUE.of(cheque.getTipoContraordenacion()), isVisible()),
                Check.whether(CHEQUE.equalsIgnoreCase(cheque.getTipoContraordenacion()))
                        .andIfSo(
                                Click.on(CHK_CHEQUE.of(cheque.getTipoContraordenacion())),
                                Enter.theValue(cheque.getRangoDesde()).into(TXT_DESDE),
                                Click.on(LBL_FOCO),
                                Enter.theValue(cheque.getRangoHasta()).into(TXT_HASTA)
                        ).otherwise(
                        Click.on(CHK_CHEQUE.of(cheque.getTipoContraordenacion())),
                        Enter.theValue(cheque.getNumeroCheque()).into(TXT_NUMERO_CHEQUE)
                ),
                Click.on(LBL_FOCO),
                Click.on(LNK_SIGUIENTE),
                Click.on(BTN_CONTRAORDENAR),
                Validar.carga()
        );
        actor.remember(MODELO_CHEQUE,cheque);
    }

    public static ContraordenarCheque conInfo(ChequeBuilder chequeBuilder) {
        return Tasks.instrumented(ContraordenarCheque.class, chequeBuilder.build());
    }
}