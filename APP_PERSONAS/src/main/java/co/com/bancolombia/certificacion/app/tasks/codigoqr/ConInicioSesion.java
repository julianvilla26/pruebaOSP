package co.com.bancolombia.certificacion.app.tasks.codigoqr;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.scroll.RealizarScroll;
import co.com.bancolombia.certificacion.app.models.builders.TransferenciaBuilder;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencia;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.codigoqr.GenerarCodigoQrPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.CUENTAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.SIN_VALOR;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_INFO_CODIGO_QR;
import static co.com.bancolombia.certificacion.app.utilidades.string.UtileriaString.darFormato;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConInicioSesion extends GenerarQR {
    private Transferencia datos;

    public ConInicioSesion(TransferenciaBuilder datos) {
        this.datos = datos.build();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                WaitUntil.the(LNK_SIGUIENTE, isEnabled()),
                Click.on(LNK_SIGUIENTE)
        );
        if (Verificar.elementoVisible(actor, LBL_VERIFICACION.of(CUENTAS))) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_PRODUCTO_ORIGEN.of(datos.getProductoOrigen().getTipo(), datos.getProductoOrigen().getNumero()), isPresent()),
                    RealizarScroll.hastaPosicionDeTarget(BTN_PRODUCTO_ORIGEN.of(datos.getProductoOrigen().getTipo(), datos.getProductoOrigen().getNumero())),
                    Click.on(BTN_PRODUCTO_ORIGEN.of(datos.getProductoOrigen().getTipo(), datos.getProductoOrigen().getNumero()))
            );
        }
        actor.attemptsTo(
                Check.whether("".equals(datos.getMonto())).andIfSo(
                        Click.on(BTN_SIN_VALOR)
                ).otherwise(
                        Click.on(BTN_CON_VALOR),
                        Enter.theValue(datos.getMonto()).into(TXT_VALOR_RECIBIR),
                        Click.on(FOCO)
                ),
                Click.on(LNK_SIGUIENTE),
                Enter.theValue(datos.getDescripcion()).into(TXT_DESCRIPCION),
                Click.on(FOCO),
                WaitUntil.the(BTN_SIGUIENTE, isVisible()),
                Click.on(BTN_SIGUIENTE),
                Click.on(BTN_GENERAR_QR),
                Validar.carga()
        );
        if ("".equals(datos.getMonto()))
            datos.setMonto(SIN_VALOR);
        else
            datos.setMonto(darFormato(datos.getMonto()));
        actor.remember(MODELO_INFO_CODIGO_QR, datos);
    }
}
