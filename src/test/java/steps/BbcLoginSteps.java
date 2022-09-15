package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BbcLoginPage;
import utils.CommonSteps;
import utils.Driver;

public class BbcLoginSteps extends CommonSteps {
    BbcLoginPage bbcLoginPage=new BbcLoginPage();
    @Given("user navigates to BBC website")
    public void userNavigatesToBBCWebsite() {

        Driver.get().get("https://www.bbc.co.uk/");
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
        waitFor(1);
        bbcLoginPage.passWord.sendKeys("kerim4473");
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
}