package common;

import constants.ConstantGlobal;
import drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.LogUtils;

public class BaseTest {
    public static void createProfileDriver(int profile) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver;
        LogUtils.info("Launching Chrome browser...");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\LongLaptop\\AppData\\Local\\Google\\Chrome\\User Data\\Profile " + ""+profile+"");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        DriverManager.setDriver(driver);
        //PropertiesHelpers.loadAllFiles();
    }

    public static void createDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser("chrome");
        DriverManager.setDriver(driver);
        //PropertiesHelpers.loadAllFiles();
    }
    @Parameters({"BROWSER"})
    public static void createDriver(@Optional("chrome") String browserName) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriver driver = setupBrowser(browserName);
        DriverManager.setDriver(driver);
        //PropertiesHelpers.loadAllFiles();
    }

    public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }


    private static WebDriver initChromeDriver() {
        WebDriver driver;
        LogUtils.info("Launching Chrome browser...");
        //WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        if (ConstantGlobal.PROFILE == true){
            options.addArguments("--user-data-dir=C:\\Users\\LongLaptop\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
        }
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        WebDriver driver;
        System.out.println("Launching Edge browser...");
        //WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if(ConstantGlobal.HEADLESS == true){
            options.addArguments("--headless=new");
            options.addArguments("window-size=1800,900");
        }
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        WebDriver driver;
        System.out.println("Launching Firefox browser...");
        //WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(ConstantGlobal.HEADLESS);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
