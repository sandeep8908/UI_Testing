package testing.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.RadioButtonPage;

@Test
public class RadioBtnPage extends BaseClass {

    @Test
    public void clickOnRadioBtn() {
        WebDriver driver = getDriver();
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        radioButtonPage.clickOnRadioBtn();
        radioButtonPage.clickOnBookDemoBtn();
        tearDown();
    }
}
