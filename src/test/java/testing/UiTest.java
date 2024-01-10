package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class UiTest extends WebDriverConfig {
    private String baseUrl = "https://www.facebook.com/";

    @Test
    void testLoginPage() {
        driver.get(baseUrl);
        WebElement email = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.cssSelector("input[name = 'pass']"));
        WebElement login = driver.findElement(By.name("login"));
        email.sendKeys("rythum30@gmail.com");
        pass.sendKeys("Rythum30@");
        login.click();
        System.out.println("Login done !");
    }

    @Test
    void signUpTest() throws InterruptedException {
        driver.get(baseUrl);
        WebElement createAccount = driver.findElement(By.partialLinkText("Create new account"));
        createAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(20, TimeUnit.SECONDS.toChronoUnit()));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Domain");
        WebElement lastname = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastname.sendKeys("service");
        WebElement email = driver.findElement(By.cssSelector("input[name = 'reg_email__']"));
        email.sendKeys("sandeep.birla@liseinfotech.com");

        boolean displayed = email.isDisplayed();
        if (displayed) {
            WebElement regEmailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
            regEmailConfirmation.sendKeys("sandeep.birla@liseinfotech.com");
        }

        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("sandeep002@");

        WebElement dayDropDown = driver.findElement(By.id("day"));
        Select selectDayDropDown = new Select(dayDropDown);
        selectDayDropDown.selectByValue("12");

        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select selectMonthDropDown = new Select(monthDropDown);
        selectMonthDropDown.selectByValue("4");

        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select selectYearDropDown = new Select(yearDropDown);
        selectYearDropDown.selectByValue("2007");

        WebElement radioGender
                = driver.findElement(By.cssSelector("input[value='-1']"));
        radioGender.click();

        if ( radioGender.getAccessibleName().equals("Custom")){
            WebElement optionSelected = driver.findElement(By.name("preferred_pronoun"));
            Select selectOption = new Select(optionSelected);
            selectOption.selectByValue("2");
        }

        WebElement websubmit = driver.findElement(By.name("websubmit"));
        websubmit.click();
    }

    /*@FindBy(id = "login")
    WebElement webElement;
    webElement.click();*/

    @Test
    void navigationTest() {
        driver.navigate().to("https://www.javatpoint.com/selenium-webdriver-navigation-commands");
    }

    @Test
    void implicitTestExample() throws InterruptedException {
        driver.get("http://www.google.com");
        //driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.MINUTES);
        //Thread.sleep(30000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(10000, TimeUnit.SECONDS.toChronoUnit()));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
        //WebElement element = driver.findElement(By.id("APjFqb"));

        element.sendKeys("Java Interview questions");
        element.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dURPMd")));
        List<WebElement> list = driver.findElements(By.className("dURPMd"));
        System.out.println(list.size());
    }
}
