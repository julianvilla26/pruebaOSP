package co.com.bancolombia.certificacion.app.tasks.transferencia;

import co.com.bancolombia.certificacion.app.interactions.comunes.Validar;
import co.com.bancolombia.certificacion.app.interactions.consultas.saldos.SeleccionarProducto;
import co.com.bancolombia.certificacion.app.models.builders.TransferenciaBuilder;
import co.com.bancolombia.certificacion.app.models.transaccion.Transferencia;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.bancolombia.certificacion.app.userinterface.pages.GeneralPage.LNK_SIGUIENTE;
import static co.com.bancolombia.certificacion.app.userinterface.pages.consultas.saldos.SaldosMovimientosPage.CUENTA_ESPECIFICA_PRODUCTO;
import static co.com.bancolombia.certificacion.app.userinterface.pages.transferencia.TransferenciaPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_TRANSFERENCIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferencia implements Task {
    private Transferencia transferencia;
    private String opcionProductoOrigen;
    private String opcionProductoDestino;

    public RealizarTransferencia(Transferencia transferencia, String opcionProductoOrigen, String opcionProductoDestino) {
        this.transferencia = transferencia;
        this.opcionProductoOrigen = opcionProductoOrigen;
        this.opcionProductoDestino = opcionProductoDestino;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(OPCION_INVERSIONES.equalsIgnoreCase(opcionProductoOrigen))
                        .andIfSo(
                                Click.on(BTN_INVERSIONES)
                        ).otherwise(
                            Click.on(BTN_CUENTAS)
                    ),

                SeleccionarProducto.desdeSaldosMovimientos(transferencia.getProductoOrigen().getTipo(), transferencia.getProductoOrigen().getNumero(), CUENTA_ESPECIFICA_PRODUCTO),
                Enter.theValue(transferencia.getMonto()).into(TXT_VALOR_TRANSFERENCIA),
                Click.on(TXT_FOCO),
                Click.on(LNK_SIGUIENTE),
                Check.whether((transferencia.getTipoTransferencia()).contains(TRANSFERIR_PRODUCTOS_NO_INSCRITOS)).
                        andIfSo(
                                Click.on(OPT_TIPO_TRANSFERENCIA.of(TRANSFERIR_PRODUCTOS_NO_INSCRITOS)),
                                Enter.theValue(transferencia.getProductoDestino().getNumero()).into(TXT_NUMERO_CUENTA_DESTINO),
                                Click.on(TXT_FOCO),
                                Click.on(CHK_TIPO_CUENTA.of(transferencia.getProductoDestino().getTipo())),
                                Click.on(LNK_SIGUIENTE)).
                        otherwise(
                                Check.whether(transferencia.getTipoTransferencia().contains(TRANSFERIR_PRODUCTOS_PROPIOS_INSCRITOS)).andIfSo(
                                        Click.on(OPT_TIPO_TRANSFERENCIA.of(TRANSFERIR_PRODUCTOS_PROPIOS_INSCRITOS)),
                                        Check.whether(INSCRITOS.contains(opcionProductoDestino)).andIfSo(
                                                Click.on(BTN_TIPO_PRODUCTO_DESTINO.of(opcionProductoDestino)),
                                                Click.on(BTN_PRODUCTO_INSCRITO.of(transferencia.getProductoDestino().getNumero()))
                                        ).otherwise(
                                                SeleccionarProducto.desdeSaldosMovimientos(transferencia.getProductoDestino().getTipo(), transferencia.getProductoDestino().getNumero(), CUENTA_ESPECIFICA_PRODUCTO)
                                        )
                                ).otherwise(
                                        Click.on(OPT_TIPO_TRANSFERENCIA.of(TRANSFERIR_PRODUCTOS_DE_OTROS)),
                                        SeleccionarProducto.desdeSaldosMovimientos(transferencia.getProductoDestino().getTipo(), transferencia.getProductoDestino().getNumero(), CUENTA_ESPECIFICA_PRODUCTO),
                                        Click.on(LNK_SIGUIENTE)
                                        )
                        ),
                WaitUntil.the(BTN_ENVIAR_DINERO, isClickable()),
                Click.on(BTN_ENVIAR_DINERO),
                Validar.carga()
        );
        actor.remember(MODELO_TRANSFERENCIA, transferencia);
    }

    public static RealizarTransferencia conInfo(TransferenciaBuilder transferencia, String opcionProductoOrigen, String opcionProductodestino) {
        return instrumented(RealizarTransferencia.class, transferencia.build(), opcionProductoOrigen, opcionProductodestino);
    }
}