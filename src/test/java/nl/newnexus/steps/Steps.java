package nl.newnexus.steps;

import cucumber.api.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by buiten.r on 24-11-2015.
 */

public class Steps
{

    protected static WebDriver driver;
    private static String browserType = "chhrome";

    public Steps()
    {

    }

    public void teardownTest(Scenario scenario)
    {
        destroyDriver(scenario);
    }


    protected void initDriver()
    {
        if (browserType.equalsIgnoreCase("chrome")) {

            if (driver == null  ) {
                System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts()     .implicitlyWait(5, TimeUnit.SECONDS)
                        .pageLoadTimeout(30, TimeUnit.SECONDS)
                        .setScriptTimeout(30, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
            }

        } else if (browserType.equalsIgnoreCase("ie")) {

            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("requireWindowFocus", true);

            if (driver == null)
            {
                System.setProperty("webdriver.ie.driver", "drivers//iedriverserver.exe");
                driver = new InternetExplorerDriver(capabilities);

            }


        } else if (browserType.equalsIgnoreCase("firefox")) {


        } else if (browserType.equalsIgnoreCase("safari")) {
            if (driver == null) {
                driver = new SafariDriver();
                driver.manage()
                        .timeouts()
                        .implicitlyWait(5, TimeUnit.SECONDS)
                        .pageLoadTimeout(30, TimeUnit.SECONDS)
                        .setScriptTimeout(30, TimeUnit.SECONDS);
                driver.manage().deleteAllCookies();
            }
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    protected void destroyDriver(Scenario scenario)
    {
        if (driver != null) {

            try {
                if (scenario.isFailed()) {
                    final byte[] screenshot = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                }
            } finally {
                driver.quit();
            }
        }

        driver = null;
    }
}
