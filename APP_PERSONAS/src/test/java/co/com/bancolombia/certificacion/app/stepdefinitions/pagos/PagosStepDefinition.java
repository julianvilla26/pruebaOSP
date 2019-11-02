package co.com.bancolombia.certificacion.app.stepdefinitions.pagos;

import co.com.bancolombia.certificacion.app.exceptions.pagos.MensajeNoPresentadoException;
import co.com.bancolombia.certificacion.app.exceptions.pagos.PagoNoRealizadoException;
import co.com.bancolombia.certificacion.app.questions.pagos.VerificarMensajePagoMayor;
import co.com.bancolombia.certificacion.app.questions.pagos.VerificarPago;
import co.com.bancolombia.certificacion.app.questions.pagos.VerificarPagoCredito;
import co.com.bancolombia.certificacion.app.tasks.pagos.Pagar;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.pagos.MensajeNoPresentadoException.MENSAJE_NO_PRESENTADO;
import static co.com.bancolombia.certificacion.app.exceptions.pagos.PagoNoRealizadoException.PAGO_NO_REALIZADO;
import static co.com.bancolombia.certificacion.app.models.builders.CreditoBuilder.credito;
import static co.com.bancolombia.certificacion.app.models.builders.ProductoBuilder.elProducto;
import static co.com.bancolombia.certificacion.app.models.builders.TarjetaCreditoBuilder.tarjetaCredito;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PagosStepDefinition {

    @Cuando("^quiere pagar la tarjeta de credito no propia$")
    public void pagoTarjetaCreditoNoPropia(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Pagar.tarjetaCreditoNoPropia(tarjetaCredito().conTarjeta(datos).conTipoPago(datos).conMoneda(datos).conValor(datos), elProducto().conProductoDebitar(datos))
        );
    }

    @Cuando("^quiere pagar la tarjeta de credito propia$")
    public void pagoTarjetaCreditoPropia(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Pagar.tarjetaCreditoPropia(tarjetaCredito().conTarjeta(datos).conTipoPago(datos).conMoneda(datos).conValor(datos), elProducto().conProductoDebitar(datos))
        );
    }

    @Cuando("^quiere pagar la tarjeta de credito propia mayor a la deuda$")
    public void pagoTarjetaCreditoPropiaMayorDeuda(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Pagar.tarjetaCreditoPropiaMayorDeuda(tarjetaCredito().conTarjeta(datos).conTipoPago(datos).conMoneda(datos).conValor(datos))
        );
    }

    @Cuando("^quiere pagar el credito$")
    public void pagoCreditos(List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                Pagar.creditos(credito().conCredito(datos).conTipoPago(datos).conValor(datos), elProducto().conProductoDebitar(datos))
        );
    }

    @Entonces("^deberia de ver el mensaje de confirmacion y la informacion de su pago$")
    public void verMensajeConfirmacionInformacionPago() {
        theActorInTheSpotlight().should(
                seeThat(VerificarPago.exitoso()).orComplainWith(PagoNoRealizadoException.class, PAGO_NO_REALIZADO)
        );
    }

    @Entonces("^deberia de ver el mensaje de valor supera el total de la deuda$")
    public void verMensajeValorMayorDeduda() {
        theActorInTheSpotlight().should(
                seeThat(VerificarMensajePagoMayor.aDeuda()).orComplainWith(MensajeNoPresentadoException.class, MENSAJE_NO_PRESENTADO)
        );
    }

    @Entonces("^deberia de ver el mensaje de confirmacion y la informacion del pago de su credito$")
    public void verMensajeConfirmacionInformacionPagoCredito() {
        theActorInTheSpotlight().should(
                seeThat(VerificarPagoCredito.exitoso()).orComplainWith(PagoNoRealizadoException.class, PAGO_NO_REALIZADO)
        );
    }
}