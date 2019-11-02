package co.com.bancolombia.certificacion.app.runners.autenticacion;

import co.com.bancolombia.certificacion.app.runners.RunnerPersonalizado;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.BeforeSuite;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;


/**
 * The type Runner.
 */
@RunWith(RunnerPersonalizado.class)

@CucumberOptions(
        features = {"src/test/resources/features/autenticacion/Trn0369Autenticacion.feature"},
        tags = {"@CasoExitoso"},
        glue = {"co.com.bancolombia.certificacion.app.stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        monochrome = true
)
public class AutenticacionRunner {

    AutenticacionRunner(){}

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/autenticacion/Trn0369Autenticacion.feature");
    }
 }


