package nl.newnexus.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import cucumber.api.java.nl.Gegeven;
import nl.newnexus.database.acties.DatabaseActies;
import nl.newnexus.pages.createAccount;
import nl.newnexus.pages.mainPage;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.Random;

/**
 * Created by Tester on 3/28/2017.
 */
public class CursusSteps  extends Steps{

    private String emailadres = "";
    private DatabaseActies dbActies;

    @Before
    public void Start() {

        initDriver();
        dbActies = DatabaseActies.getInstance();

        if(!dbActies.valid) {
            dbActies.init();
        }

    }

    @After
    public void Stop(Scenario scenario) {
        teardownTest(scenario);
    }


    @Als("^ik een accountgegevens invul voor \"([^\"]*)\" \"([^\"]*)\", \"([^\"]*)\" en \"([^\"]*)\" met een standaard adres$")
    public void ikEenAccountgegevensInvulVoorEnMetEenStandaardAdres(String voornaam, String achternaam, String geboortedatum, String emailadres) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createAccount create = new createAccount(this.getDriver());
        Assert.assertEquals("",true,create.wordtPaginaGetoond());

        Random rd = new Random();
        //emailadres = rd.nextInt(1000000)+ emailadres;

        Assert.assertEquals("",true,create.vulAccountInformatieIn(voornaam,achternaam,geboortedatum,emailadres));
        this.emailadres = emailadres;
    }



    @En("^als ik op de knop ‘aanmaken' klik$")
    public void alsIkOpDeKnopAanmakenKlik() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createAccount create = new createAccount(this.getDriver());
        Assert.assertEquals("",true,create.clickOpAanmaken());
    }

    @Dan("^komen mijn gegevens in de database$")
    public void komenMijnGegevensInDeDatabase() throws Throwable {
        Assert.assertTrue(dbActies.accountAanwezig(this.emailadres));
    }

    @En("^kan ik inloggen$")
    public void kanIkInloggen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Gegeven("^het scherm ‘account aanmaken’ zichtbaar is$")
    public void hetSchermAccountAanmakenZichtbaarIs() throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        this.getDriver().get("http://localhost/catalog");
        this.getDriver().manage().window().maximize();

        String title = this.getDriver().getTitle();
        Assert.assertTrue(title.toLowerCase().contains("newnexus movies and more"));

        mainPage main = new mainPage(this.getDriver());
        Assert.assertEquals("Pagina wordt niet opgstart", true, main.wordtPaginaGetoond());
        main.GoToCreateAnAccount();

        createAccount create = new createAccount(this.getDriver());
        Assert.assertEquals("",true,create.wordtPaginaGetoond());

        //Assert.assertEquals("Kan niet op de link klikken", true, main.GoToCreateAnAccount());
    }


    @En("^het password met \"([^\"]*)\"$")
    public void hetPasswordMet(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createAccount create = new createAccount(this.getDriver());
        Assert.assertEquals("", true, create.vulPasswordIn(arg0,arg0));
    }

    @En("^test$")
    public void test() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @En("^controleer foutmelding \"([^\"]*)\"$")
    public void controleerFoutmelding(String foutmelding) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        createAccount create = new createAccount(this.getDriver());
        Assert.assertEquals("",true,create.checkFoutmelding(foutmelding));

    }

    @En("^controleer foutmelding \"([^\"]*)\" bij leeglaten van veld$")
    public void controleerFoutmeldingBijLeeglatenVanVeld(String foutmelding) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Boolean blnResult;
        Alert alertOK = driver.switchTo().alert();
        String text = alertOK.getText();
        if (text.toLowerCase().contains(foutmelding.toLowerCase())) {
            blnResult = true;
        } else {
            blnResult = false;
        }
        Assert.assertEquals("Kan foutmelding niet vinden", true, blnResult);
        System.out.println(text);
        alertOK.accept();
    }
}
