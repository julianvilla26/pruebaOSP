package co.com.bancolombia.certificacion.app.stepdefinitions.inversionvirtual;

import co.com.bancolombia.certificacion.app.tasks.autenticacion.AutenticarPorXml;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosAutenticacion;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosDepositos;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosInversionVirtual;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.CargarDatosTransaccion;
import co.com.bancolombia.certificacion.app.tasks.inversionvirtual.SimulacionVirtualXmlTask;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;

import java.util.List;

import static co.com.bancolombia.certificacion.app.questions.fabrica.FabricaXml.verificaElResultadoDelaSimulacionDeInversionVirtualPorXML;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class SimulacionInversionVirtualStepsDefinition {


    @Dado("^que (.*) cargo los datos para la prueba de simulacion de inversion virtual$")
    public void queYCargoLosDatosParaLaPruebaDeSimulacionDeInversionVirtual(String actor, List<List<String>> datos) {
        theActorCalled(actor).wasAbleTo(
                CargarDatosTransaccion.enApp(datos.get(0)),
                CargarDatosAutenticacion.enApp(datos.get(1)),
                CargarDatosDepositos.enApp(datos.get(2)),
                CargarDatosInversionVirtual.enApp(datos.get(3))
        );
    }


    @Cuando("^yo Intento autenticarme utilizando mis credenciales$")
    public void yoIntentoAutenticarmeUtilizandoMisCredenciales() {

        theActorInTheSpotlight().attemptsTo(AutenticarPorXml.enApp());

    }

    @Cuando("^yo simulo la inversion virtual$")
    public void yoSimuloLaInversionVirtual() {
        theActorInTheSpotlight().attemptsTo(
                SimulacionVirtualXmlTask.enApp()
        );
    }

    @Entonces("^yo verifico el resultado de la simulacion de inversión virtual$")
    public void yoVerificoElResultadoDeLaSimulacionDeInversiónVirtual() {

        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(verificaElResultadoDelaSimulacionDeInversionVirtualPorXML(), is(true))
        );

    }


}
