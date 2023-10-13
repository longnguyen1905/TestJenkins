package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features/withdraws/WithdrawTon.feature",
                "src/test/resources/features/withdraws/WithdrawMYR.feature"
        },
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/WithdrawTon.html",
                "json:target/cucumber-reports/WithdrawTon.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//       ,tags = "@Test"
)

public class TestRunnerWithdraw extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
