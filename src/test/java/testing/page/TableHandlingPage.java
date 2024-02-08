package testing.page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Slf4j
public class TableHandlingPage {
    private static String PAGE_URL = "https://money.rediff.com/gainers/bsc/daily/groupa";

    private WebDriver driver;
    public static final String elementName = "Bharat Dynamics";

    @FindBy(xpath = "//*[@id=\"leftcontainer\"]/table/thead/tr/th")
    private List<WebElement> columns;
    @FindBy(xpath = "//*[@id=\"leftcontainer\"]/table/tbody/tr")
    public List<WebElement> rows;
    @FindBy(partialLinkText = elementName)
    public WebElement clickOnElement;

    public TableHandlingPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void getNumberOfColumn() {
        int columnCount = columns.size();
        log.info("Number of columns in table: " + columnCount);
    }

    public void getNumberOfRows() {
        int count = 0;
        int rowCount = rows.size();
        for (WebElement e : rows
        ) {
            if (e.getText().contains("Bharat Dynamics")) {
                count++;
            }
        }
        log.info("Number of rows in table: " + rowCount);
        log.info("Bharat Dynamics : " + count);
    }

    public void clickOnTableElement() {
        clickOnElement.click();
    }
}
