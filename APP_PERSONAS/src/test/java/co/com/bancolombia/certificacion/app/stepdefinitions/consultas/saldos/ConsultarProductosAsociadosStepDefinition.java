package co.com.bancolombia.certificacion.app.stepdefinitions.consultas.saldos;

import co.com.bancolombia.certificacion.app.exceptions.consultas.saldos.NoPoseeSoloCuentasDepositoException;
import co.com.bancolombia.certificacion.app.exceptions.consultas.saldos.SoloTieneUnProductoException;
import co.com.bancolombia.certificacion.app.exceptions.movimientos.ProductoConMovimientosException;
import co.com.bancolombia.certificacion.app.exceptions.productos.ProductoSinMovimientosException;
import co.com.bancolombia.certificacion.app.questions.consultas.VerificarMovimientos;
import co.com.bancolombia.certificacion.app.questions.consultas.VerificarProducto;
import co.com.bancolombia.certificacion.app.questions.consultas.saldos.RevisarProductos;
import co.com.bancolombia.certificacion.app.questions.consultas.saldos.VerificarCuentasDeposito;
import co.com.bancolombia.certificacion.app.tasks.consultas.saldos.ConsultarMovimientos;
import co.com.bancolombia.certificacion.app.tasks.consultas.saldos.ConsultarProductos;
import co.com.bancolombia.certificacion.app.tasks.consultas.saldos.GuardarDatos;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

import static co.com.bancolombia.certificacion.app.exceptions.consultas.saldos.NoPoseeSoloCuentasDepositoException.MENSAJE_NO_TIENE_UNICAMENTE_CUENTAS_DEPOSITO;
import static co.com.bancolombia.certificacion.app.exceptions.consultas.saldos.SoloTieneUnProductoException.MENSAJE_SOLO_TIENE_UN_PRODUCTO;
import static co.com.bancolombia.certificacion.app.exceptions.movimientos.ProductoConMovimientosException.CON_MOVIMIENTOS;
import static co.com.bancolombia.certificacion.app.exceptions.productos.ProductoSinMovimientosException.SIN_MOVIMIENTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarProductosAsociadosStepDefinition {

    @Cuando("^consulto en (.*) los movimientos con tipo (.*) y numero cuenta (.*)$")
    public void revisarMisMovimientosEnApp(String categoria,String tipoCuenta, String numeroCuenta) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarProductos.sinMovimientosConInformacion(categoria,tipoCuenta, numeroCuenta)
        );
    }

    @Cuando("^quiero revisar mis movimientos de cuenta deposito en la app con tipo de cuenta (.*) y numero cuenta (.*)$")
    public void revisarMisMovimientosCuentasEnlaApps(String tipoCuenta, String numeroCuenta) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarMovimientos.deCuentas(tipoCuenta, numeroCuenta)
        );
    }

    @Cuando("^quiero revisar mis movimientos de inversiones con tipo de cuenta (.*) y numero cuenta (.*)$")
    public void revisarMisMovimientosInversiones(String tipoCuenta, String numeroCuenta) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarMovimientos.deInversiones(tipoCuenta, numeroCuenta)
        );
    }

    @Cuando("^quiero revisar mis movimientos de tarjeta de credito en la app con tipo de cuenta (.*) y numero cuenta (.*)$")
    public void revisarMisMovimientosTarjetaEnlaApps(String tipoCuenta, String numeroCuenta) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarMovimientos.deTarjetasCredito(tipoCuenta, numeroCuenta)
        );
    }

    @Cuando("^quiero revisar mis movimientos de eprepago en la app con tipo de cuenta (.*) y numero cuenta (.*)$")
    public void revisarMisMovimientosEprepago(String tipoCuenta, String numeroCuenta) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarMovimientos.deEprepago(tipoCuenta, numeroCuenta)
        );
    }

    @Y("el ingresa a sus productos$")
    public void ingresaSusProductos() {
        theActorInTheSpotlight().attemptsTo(
                GuardarDatos.deProductos()
        );
    }

    @Entonces("^El deberia ver unicamente cuentas deposito$")
    public void deberiaVerUnicamenteCuentasDeposito() {
        theActorInTheSpotlight().should(seeThat(
                VerificarCuentasDeposito.comoUnicoProducto()).orComplainWith(
                NoPoseeSoloCuentasDepositoException.class, MENSAJE_NO_TIENE_UNICAMENTE_CUENTAS_DEPOSITO
                )
        );
    }

    @Entonces("^El deberia de ver los movimientos asociados a su cuenta$")
    public void deberiaVerMovimientosAsociadosSuCuenta() {
        theActorInTheSpotlight().should(seeThat(VerificarMovimientos.productos())
                .orComplainWith(ProductoSinMovimientosException.class, SIN_MOVIMIENTOS)
        );
    }

    @Entonces("^El deberia de ver los productos asociados a su cuenta$")
    public void deberiaVerProductosAsociadosSuCuenta() {
        theActorInTheSpotlight().should(seeThat(
                RevisarProductos.pertenecientesAlUsuario()).orComplainWith(
                SoloTieneUnProductoException.class, MENSAJE_SOLO_TIENE_UN_PRODUCTO
                )
        );
    }

    @Entonces("^El deberia de ver el mensaje (.*)$")
    public void deberiaVerLosMovimientosNingunMovimientoConLaTarjeta(String mensaje) {
        theActorInTheSpotlight().should(seeThat(
                VerificarProducto.sinMovimientos(mensaje)
                ).orComplainWith(ProductoConMovimientosException.class, CON_MOVIMIENTOS)
        );
    }
}