package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonPage {
    private static String PAGE_URL = "https://www.lambdatest.com/selenium-playground/radiobutton-demo";

    private WebDriver driver;
    @FindBys({
            @FindBy(className = "container"),
            @FindBy(xpath = "//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div/label[1]/input")
    })
    private WebElement maleRadioBtn;
    @FindBy(css = ".container input[value='Male'][name='optradio']")
    private WebElement maleBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div/div[2]/div/div/div[2]/div[1]/button")
    private WebElement demoBtn;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver, this);
    }

    public void clickOnBookDemoBtn() {
        demoBtn.click();
    }

    public void clickOnRadioBtn() {
        maleRadioBtn.click();
    }
}
