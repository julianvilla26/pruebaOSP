package co.com.bancolombia.certificacion.app.stepdefinitions.eprepago;

import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoLaDescargaExitosaException;
import co.com.bancolombia.certificacion.app.questions.eprepago.DescargaTarjetaVirtualEprepago;
import co.com.bancolombia.certificacion.app.tasks.eprepago.DescargarSaldo;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoLaDescargaExitosaException.MENSAJE_DESCARGA_EPREPAGO_NO_EXITOSA;
import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DescargarTarjetaVirtualEprepagoStepDefinition {

    @Cuando("^realiza la descarga por valor de (.*)$")
    public void descargarTarjetaVirtualEPrepago(String valorDescarga, List<Map<String, String>>productoDestino) {
        theActorInTheSpotlight().attemptsTo(
                DescargarSaldo.deLaTarjetaCon(elProducto().conProductoDebitar(productoDestino), valorDescarga)
        );
    }

    @Entonces("^el deberia de ver un mensaje descarga ePrepago exitosa$")
    public void deberiaVerMensajeDescargaTarjetaVritualEPrepagoExitosa() {
        theActorInTheSpotlight().should(seeThat(DescargaTarjetaVirtualEprepago.esExitosa())
                .orComplainWith(NoSeRealizoLaDescargaExitosaException.class, MENSAJE_DESCARGA_EPREPAGO_NO_EXITOSA));
    }
}