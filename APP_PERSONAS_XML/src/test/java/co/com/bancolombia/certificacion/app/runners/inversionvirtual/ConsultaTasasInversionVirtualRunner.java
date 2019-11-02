package co.com.bancolombia.certificacion.app.runners.inversionvirtual;

import co.com.bancolombia.certificacion.app.runners.RunnerPersonalizado;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.BeforeSuite;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = {"src/test/resources/features/inversionvirtual/Trn0322ConsultaDeTasasInversionVirtual.feature"},
        tags = {"@CasoExitoso1"},
        glue = {"co.com.bancolombia.certificacion.app.stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)

public class ConsultaTasasInversionVirtualRunner {

    private ConsultaTasasInversionVirtualRunner(){}

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/inversionvirtual/Trn0322ConsultaDeTasasInversionVirtual.feature");
    }
}
