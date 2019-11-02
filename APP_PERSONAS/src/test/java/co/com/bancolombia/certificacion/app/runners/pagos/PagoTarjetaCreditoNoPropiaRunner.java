package co.com.bancolombia.certificacion.app.runners.pagos;

import co.com.bancolombia.certificacion.app.utilidades.customrunner.RunnerPersonalizado;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.BeforeSuite;
import co.com.bancolombia.certificacion.app.utilidades.datosexcel.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

import static co.com.bancolombia.certificacion.app.utilidades.constantes.TipoClaseConstante.CLASE_RUNNER;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = {"src/test/resources/features/pagos/pago_tc_no_propias.feature"},
        glue = {"co.com.bancolombia.certificacion.app.stepdefinitions"},
        snippets = SnippetType.CAMELCASE)
public class PagoTarjetaCreditoNoPropiaRunner {
    public PagoTarjetaCreditoNoPropiaRunner() {
        throw new IllegalStateException(CLASE_RUNNER);
    }

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/pagos/pago_tc_no_propias.feature");
    }
}
