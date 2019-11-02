package co.com.bancolombia.certificacion.app.stepdefinitions.cheque;

import co.com.bancolombia.certificacion.app.exceptions.cheque.NoRegistraContraordenChequeConRangoException;
import co.com.bancolombia.certificacion.app.exceptions.cheque.NoRegistraContraordenChequeException;
import co.com.bancolombia.certificacion.app.questions.cheque.VerificarContraorden;
import co.com.bancolombia.certificacion.app.questions.cheque.VerificarContraordenConRango;
import co.com.bancolombia.certificacion.app.tasks.cheque.ContraordenarCheque;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.cheque.NoRegistraContraordenChequeConRangoException.NO_INSCRIBE_CONTRAORDEN_CON_RANGO;
import static co.com.bancolombia.certificacion.app.exceptions.cheque.NoRegistraContraordenChequeException.NO_INSCRIBE_CONTRAORDEN;
import static co.com.bancolombia.certificacion.app.models.builders.ChequeBuilder.cheque;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContraordenarChequeStepDefinition {

    @Y("el actor contraordena su cheque con informacion")
    public void contraOrdenarChequeconTipoyNumero(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(ContraordenarCheque.conInfo(
                cheque()
                        .contipoCuenta(datos)
                        .conTipoCheque(datos)
                        .conNumeroCheque(datos)
                        .conRangoDesde(datos)
                        .conRangoHasta(datos)
                )
        );
    }

    @Entonces("El deberia ver contraordenacion de su cheque exitoso")
    public void deberiaVerContraodenarCheque() {
        theActorInTheSpotlight().should(seeThat(VerificarContraorden.deCheque())
                .orComplainWith(NoRegistraContraordenChequeException.class, NO_INSCRIBE_CONTRAORDEN));
    }

    @Entonces("El deberia ver contraordenacion de su cheque con rango exitoso")
    public void deberiaVerContraordernaChequeConRango(){
        theActorInTheSpotlight().should(seeThat(VerificarContraordenConRango.deChequeConRango())
                .orComplainWith(NoRegistraContraordenChequeConRangoException.class, NO_INSCRIBE_CONTRAORDEN_CON_RANGO));
    }
}