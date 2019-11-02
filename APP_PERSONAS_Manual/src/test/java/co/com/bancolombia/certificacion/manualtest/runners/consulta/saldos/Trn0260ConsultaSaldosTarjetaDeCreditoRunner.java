package co.com.bancolombia.certificacion.manualtest.runners.consulta.saldos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta/saldos/trn0260_consulta_saldos_tarjeta_de_credito.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Trn0260ConsultaSaldosTarjetaDeCreditoRunner {
}
