package helper.wait;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class waitHelper {
    private WebDriver driver;
    //Below line will help to log some comments in this class
    private Logger log = LoggerHelper.getLogger(waitHelper.class);

    public waitHelper(WebDriver driver)
    {
        this.driver=driver;
    }

    public void setImplicitWait(long timeout, TimeUnit unit)
    {
        log.info("implicit wait has been set for : " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }

    public void setPageLoadtimeout(long timeout, TimeUnit unit)
    {
        log.info("Trying to set page load timeout");
        driver.manage().timeouts().pageLoadTimeout(timeout, unit);
    }

    //This is very imp because you cannot write this much code every time in any method
    public WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMilliSec)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        //wait.pollingEvery(Duration.ofMillis(1000));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    public void waitForElementToBeVisible(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
    {
        log.info("Waiting for element to be visible for : "+ timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Element is visible now");
    }

    public void waitForElementToBeClickable(WebElement element, int timeOutInSeconds, int pollingEveryInMilliSec)
    {
        log.info("Waiting for element to be clickable for : "+ timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMilliSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("Element is clickable now");
    }

    public void waitForNoElementVisible(WebElement element, int timeoutInSec, int pollingEveryInMilliSec)
    {
        log.info("Waiting for element to disappear from screen");
        WebDriverWait wait = getWait(timeoutInSec, pollingEveryInMilliSec);
        wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("Element is not present or element has disappeared");
    }

    public void waitForAlert(int timeoutInSec, int pollingEveryInMilliSec)
    {
        log.info("Waiting for alert");
        WebDriverWait wait = getWait(timeoutInSec, pollingEveryInMilliSec);
        wait.until(ExpectedConditions.alertIsPresent());
        log.info("alert is present");
    }

    public void waitForFrameAndSwitch(WebElement element, int timeoutInSec, int pollingEveryInMilliSec)
    {
        log.info("Waiting for frame and switch to it");
        WebDriverWait wait = getWait(timeoutInSec, pollingEveryInMilliSec);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        log.info("Switched to frame");
    }
}
