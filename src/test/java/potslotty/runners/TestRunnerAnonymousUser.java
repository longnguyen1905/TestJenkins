package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/bases/HomeAnonymousUser.feature"
        },
        glue = {"potslotty.steps",
                "common"
        },
        plugin = {"pretty",
                "html:target/cucumber-reports/HomeAnonymousUser.html",
                "json:target/cucumber-reports/HomeAnonymousUser.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
        ,tags = "@Test"
)
public class TestRunnerAnonymousUser extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }
}