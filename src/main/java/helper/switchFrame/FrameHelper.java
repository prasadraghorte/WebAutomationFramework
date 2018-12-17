package helper.switchFrame;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(FrameHelper.class);

    public FrameHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * This frame will switch to frame based on index provided
     * @param index
     */
    public void switchToFrame(int index)
    {
        log.debug("Tryng to switch to frame with index : "+index);
        driver.switchTo().frame(index);
        log.info("Switched to frame with index : "+index);
    }

    /**
     * This frame will switch to frame based on frame name provided
     * @param frame
     */
    public void switchToFrame(String frame)
    {
        log.debug("Tryng to switch to frame with name : "+frame);
        driver.switchTo().frame(frame);
        log.info("Switched to frame with name : "+frame);
    }

    public void switchToFrame(WebElement element)
    {
        log.debug("Tryng to switch to frame : "+element);
        driver.switchTo().frame(element);
        log.info("Switched to frame: "+element);
    }
}
