package helper.window;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class windowHelper {

    private WebDriver driver;
    private Logger log = LoggerHelper.getLogger(windowHelper.class);

    public windowHelper(WebDriver driver)
    {
        this.driver = driver;
    }

}
