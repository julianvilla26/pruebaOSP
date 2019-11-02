package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.interactions.comunes.Saltar;
import co.com.bancolombia.certificacion.app.interactions.recaudos.SeleccionarOpcionFactura;
import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.*;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.Constantes.SELECCIONAR_TODAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_HISTORICO_FACTURA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HistoricoPago implements Task {
    private Factura factura;
    private String opcion;

    public HistoricoPago(String opcion,Factura factura) {
        this.factura = factura;
        this.opcion = opcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Saltar.onBoarding(),
                Check.whether(!opcion.equalsIgnoreCase(SELECCIONAR_TODAS)).andIfSo(
                        SeleccionarOpcionFactura.conInformacion(OPT_VER_HISTORICO_FACTURA, factura)
                )
        );
        int iterador = 1;
        List<Factura> listaHistoricoPago = new ArrayList<>();
        actor.attemptsTo(
                WaitUntil.the(LBL_CONTENEDOR_HISTORICO_PAGO.of(String.valueOf(iterador)), isVisible())
        );
        while (Verificar.elementoVisible(actor, LBL_CONTENEDOR_HISTORICO_PAGO.of(String.valueOf(iterador)))) {
            listaHistoricoPago.add(factura().
                    conReferencia(LBL_REFERENCIA_HISTORICO_PAGO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conFechaFactura(LBL_FECHA_HISTORICO_PAGO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conEstadoHistorico(LBL_ESTADO_HISTORICO_PAGO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conValor(LBL_VALOR_HISTORICO_PAGO.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .build()
            );
            iterador++;
        }
        actor.remember(MODELO_HISTORICO_FACTURA, listaHistoricoPago);
    }
}