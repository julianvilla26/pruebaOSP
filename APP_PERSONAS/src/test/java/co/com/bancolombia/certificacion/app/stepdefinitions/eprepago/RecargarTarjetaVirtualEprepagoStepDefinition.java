package co.com.bancolombia.certificacion.app.stepdefinitions.eprepago;

import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeIngresoElValorCorrectamenteException;
import co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoRecargaEprepagoException;
import co.com.bancolombia.certificacion.app.questions.eprepago.RecargaTarjetaEprepago;
import co.com.bancolombia.certificacion.app.questions.eprepago.ValorRecarga;
import co.com.bancolombia.certificacion.app.tasks.eprepago.CargarEprepago;
import co.com.bancolombia.certificacion.app.tasks.eprepago.CargarValor;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeIngresoElValorCorrectamenteException.MENSAJE_VALOR_DE_RECARGA_NO_INGRESADO;
import static co.com.bancolombia.certificacion.app.exceptions.eprepago.NoSeRealizoRecargaEprepagoException.MENSAJE_RECARGA_EPREPAGO_NO_REALIZADA;
import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RecargarTarjetaVirtualEprepagoStepDefinition {

    @Cuando("^realiza la carga por valor de (.*)$")
    public void cargarTarjetaVirtualEprepagoActiva(String valorRecarga, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                CargarEprepago.con(elProducto().conProductoDebitar(datos), valorRecarga)
        );
    }

    @Cuando("^realiza la carga sobre el valor maximo por valor de (.*)$")
    public void cargarTarjetaVirtualEPrepagoSobreElValorMaximo(String valorRecarga, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                CargarValor.sobreElValorMaximoCon(elProducto().conProductoDebitar(datos), valorRecarga)
        );
    }

    @Entonces("^el deberia de ver un mensaje de carga de tarjeta virtual ePrepago exitosa$")
    public void deberiaVerMensajeCargaTarjetaVirtualEprepagoExitosa() {
        theActorInTheSpotlight().should(seeThat(RecargaTarjetaEprepago.exitosa())
                .orComplainWith(NoSeRealizoRecargaEprepagoException.class, MENSAJE_RECARGA_EPREPAGO_NO_REALIZADA));
    }

    @Entonces("^el deberia ver un mensaje de monto para cargar no permitido$")
    public void deberiaVerMensajeMontoParaCargarNoPermitido() {
        theActorInTheSpotlight().should(seeThat(ValorRecarga.noPermitido())
                .orComplainWith(NoSeIngresoElValorCorrectamenteException.class, MENSAJE_VALOR_DE_RECARGA_NO_INGRESADO));
    }
}