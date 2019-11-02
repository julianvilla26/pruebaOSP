package co.com.bancolombia.certificacion.app.stepdefinitions.comun;

import co.com.bancolombia.certificacion.app.questions.fabrica.FabricaBaseDeDatosFinacle;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class ComunOracleStepDefinition {


    /**
     * Sets the stage.
     */
    @Before
    public void initialConfiguration() {
        /*
         *OnStage Prepara el escenario antes de llamar a los actores
         *OnlineCast Proporcionar soporte para la gestión de actores
         */
        OnStage.setTheStage(new OnlineCast());
    }


    @And("^I verify the opening virtual investment in finacle$")
    public void iVverifyInFinacle() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(FabricaBaseDeDatosFinacle.verificarLaAperturaDeInversionVirtualEnFinacle(), is(true))
        );
    }
    
}
