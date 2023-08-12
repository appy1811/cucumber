package core;

import Utilities.WebUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks  extends TestContext {

    @Before("@Web")
    public void beforeScenario(Scenario scenario) throws IOException {
        driver = WebUtil.initWebDriver();

    }

    @After("@Web")
    public void afterScenario(Scenario scenario) {
        WebUtil.closeDriver();

    }

    @AfterStep("@Web")
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log("this text appears after every step");
            scenario.attach(WebUtil.takeScrrenshot(), "image/png", scenario.getName() + ".png");
        }
    }
}



