package co.com.bancolombia.certificacion.manualtest.runners.consulta.saldos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta/saldos/trn0327_consulta_saldos_por_producto_inversiones.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Trn0327ConsultaSaldosPorProductoInversionesRunner {
}
