package nl.newnexus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tester on 3/28/2017.
 */
public class MainPage {

    private WebDriver driver;

    @FindBy(id="bodyContent")
    private WebElement content;

    @FindBy(linkText = "create an account")
    private WebElement createAccount;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void GoToCreateAnAccount() {
        this.createAccount.click();
    }

    public Boolean wordtPaginaGetoond() {

        String text = content.getText().toLowerCase();

        if (text.contains("welcome to newnexus"))
            return true;
        else
            return false;
    }
}
