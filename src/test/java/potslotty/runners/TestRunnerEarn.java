package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/bases/Earn.feature",
        glue = {"potslotty.steps",
                "common"
        },
        plugin = {"pretty",
                "html:target/cucumber-reports/Earn.html",
                "json:target/cucumber-reports/Earn.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
        ,tags = "@Test"
)
public class TestRunnerEarn extends AbstractTestNGCucumberTests {
}
