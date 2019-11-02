package co.com.bancolombia.certificacion.manualtest.runners.consulta.movimientos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta/movimientos/trn0264_consulta_movimientos_tarjetas_de_credito.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Trn0264ConsultaMovimientosTarjetasDeCreditoRunner {
}
