package potslotty.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {
                "src/test/resources/features/deposits/DepositTonKeeper.feature",
                "src/test/resources/features/deposits/DepositTonHub.feature",
                "src/test/resources/features/deposits/DepositTonQRCode.feature",
                "src/test/resources/features/deposits/DepositMYR.feature"
        },
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/Deposit.html",
                "json:target/cucumber-reports/Deposit.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//        ,tags = "@Test"
)

public class TestRunnerDeposit extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
