package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",      // Path to the feature files
        glue = {"stepDefinitions"},                  // Package with step definitions
        plugin = {"pretty", "html:target/cucumber-reports.html"}  // Report generation
)

public class TestRunner extends AbstractTestNGCucumberTests{

    // This class will run your Cucumber tests
    // No need to write any test methods here.
    // TestNG will automatically pick up the feature files defined in the @CucumberOptions
    // and execute them using the step definitions in the specified glue package.

}
