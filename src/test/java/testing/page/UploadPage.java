package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPage {
    private WebDriver driver;

    private static String PAGE_URL = "https://demo.guru99.com/test/upload/";

    @FindBy(id = "uploadfile_0")
    private WebElement uploadFile;

    @FindBy(id = "terms")
    private WebElement termsAndCondition;
    @FindBy(id = "submitbutton")
    private WebElement submitButton;

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver, this);
    }

    public void uploadFile() {
        uploadFile.sendKeys("C:\\Users\\ssb\\Pictures\\Saved Pictures\\bgRadio.png");
    }

    public void clickOnTermsAndCondition() {
        termsAndCondition.click();
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

}
