package co.com.bancolombia.certificacion.app.stepdefinitions.inversionvirtual;

import co.com.bancolombia.certificacion.app.tasks.constructor.ObtenerElSaldoDelDeposito;
import co.com.bancolombia.certificacion.app.tasks.cargadatos.*;
import co.com.bancolombia.certificacion.app.tasks.inversionvirtual.AperturarInversionVirtualPorXml;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import java.util.List;

import static co.com.bancolombia.certificacion.app.questions.fabrica.FabricaBaseDeDatosFinacle.*;
import static co.com.bancolombia.certificacion.app.questions.fabrica.FabricaXml.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.is;

public class AperturaInversionVirtualStepsDefinition {



    @Dado("^que (.*) subo los datos para la prueba de apertura inversion virtual$")
    public void queYoSuboLosDatosParaLaPrueba(String actor, List<List<String>> datos){
        theActorCalled(actor).wasAbleTo(
                CargarDatosTransaccion.enApp(datos.get(0)),
                CargarDatosAutenticacion.enApp(datos.get(1)),
                CargarDatosDepositos.enApp(datos.get(2)),
                CargarDatosInversionVirtual.enApp(datos.get(3)),
                CargarDatosTerminosYcondiciones.enApp(datos.get(4))
        );

    }

    @Y("Realizo la apertura de la inversion virtual$")
    public void intentoAperturarLaInversionVirtual() {
        theActorInTheSpotlight().attemptsTo(
                ObtenerElSaldoDelDeposito.depositoAntes(),
                AperturarInversionVirtualPorXml.inApp(),
                ObtenerElSaldoDelDeposito.depositoDespues()
        );
    }

    @Entonces("Verifico la apertura de la inversion virtual$")
    public void verificoLaAperturaDeLaInversionVirtual() {
        theActorInTheSpotlight().should(
                seeThat(verificaElResultadoDeLaAperturaDeInversionVirtualPorXml(), is(true)),
                seeThat(verificarLaAperturaDeInversionVirtualEnFinacle(), is(true))
        );
    }


}
