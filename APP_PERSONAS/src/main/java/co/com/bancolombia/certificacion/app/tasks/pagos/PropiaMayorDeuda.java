package co.com.bancolombia.certificacion.app.tasks.pagos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.productos.TarjetaCredito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.pagos.PagosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.OTRO_VALOR;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.VISA;

public class PropiaMayorDeuda implements Task {
    private TarjetaCredito tarjetaCredito;

    public PropiaMayorDeuda(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, TXT_TARJETAS)).andIfSo(
                        Validar.carga(),
                        RealizarScroll.hastaPosicionDeTarget(BTN_TARJETA_CREDITO_PAGAR.of(tarjetaCredito.getTipo(), tarjetaCredito.getNumero())),
                        Click.on(BTN_TARJETA_CREDITO_PAGAR.of(tarjetaCredito.getTipo(), tarjetaCredito.getNumero()))
                ),
                RealizarScroll.hastaPosicionDeTarget(LBL_TIPO_PAGO.of(tarjetaCredito.getTipoPago())),
                Click.on(LBL_TIPO_PAGO.of(tarjetaCredito.getTipoPago())),
                Check.whether(OTRO_VALOR.equals(tarjetaCredito.getTipoPago())).andIfSo(
                        Check.whether(!tarjetaCredito.getTipo().toLowerCase().contains(VISA.toLowerCase())).andIfSo(
                                Click.on(CHK_MONEDA.of(tarjetaCredito.getMoneda()))
                        ),
                        Enter.theValue(tarjetaCredito.getValorPago()).into(TXT_VALOR_PAGAR),
                        Click.on(FOCO_PAGO_PROPIAS.of(tarjetaCredito.getNumero())),
                        Click.on(LNK_SIGUIENTE)
                )
        );
    }
}
