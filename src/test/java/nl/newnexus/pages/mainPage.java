package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tester on 3/28/2017.
 */
public class mainPage {

    private WebDriver driver;

    @FindBy(id="bodyContent")
    private WebElement content;

    public mainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean wordtPaginaGetoond() {

        String text = content.getText()

        if (content.getText().toLowerCase().contains("welcome to new nexus"))
            return true;
        else
            return false;
    }
}
