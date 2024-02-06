package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {


    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/h1")
    private WebElement heading;

    @FindBy(id = "login_field")
    private WebElement userEmail;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "input[type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class = 'px-2']")
    private WebElement signInError;


    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    public void setUserPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void signIn(String email, String pass) {
        if (isPageOpened()) {
            setUserEmail(email);
            setUserPassword(pass);
            clickOnSubmit();
        }
    }

    public boolean  isPageOpened() {

        return heading.getText().contains("Sign in to GitHub");
    }

    public void clickOnSubmit() {
        submitButton.click();
    }

    public boolean errorMessageIsVisible() {
        waitForElement(signInError);
        return signInError.isDisplayed();
    }
}
