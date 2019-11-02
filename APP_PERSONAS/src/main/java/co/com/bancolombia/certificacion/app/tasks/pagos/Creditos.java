package co.com.bancolombia.certificacion.app.tasks.pagos;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.productos.Credito;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.pagos.PagosPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar.elementoVisible;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.OTRO_VALOR;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_CREDITO;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_DETALLE_PRODUCTO;

public class Creditos implements Task {
    private Credito credito;
    private Producto productoDebitar;

    public Creditos(Credito credito, Producto productoDebitar) {
        this.credito = credito;
        this.productoDebitar = productoDebitar;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(elementoVisible(actor, LBL_CREDITOS)).andIfSo(
                        Validar.carga(),
                        Click.on(BTN_CREDITO.of(credito.getTipo(), credito.getNumero()))
                ),
                RealizarScroll.hastaPosicionDeTarget(LBL_TIPO_PAGO.of(credito.getTipoPago())),
                Click.on(LBL_TIPO_PAGO.of(credito.getTipoPago())),
                Check.whether(OTRO_VALOR.equals(credito.getTipoPago())).andIfSo(
                        Enter.theValue(credito.getValorPago()).into(TXT_VALOR_PAGAR),
                        Click.on(FOCO_PAGOS),
                        Click.on(LNK_SIGUIENTE)
                ),
                RealizarScroll.hastaPosicionDeTarget(OPT_PRODUCTO_ORIGEN.of(productoDebitar.getTipo(), productoDebitar.getNumero())),
                Click.on(OPT_PRODUCTO_ORIGEN.of(productoDebitar.getTipo(), productoDebitar.getNumero())),
                Validar.carga(),
                Click.on(BTN_PAGAR),
                Validar.carga(),
                RealizarScroll.hastaPosicionDeTarget(LNK_PRODUCTO_ORIGEN),
                Click.on(LNK_PRODUCTO_ORIGEN)
        );
        actor.remember(MODELO_DETALLE_PRODUCTO, productoDebitar);
        actor.remember(MODELO_CREDITO, credito);
    }
}
