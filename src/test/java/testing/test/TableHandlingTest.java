package testing.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.TableHandlingPage;

@Test
public class TableHandlingTest extends BaseClass {

    @Test
    public void tableHandling(){
        WebDriver driver = getDriver();
        TableHandlingPage tableHandlingPage = new TableHandlingPage(driver);

        tableHandlingPage.getNumberOfColumn();
        tableHandlingPage.getNumberOfRows();
        tableHandlingPage.clickOnTableElement();
        tearDown();
    }
}
