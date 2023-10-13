package potslotty.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/deposits/DepositTonKeeper.feature",
                "src/test/resources/features/deposits/DepositTonHub.feature",
                "src/test/resources/features/deposits/DepositTonQRCode.feature",
                "src/test/resources/features/deposits/DepositMYR.feature",
                "src/test/resources/features/deposits/DepositOverview.feature",
                "src/test/resources/features/withdraws/WithdrawTon.feature",
                "src/test/resources/features/withdraws/WithdrawMYR.feature",
                "src/test/resources/features/withdraws/ProfileOverview.feature",
                "src/test/resources/features/bases/Tournament.feature",
                "src/test/resources/features/bases/Header.feature",
                "src/test/resources/features/bases/Earn.feature",
                "src/test/resources/features/bases/Home.feature",
                "src/test/resources/features/bases/Results.feature",
                "src/test/resources/features/bases/Search.feature",
        },
        glue = {
                "potslotty.steps",
                "common"
        },
        plugin = {
                "pretty",
                "html:target/cucumber-reports/AllFeature.html",
                "json:target/cucumber-reports/AllFeature.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
        //,tags = "@Test"
)

public class TestRunnerAll extends AbstractTestNGCucumberTests {
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
