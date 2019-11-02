package co.com.bancolombia.certificacion.manualtest.runners.consulta.detalle;

        import cucumber.api.CucumberOptions;
        import cucumber.api.SnippetType;
        import net.serenitybdd.cucumber.CucumberWithSerenity;
        import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/consulta/detalle/trn0228_consulta_detalle_e-prepago.feature",
        glue = "co.com.bancolombia.certificacion.manualtest.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)

public class Trn0228ConsultaDetalleEprepagoRunner {
}
