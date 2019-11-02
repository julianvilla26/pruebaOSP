
package co.com.bancolombia.certificacion.manualtest.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;

import static co.com.bancolombia.certification.manualtestlib.ManualTest.validate;

public class PruebaManualStepDefinition {
    private Scenario scenario;

    @Before
    public void getScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Dado("^(.*)$")
    public void manualTestDefinitions(String step){
        validate(step, scenario.getName());
    }
}
