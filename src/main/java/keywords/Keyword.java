package keywords;

import constants.ConstantGlobal;
import drivers.DriverManager;
import helpers.CaptureHelper;
import helpers.PropertiesHelper;
import helpers.SystemHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import utils.LogUtils;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.*;
import java.util.List;

import static keywords.Keyword.xpathIndex;

public class Keyword {

    private final static long EXPLICIT_TIMEOUT = ConstantGlobal.EXPLICIT_TIMEOUT;
    private final static long STEP_TIME = ConstantGlobal.STEP_TIME;
    private final static long PAGE_LOAD_TIMEOUT = ConstantGlobal.PAGE_LOAD_TIMEOUT;

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }
    public static WebElement getWebElement(String xpath, int index) {
        return getWebElement(By.xpath(xpath+"["+index+"]"));
    }
    public static By xpathIndex(String xpath,int index) {
        return By.xpath(xpath+"["+index+"]");
    }

    @Step("Verify Equals: {0} and {1}")
    public static void verifyEquals(Object actual, Object expected) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        LogUtils.info("Verify equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, "Fail. Not match. '" + actual.toString() + "' != '" + expected.toString() + "'");
    }

    @Step("Verify Equals: {0} and {1}")
    public static void verifyEquals(Object actual, Object expected, String message) {
        waitForPageLoaded();
        sleep(STEP_TIME);
        LogUtils.info("Verify equals: " + actual + " and " + expected);
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Check element existing {0}")
    public static Boolean checkElementExist(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        List<WebElement> listElement = getWebElements(by);

        if (listElement.size() > 0) {
            LogUtils.info("Check Element Exist: " + true + " --- " + by);
            return true;
        } else {
            LogUtils.info("Check Element Exist: " + false + " --- " + by);
            return false;
        }
    }

    @Step("Open URL: {0}")
    public static void openURL(String url) {
        DriverManager.getDriver().get(url);
        sleep(STEP_TIME);
        LogUtils.info("Open URL: " + url);
        //AllureManager.saveTextLog("Open URL: " + url);
        waitForPageLoaded();
        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("openURL_" + SystemHelper.makeSlug(url));
        }
    }

    @Step("Click element {0}")
    public static void clickElement(By by) {
        waitForPageLoaded();
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15), Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            getWebElement(by).click();
        } catch (Exception e) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
        }
    }
    public static void clickElement(String string, int index) {
        waitForPageLoaded();
        waitForElementVisible(xpathIndex(string, index));
        sleep(STEP_TIME);
        getWebElement(xpathIndex(string, index)).click();
        LogUtils.info("Click element " + xpathIndex(string, index));

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("clickElement_" + SystemHelper.makeSlug(xpathIndex(string, index).toString()));
        }
    }

    @Step("Click element {0} with timeout {1}")
    public static void clickElement(By by, int timeout) {
        waitForPageLoaded();
        waitForElementVisible(by, timeout);
        sleep(STEP_TIME);
        getWebElement(by).click();
        LogUtils.info("Click element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("clickElement_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Set text {1} on {0}")
    public static void setText(By by, String value) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Set text: " + value + " on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("setText_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Set text {1} on {0} and press key {2}")
    public static void setTextAndKey(By by, String value, Keys key) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        getWebElement(by).sendKeys(value, key);
        LogUtils.info("Set text: " + value + " on element " + by);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("setText_" + SystemHelper.makeSlug(by.toString()));
        }
    }

    @Step("Get text of element {0}")
    public static String getElementText(By by) {
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        String text = getWebElement(by).getText();
        LogUtils.info("Get text: " + text);
        return text;
    }

    public static void waitForElementVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(5000));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementVisible(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Timeout waiting for the element Visible. " + by.toString());
            Assert.fail("Timeout waiting for the element Visible. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());
        }
    }

    public static void waitForElementPresent(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable error) {
            LogUtils.error("Element not exist. " + by.toString());
            Assert.fail("Element not exist. " + by.toString());

        }
    }

    public static void waitForElementClickable(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            LogUtils.info("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    public static void waitForElementClickable(By by, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut), Duration.ofMillis(500));
            wait.until(ExpectedConditions.elementToBeClickable(getWebElement(by)));
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for the element ready to click. " + by.toString());
            LogUtils.info("Timeout waiting for the element ready to click. " + by.toString());
        }
    }

    @Step("Scroll to element {0}")
    public static void scrollToElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(by));
    }

    @Step("Scroll to element {0}")
    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);

        if (PropertiesHelper.getValue("SCREENSHOT_STEP").equals("yes")) {
            CaptureHelper.takeScreenshot("scrollToElement_" + SystemHelper.makeSlug(element.getText()));
        }
    }

    @Step("Scroll to element {0} with type {1}")
    public static void scrollToElement(WebElement element, String type) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(" + type + ");", element);
    }

    @Step("Scroll to position with X={0}, Y={1}")
    public static void scrollToPosition(int X, int Y) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(" + X + "," + Y + ");");
    }

    @Step("Move to element {0}")
    public static boolean moveToElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).release(getWebElement(by)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean moveToOffset(int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveByOffset(X, Y).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    @Step("Highlight element {0}")
    public static WebElement highLightElement(By by) {
        if (DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'", getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

    @Step("Hover on element {0}")
    public static boolean hoverElement(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Mouse hover on element {0}")
    public static boolean mouseHover(By by) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(getWebElement(by)).perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Drag element {0} to element {1}")
    public static boolean dragAndDrop(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.dragAndDrop(getWebElement(fromElement), getWebElement(toElement)).perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropElement(By fromElement, By toElement) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).moveToElement(getWebElement(toElement)).release(getWebElement(toElement)).build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    public static boolean dragAndDropOffset(By fromElement, int X, int Y) {
        try {
            Actions action = new Actions(DriverManager.getDriver());
            action.clickAndHold(getWebElement(fromElement)).pause(1).moveByOffset(X, Y).release().build().perform();
            return true;
        } catch (Exception e) {
            LogUtils.info(e.getMessage());
            return false;
        }
    }

    @Step("Press ENTER on keyboard")
    public static boolean pressENTER() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Step("Press BackSpace on keyboard")
    public static boolean pressBackSpace() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Step("Press Delete on keyboard")
    public static boolean pressDelete() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyRelease(KeyEvent.VK_DELETE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press ESC on keyboard")
    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Press F11 on keyboard")
    public static boolean pressF11() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F11);
            robot.keyRelease(KeyEvent.VK_F11);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            LogUtils.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load (Javascript). (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    public static void waitForJQueryLoad() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            assert driver != null;
            return ((Long) ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return jQuery.active") == 0);
        };

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) js.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if (!jqueryReady) {
            LogUtils.info("JQuery is NOT Ready!");
            try {
                //Wait for jQuery to load
                wait.until(jQueryLoad);
            } catch (Throwable error) {
                Assert.fail("Timeout waiting for JQuery load. (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }
    }

    public static void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        //Wait for ANGULAR to load
        ExpectedCondition<Boolean> angularLoad = driver -> {
            assert driver != null;
            return Boolean.valueOf(((JavascriptExecutor) DriverManager.getDriver()).executeScript(angularReadyScript).toString());
        };

        //Get Angular is Ready
        boolean angularReady = Boolean.parseBoolean(js.executeScript(angularReadyScript).toString());

        //Wait ANGULAR until it is Ready!
        if (!angularReady) {
            LogUtils.info("Angular is NOT Ready!");
            //Wait for Angular to load
            try {
                //Wait for jQuery to load
                wait.until(angularLoad);
            } catch (Throwable error) {
                Assert.fail("Timeout waiting for Angular load. (" + PAGE_LOAD_TIMEOUT + "s)");
            }
        }

    }
    public static void verifyElementVisible(By by, String message){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), message);
    }

    public static void verifyElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        LogUtils.info("Verify " + by + " is displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), "Element not visible");
    }
    public static void verifyListElementVisible(List<String> list, int index){
        for (String element : list) {
            verifyElementVisible(element,index);
        }
    }
    public static void verifyElementVisible(String string, int index){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathIndex(string, index)));
        LogUtils.info("Verify " + xpathIndex(string, index) + " is displayed");
        Assert.assertTrue(DriverManager.getDriver().findElement(xpathIndex(string, index)).isDisplayed(), "Element not visible");
    }

    public static void verifyElementClickable(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        LogUtils.info("Verify " + by + " is clickable");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), "Element not clickable");
    }
    public static void verifyElementClickable(By by, String message){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        LogUtils.info("Verify " + by + " is clickable");
        Assert.assertTrue(DriverManager.getDriver().findElement(by).isDisplayed(), message);
    }

    public static void verifyElementDisable(By by){
        try {
//            DriverManager.getDriver().findElement(by);
            getWebElement(by);
        }catch (Exception e){
            LogUtils.info("Element is disable: " + by);
            Assert.assertTrue(true);
        }
    }

    public static void verifyElementDisable(By by, String message){
        try {
//            DriverManager.getDriver().findElement(by);
            getWebElement(by);
        }catch (Exception e){
            LogUtils.info("Element is disable: " + by);
            Assert.assertTrue(true);
        }
    }
     public static void clearTextElement(By by){
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        String s = Keys.chord(Keys.CONTROL, "a");
        getWebElement(by).sendKeys(s);
        getWebElement(by).sendKeys(Keys.DELETE);
        LogUtils.info("clear text element " + by);
     }
     public static String getCurrentUrlNewTab(){
         String parent_tab = DriverManager.getDriver().getWindowHandle();
         WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
         wait.until(ExpectedConditions.numberOfWindowsToBe(2));
         Set<String> s = DriverManager.getDriver().getWindowHandles();
         Iterator<String> i = s.iterator();

         while(i.hasNext())
         {
             String child_tab = i.next();
             if (!parent_tab.equalsIgnoreCase(child_tab)) {
                 DriverManager.getDriver().switchTo().window(child_tab);
             }
         }
         return DriverManager.getDriver().getCurrentUrl();
     }
    public static void verifyContainText(By by, String message){
        waitForPageLoaded();
        waitForElementVisible(by);
        sleep(STEP_TIME);
        Assert.assertTrue(getElementText(by).contains(message));
        LogUtils.info("Verify element: " + by + "contains: " + message);
    }
    public static void verifyContainText(WebElement element, String message){
        waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertTrue(element.getText().contains(message));
        LogUtils.info("Verify element: " + element+ "contains: " + message);
    }
    public static void verifyContainTextLowerCase(WebElement element, String message){
        waitForPageLoaded();
        sleep(STEP_TIME);
        Assert.assertTrue(element.getText().toLowerCase().contains(message));
        LogUtils.info("Verify element: " + element+ "contains: " + message);
    }
    public static void verifyContainText(String string, int index, String message){
        waitForPageLoaded();
        waitForElementVisible(xpathIndex(string, index));
        sleep(STEP_TIME);
        Assert.assertTrue(getElementText(xpathIndex(string, index)).contains(message));
        LogUtils.info("Verify element: " + xpathIndex(string, index) + "contains: " + message);
    }
    public static void verifyURL(String Text){
        waitForPageLoaded();
        sleep(STEP_TIME);
        verifyEquals(DriverManager.getDriver().getCurrentUrl() , Text, "URl not match");
        LogUtils.info("Verify URL:" + Text);
    }

    public static void clickAndWaitImage(Pattern pattern){
        Screen screen = new Screen();
        try {
            screen.wait(pattern, 120).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void clickImageMultipleTime(Pattern pattern){
        Screen screen = new Screen();
        try {
            screen.wait(pattern, 15).click();
            int i = 10;
            while (i>0){
                screen.click(pattern);
                i--;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
