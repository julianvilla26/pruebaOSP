package co.com.bancolombia.certificacion.app.stepdefinitions.transferencia;

import co.com.bancolombia.certificacion.app.exceptions.comunes.MensajeCuentaSinSaldoException;
import co.com.bancolombia.certificacion.app.exceptions.transferencias.TransferenciaFallida;
import co.com.bancolombia.certificacion.app.questions.pagos.VerificarMensajeSin;
import co.com.bancolombia.certificacion.app.questions.transferencia.VerificarTransferencia;
import co.com.bancolombia.certificacion.app.tasks.transferencia.RealizarTransferencia;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.exceptions.comunes.MensajeCuentaSinSaldoException.MENSAJE_CUENTA_SIN_SALDO_NO_PRESENTADO;
import static co.com.bancolombia.certificacion.app.exceptions.transferencias.TransferenciaFallida.TRANSFERENCIA_FALLIDA;
import static co.com.bancolombia.certificacion.app.models.builders.TransferenciaBuilder.con;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciaStepDefinition {

    @Cuando("el transfiere desde (.*) hacia el producto (.*)$")
    public void diligenciaDatosDeTransferencia(String tipoProductoOrigen, String tipoProductoDestino, List<Map<String, String>> datos) {
        theActorInTheSpotlight().attemptsTo(
                RealizarTransferencia.conInfo(
                        con().
                                conTipoTransferencia(datos)
                                .conNumeroCuentaOrigen(datos).conTipoCuentaOrigen(datos)
                                .conNumeroCuentaDestino(datos).conTipoCuentaDestino(datos)
                                .conMonto(datos), tipoProductoOrigen, tipoProductoDestino));
    }

    @Entonces("deberia ver la confirmacion exitosa de la transferencia$")
    public void deberiaVerConfirmacionExitosaDeTransferencia() {
        theActorInTheSpotlight().should(seeThat(VerificarTransferencia.exitosa()).orComplainWith(TransferenciaFallida.class, TRANSFERENCIA_FALLIDA));
    }

    @Entonces("deberia ver el mensaje de error: cuenta origen sin saldo$")
    public void deberiaVerMensajePagoCuentaSinSaldo() {
        theActorInTheSpotlight().should(seeThat(
                VerificarMensajeSin.saldo())
                .orComplainWith(MensajeCuentaSinSaldoException.class, MENSAJE_CUENTA_SIN_SALDO_NO_PRESENTADO)
        );
    }
}