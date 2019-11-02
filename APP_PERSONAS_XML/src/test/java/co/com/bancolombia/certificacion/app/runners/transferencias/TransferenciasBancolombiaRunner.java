package co.com.bancolombia.certificacion.app.runners.transferencias;

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
        features = {"src/test/resources/features/transferencias/Trn0438-0538TransferenciasBancolombia.feature"},
        tags = {"@TestCase1"},
        glue = {"co.com.bancolombia.certificacion.app.stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)

public class TransferenciasBancolombiaRunner {

    private TransferenciasBancolombiaRunner(){}

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/transferencias/Trn0438-0538TransferenciasBancolombia.feature");
    }
}
