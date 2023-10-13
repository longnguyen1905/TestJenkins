package common;


import com.google.common.collect.ImmutableMap;
import constants.ConstantGlobal;
import drivers.DriverManager;
import helpers.PropertiesHelper;
import io.cucumber.java.*;
import keywords.Keyword;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import common.BaseTest;
import potslotty.pages.LoginPage;
import reports.AllureManager;
import utils.LogUtils;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Environment", ConstantGlobal.ENV.toUpperCase())
                        .put("Browser", "Chrome")
                        .build(),
                System.getProperty("user.dir") + "/target/allure-results/");

    }

    @AfterAll
    public static void afterAll() {

    }

    @Before
    public void beforeScenario() {
        BaseTest.createDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        BaseTest.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        LogUtils.info(scenario.getName());
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
            AllureManager.saveScreenshotPNG();
        }
    }
}
