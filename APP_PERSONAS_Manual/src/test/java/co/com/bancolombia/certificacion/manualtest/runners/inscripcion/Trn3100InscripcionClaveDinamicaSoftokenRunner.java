package co.com.bancolombia.certificacion.manualtest.runners.inscripcion;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/inscripcion/trn3100_inscripcion_clave_dinamica_softoken.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Trn3100InscripcionClaveDinamicaSoftokenRunner {
}
