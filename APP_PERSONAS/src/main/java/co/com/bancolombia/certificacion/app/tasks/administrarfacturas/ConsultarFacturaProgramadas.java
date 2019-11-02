package co.com.bancolombia.certificacion.app.tasks.administrarfacturas;

import co.com.bancolombia.certificacion.app.models.administrarfacturas.Factura;
import co.com.bancolombia.certificacion.app.utilidades.administradores.Verificar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.List;

import static co.com.bancolombia.certificacion.app.models.builders.FacturaBuilder.factura;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ConsultaDetalleFacturaPage.*;
import static co.com.bancolombia.certificacion.app.userinterface.pages.administrarfacturas.ProgramarPagarFacturasPage.OPT_PROGRAMADAS;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_FACTURA;

public class ConsultarFacturaProgramadas implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPT_PROGRAMADAS)
        );
        int iterador = 0;
        List<Factura> listaFactura = new ArrayList<>();
        while (Verificar.elementoVisible(actor, LBL_DESCRIPCION_PROGRAMADA_FACTURA.of(String.valueOf(iterador)))) {
            listaFactura.add(factura()
                    .conDescripcionFactura(LBL_DESCRIPCION_PROGRAMADA_FACTURA.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conEmpresaServicio(LBL_EMPRESA_CONVENIO_FACTURA_PROGRAMADA.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conFechaFactura(LBL_FECHA_FACTURA_PROGRAMADA.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .conValor(LBL_VALOR_FACTURA_PROGRAMADA.of(String.valueOf(iterador)).resolveFor(actor).getText())
                    .build()
            );
            iterador++;
        }
        actor.remember(MODELO_FACTURA, listaFactura);
    }
}