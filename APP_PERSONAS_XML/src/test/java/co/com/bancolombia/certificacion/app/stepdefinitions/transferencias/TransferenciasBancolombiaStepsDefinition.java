package co.com.bancolombia.certificacion.app.stepdefinitions.transferencias;


import co.com.bancolombia.certificacion.app.models.entidades.CargarEntidadTransferencias;
import co.com.bancolombia.certificacion.app.models.entidades.eprepago.CreateDepositEntity;
import co.com.bancolombia.certificacion.app.questions.fabrica.FabricaXml;
import co.com.bancolombia.certificacion.app.tasks.constructor.ObtenerElSaldoDelDeposito;
import co.com.bancolombia.certificacion.app.tasks.transferencias.TransferBancolombiaXmlTask;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class TransferenciasBancolombiaStepsDefinition {
	
    @And("I transfer to Bancolombia Accounts$")
    public void iTriesLoadHisCard() {
        theActorInTheSpotlight().attemptsTo(
        		TransferBancolombiaXmlTask.inApp()
        );
    }
    
    @And("^Previous consultations transfer bancolombia$")
    public void previousConsultationsLoadEprepago(List<String> data) {
        CreateDepositEntity.setDepositValues(data);
        CargarEntidadTransferencias.setTransferencias(data);
        theActorInTheSpotlight().attemptsTo(
                ObtenerElSaldoDelDeposito.depositoAntes()
        );
    }

    @And("^Subsequent consultations transfer bancolombia$")
    public void subsequentConsultationsLoadEprepago() {
        theActorInTheSpotlight().attemptsTo(
                ObtenerElSaldoDelDeposito.depositoDespues()
        );
    }

    @Then("^I verify the transfer bancolombia result$")
    public void iCanSeeTheConfirmation() {
        Serenity.recordReportData().withTitle("Request Transfers Bancolombia").andContents(Serenity.sessionVariableCalled("Request"));
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(FabricaXml.verificaElResultadoDeLaTransferenciaBancolombiaPorXml(), is(true))
        );
        Serenity.recordReportData().withTitle("Response Transfers Bancolombia").andContents(Serenity.sessionVariableCalled("Response"));
    }
    
}
