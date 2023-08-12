package core;

import io.cucumber.java.it.Data;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions
        (features = {"src/test/java/Features"},
                glue = "Steps",
                plugin ={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:test-output/Cucumber.json", "html:test-output/Cucumber.html"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
