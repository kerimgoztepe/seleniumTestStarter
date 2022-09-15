package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.math3.stat.interval.ConfidenceInterval;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BbcLoginPage;
import utils.CommonSteps;
import utils.ConfigurationReader;
import utils.Driver;

public class BbcLoginSteps extends CommonSteps {
    //WebDriver driver = Driver.get();
    BbcLoginPage bbcLoginPage=new BbcLoginPage();
    @Given("user navigates to BBC website")
    public void userNavigatesToBBCWebsite() {

        Driver.get().get("https://www.bbc.co.uk/");
        //Driver.get().get(ConfigurationReader.get("url"));

        Driver.get().manage().window().maximize();

        String ActualTitle = Driver.get().getTitle();
        System.out.println(ActualTitle);
        String ExpectedTitle = "BBC - Home";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @When("user enter correct credentials")
    public void userEnterCorrectCredentials() {
        bbcLoginPage.signIn.click();
        bbcLoginPage.userEmail.sendKeys("advancedscientificw@gmail.com");
        //bbcLoginPage.userEmail.sendKeys(ConfigurationReader.get("userName"));
        waitFor(1);
        bbcLoginPage.passWord.sendKeys("kerim4473");
        //bbcLoginPage.passWord.sendKeys(ConfigurationReader.get("passWord"));
        waitFor(1);
        bbcLoginPage.submitButton.click();

    }

    @Then("user should see home page")
    public void userShouldSeeHomePage() {
        String ActualTitle = Driver.get().getTitle();
        String ExpectedTitle = "BBC - Home";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @And("user clicks on news button")
    public void userClicksOnNewsButton() {
        bbcLoginPage.newsButton.click();
        String ActualTitle = Driver.get().getTitle();
        String ExpectedTitle = "Home - BBC News";
        Assert.assertEquals(ExpectedTitle, ActualTitle);
    }

    @Then("user enters with {string} email and {string} password")
    public void userEntersWithEmailAndPassword(String email, String password) {
        bbcLoginPage.signIn.click();
        bbcLoginPage.userEmail.sendKeys(email);
        //bbcLoginPage.userEmail.sendKeys(ConfigurationReader.get("userName"));
        waitFor(1);
        bbcLoginPage.passWord.sendKeys(password);
        //bbcLoginPage.passWord.sendKeys(ConfigurationReader.get("passWord"));
        waitFor(1);
        bbcLoginPage.submitButton.click();

    }
}