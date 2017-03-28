package nl.newnexus.steps;

import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by buiten.r on 24-11-2015.
 */

public class Steps
{

    protected static WebDriver driver;

    public Steps()
    {

    }

    public void teardownTest(Scenario scenario)
    {
        destroyDriver(scenario);
    }

    protected void initDriver()
    {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        if (driver == null  ) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
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
