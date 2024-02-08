package testing.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.DialogBoxPage;

@Test
public class DialogBoxTest extends BaseClass {
    @Test
    public void placeOrder(){
        WebDriver driver = getDriver();
        DialogBoxPage dialogBoxPage = new DialogBoxPage(driver);

        dialogBoxPage.clickOnCartTab();
        dialogBoxPage.clickOnPlaceOrderTab();
        dialogBoxPage.fillOrderDetails();
        dialogBoxPage.clickOnPurchaseButton();
        tearDown();
    }
}
