package co.com.bancolombia.certificacion.app.stepdefinitions.tarjetadecredito;

import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosAutenticacion;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosTarjetas;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosTransaccion;
import co.com.bancolombia.certificacion.app.tasks.tarjetadecredito.ConsultaCostoAvanceTarjetaPorXml;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;

import static co.com.bancolombia.certificacion.app.questions.fabrica.FabricaXml.verificaElResultadoDeLaConsultaDeCostoDeAvanceDeTarjetaPorXml;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class ConsultaCostoAvanceTarjetaStepsDefinition {

    @Dado("^que (.*) subo los datos para la prueba de consulta de costo de avance de tarjeta$")
    public void queYoSuboLosDatosParaLaPrueba(String actor, List<List<String>> datos){
        theActorCalled(actor).wasAbleTo(
                CargarDatosTransaccion.enApp(datos.get(0)),
                CargarDatosAutenticacion.enApp(datos.get(1)),
                CargarDatosTarjetas.enApp(datos.get(2))
                );

    }

    @Y("Realizo la consulta de costo de avance de tarjeta$")
    public void intentoConsultarLasTasasDeLaInversionVirtual() {
        theActorInTheSpotlight().attemptsTo(
                ConsultaCostoAvanceTarjetaPorXml.inApp()
        );
    }

    @Entonces("Verifico la consulta de costo de avance de tarjeta$")
    public void verificoLaConsultaDeTasasDeLaInversionVirtual() {
        theActorInTheSpotlight().should(
                seeThat(verificaElResultadoDeLaConsultaDeCostoDeAvanceDeTarjetaPorXml(), is(true))
        );
    }

}
