package co.com.bancolombia.certificacion.manualtest.runners.pagos;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/pagos/trn0346_pago_prestamos.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class Trn0346PagoPrestamosRunner {
}
