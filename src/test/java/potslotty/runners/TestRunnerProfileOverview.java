package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/withdraws/ProfileOverview.feature",
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/ProfileOverview.html",
                "json:target/cucumber-reports/ProfileOverview.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
      ,tags = "@Test"
)
public class TestRunnerProfileOverview extends AbstractTestNGCucumberTests {
        //    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
