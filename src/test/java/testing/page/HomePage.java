package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static String PAGE_URL = "https://github.com/";

    private WebDriver driver;

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(className = "Truncate-text")
    private WebElement loggedInUser;

    public HomePage (WebDriver driver){
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver,this);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public String getLoggedInUserName(){
        return loggedInUser.getText();
    }
}
