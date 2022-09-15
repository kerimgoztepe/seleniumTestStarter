package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BbcLoginPage extends CommonPageElements{

    @FindBy(xpath = "//span[text()='Sign in']")

    public WebElement signIn;

    //@FindBy(name = "email")
    @FindBy(id = "user-identifier-input")
    public WebElement userEmail;

    @FindBy(name = "password")
    public WebElement passWord;

    @FindBy(id = "submit-button")
    public WebElement submitButton;

    @FindBy(xpath = "//span[text()='News'][1]")
    public WebElement newsButton;
}
