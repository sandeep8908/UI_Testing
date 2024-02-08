package testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class DialogBoxPage {
    private static String PAGE_URL = "https://www.demoblaze.com";

    private WebDriver driver;

    @FindBy(linkText = "Cart")
    private WebElement cart;
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    private WebElement placeOrder;
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "card")
    private WebElement creditCard;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;
    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    private WebElement purchaseButton;

    public DialogBoxPage(WebDriver driver){
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver,this);
    }

    public void clickOnCartTab(){
        cart.click();
    }

    public void clickOnPlaceOrderTab(){
        placeOrder.click();
    }

    public void fillOrderDetails(){
        name.sendKeys("Sandeep Birla");
        assertEquals(name.getAttribute("value"),"Sandeep Birla");
        country.sendKeys("INDIA");
        assertEquals(country.getAttribute("value"),"INDIA");
        city.sendKeys("Indore");
        assertEquals(city.getAttribute("value"),"Indore");
        creditCard.sendKeys("783219812564");
        assertEquals(creditCard.getAttribute("value"),"783219812564");
        month.sendKeys("03");
        assertEquals(month.getAttribute("value"),"03");
        year.sendKeys("2026");
        assertEquals(year.getAttribute("value"),"2026");
    }

    public void clickOnPurchaseButton(){
        purchaseButton.click();
    }
}   
