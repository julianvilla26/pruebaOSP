package co.com.bancolombia.certificacion.app.tasks.pagos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import co.com.bancolombia.certificacion.app.models.productos.TarjetaCredito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.pagos.PagosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_TARJETA_CREDITO;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Propia implements Task {
    private TarjetaCredito tarjetaCredito;
    private Producto productoDebitar;

    public Propia(TarjetaCredito tarjetaCredito, Producto productoDebitar) {
        this.tarjetaCredito = tarjetaCredito;
        this.productoDebitar = productoDebitar;
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
                ),
                RealizarScroll.hastaPosicionDeTarget(BTN_PRODUCTO_ORIGEN.of(productoDebitar.getTipo(), productoDebitar.getNumero())),
                Click.on(BTN_PRODUCTO_ORIGEN.of(productoDebitar.getTipo(), productoDebitar.getNumero())),
                Validar.carga(),
                Click.on(BTN_PAGAR),
                Validar.carga(),
                RealizarScroll.hastaPosicionDeTarget(LNK_PRODUCTO_ORIGEN),
                Click.on(LNK_PRODUCTO_ORIGEN)
        );
        tarjetaCredito.setValorPago(darFormato(tarjetaCredito.getValorPago()));
        actor.remember(MODELO_DETALLE_PRODUCTO, productoDebitar);
        actor.remember(MODELO_TARJETA_CREDITO, tarjetaCredito);
    }
}
