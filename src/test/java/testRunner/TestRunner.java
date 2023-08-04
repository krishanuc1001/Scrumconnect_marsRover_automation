package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/Rover.feature",
        glue = "stepDefinitions",
        dryRun = true,
        monochrome = true)

public class TestRunner {
}