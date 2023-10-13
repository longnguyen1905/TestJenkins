package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/bases/Search.feature",
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/Search.html",
                "json:target/cucumber-reports/Search.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//        ,tags = "@Test"
)

public class TestRunnerSearch extends AbstractTestNGCucumberTests {
    //    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
