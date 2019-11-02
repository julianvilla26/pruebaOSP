package co.com.bancolombia.certificacion.app.interactions.eprepago;

import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.productos.Eprepago;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.EprepagoBuilder.eprepago;
import static co.com.bancolombia.certificacion.app.models.builders.SaldoBuilder.saldo;
import static co.com.bancolombia.certificacion.app.userinterface.pages.eprepago.ActivacionInactivacionEprepagoPage.TXT_CAMPOS_ACTIVACION_EPREPAGO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_EPREPAGO;

public class GuardarCamposEprepago implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Eprepago> listaCamposEprepago = new ArrayList<>();

        RealizarScroll.hastaPosicionDeTarget(TXT_CAMPOS_ACTIVACION_EPREPAGO.of(CODIGOSEGURIDAD));
        listaCamposEprepago.add(
                eprepago()
                        .conSaldoDisponible(
                                saldo().conSaldoDisponible(
                                        TXT_CAMPOS_ACTIVACION_EPREPAGO.of(SALDO_DISPONIBLE).resolveFor(actor).getText()).build()
                        )
                        .conNumeroTarjeta(TXT_CAMPOS_ACTIVACION_EPREPAGO.of(TARJETA_MASTERCARD).resolveFor(actor).getText())
                        .conFechaVencimiento(TXT_CAMPOS_ACTIVACION_EPREPAGO.of(FECHAVENCIMIENTO).resolveFor(actor).getText())
                        .conCvc(TXT_CAMPOS_ACTIVACION_EPREPAGO.of(CODIGOSEGURIDAD).resolveFor(actor).getText()).build()
        );
        actor.remember(MODELO_EPREPAGO, listaCamposEprepago);
    }

    public static GuardarCamposEprepago esExitoso() {
        return new GuardarCamposEprepago();
    }
}