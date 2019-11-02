package co.com.bancolombia.certificacion.manualtest.runners.inactivacion;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/inactivacion/trn1230_inactivacion_e_prepago.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class Trn1232InactivacionEprepago {
}

