package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptExePage {
    public static String PAGE_URL = "https://demo.guru99.com/V4/index.php";

    private WebDriver driver;

    @FindBy(name = "btnLogin")
    public WebElement button;
    @FindBy(name = "uid")
    public WebElement userId;
    @FindBy(name = "password")
    public WebElement password;

    public JavaScriptExePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver, this);
    }

    public void setUsernameAndPassword(){
        userId.sendKeys("mngr552539");
        password.sendKeys("utydEzA");
    }
}
