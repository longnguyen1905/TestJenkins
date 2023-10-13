package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/deposits/DepositOverview.feature",
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/DepositOverview.html",
                "json:target/cucumber-reports/DepositOverview.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//        ,tags = "@Test"
)
public class TestRunnerDepositOverview extends AbstractTestNGCucumberTests {
    //    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
