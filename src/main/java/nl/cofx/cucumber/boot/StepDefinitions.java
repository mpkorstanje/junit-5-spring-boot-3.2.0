package nl.cofx.cucumber.boot;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions {

    @Before
    public void before(Scenario scenario) {
        scenario.log("Before");
    }

    @Given("an example scenario")
    public void anExampleScenario() {}

    @Then("the scenario passes")
    public void theScenarioPasses() {}
}
