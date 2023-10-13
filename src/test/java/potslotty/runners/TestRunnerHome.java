package potslotty.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/bases/Home.feature",
        },
        glue = {"potslotty.steps",
                "common"
        },
        plugin = {"pretty",
                "html:target/cucumber-reports/Home.html",
                "json:target/cucumber-reports/Home.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
//        ,tags = "@Test"
)
public class TestRunnerHome extends AbstractTestNGCucumberTests {
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}