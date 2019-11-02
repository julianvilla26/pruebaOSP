package co.com.bancolombia.certificacion.app.questions.basededatos.iseries.saldos;

import co.com.bancolombia.certificacion.app.integration.basededatos.iseries.creditos.Creditos;
import co.com.bancolombia.certificacion.app.models.productos.Producto;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.clearReport;
import static co.com.bancolombia.certificacion.app.utilidades.administradores.VerificarCampos.validarCampo;
import static co.com.bancolombia.certificacion.app.utilidades.constantes.ModeloConstantes.MODELO_PRODUCTO_SALDOS_MOVIMIENTOS;

public class ConsultarSaldosConsolidadosCreditos implements Question<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(ConsultarSaldosConsolidadosCreditos.class);

    public ConsultarSaldosConsolidadosCreditos() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        clearReport();
        Boolean resultFinal = false;
        List<Map<String, Object>> registros;
        List<Producto> listaProductos = actor.recall(MODELO_PRODUCTO_SALDOS_MOVIMIENTOS);
        registros = Creditos.saldoCreditosConsolidado(actor);

        if (!registros.isEmpty()) {
            Boolean resultadoDato = true;

            String deudaFecha = registros.get(0).get("deuda_fecha").toString().trim();
            String valorTotal = registros.get(0).get("valor_total").toString().trim();


            String saldoTotalFront = listaProductos.get(0).getSaldo().getSaldoDisponible().replace("$", "").replace(".", "").replace(",", ".").trim();

            resultadoDato = validarCampo("CUENTA", registros.get(0).get("numero_credito").toString().trim(), listaProductos.get(0).getNumero().replace("-", ""), resultadoDato);
            resultadoDato = validarCampo("SALDO TOTAL", valorTotal, saldoTotalFront, resultadoDato);

            if (resultadoDato) {
                resultFinal = true;
            }
            Serenity.recordReportData().withTitle("Verificacion Back saldos creditos").andContents(Serenity.sessionVariableCalled("informes_serenity"));
        } else {
            LOGGER.info("Sin registros en la consulta");
        }
        return resultFinal;
    }


}
