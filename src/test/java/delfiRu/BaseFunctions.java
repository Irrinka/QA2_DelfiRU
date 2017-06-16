package delfiRu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * This class helps to work with basic selenium functions
 */
public class BaseFunctions {

    WebDriver driver;
    private static final String FIRE_FOX_DRIVER_LOCATION = "C:/Users/Irrinka/geckodriver.exe";
    private static final Logger LOGGER = Logger.getLogger(BaseFunctions.class);

    public BaseFunctions() {

        LOGGER.info("Setting FireFox driver location: " + FIRE_FOX_DRIVER_LOCATION);
        System.setProperty("webdriver.gecko.driver", FIRE_FOX_DRIVER_LOCATION);

        LOGGER.info("Opening FireFox browser");
        this.driver = new FirefoxDriver();

        LOGGER.info("Maximize browser window size");
        driver.manage().window().maximize();
    }


    public WebElement getElement(By element) {
        return driver.findElement(element);
    }

    /*Boolean isElementPresents(By locator) {
        boolean waitFor = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return driver.findElement(locator).isDisplayed();
            }
        });
        return waitFor;
    }*/

    public void waitForElement(By element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, mills);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    /*public void waitForElement(By element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, mills);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }*/

    public List<WebElement> getAllElements(By locator) {
        return driver.findElements(locator);
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        //LOGGER.info("User goes to: " + url);
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();
    }


}
