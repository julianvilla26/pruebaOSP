package co.com.bancolombia.certificacion.app.stepdefinitions.comun;

import co.com.bancolombia.certificacion.app.tasks.basededatos.iseries.ConsultarLosArchivosDeIseries;
import cucumber.api.java.Before;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ComunIseriesStepDefinition {


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

    @Y("^Verifico los resultados en los archivos de iseries$")
    public void IVerifyTheResultsInTheFilesOfBackIseries(List<String> files){
        theActorInTheSpotlight().attemptsTo(ConsultarLosArchivosDeIseries.enApp(files));
    }


}
