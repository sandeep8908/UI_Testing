package testing.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testing.BaseClass;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import static org.testng.Assert.*;


public class UiTest extends BaseClass {
    private String baseUrl = "https://www.facebook.com/";

    @Test
    void testLoginPage() {
        driver.get(baseUrl);
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("rythum30@gmail.com");

        assertEquals(email.getAttribute("value"), "rythum30@gmail.com", "Email field value is not as expected");
        WebElement pass = driver.findElement(By.cssSelector("input[name = 'pass']"));
        pass.sendKeys("Rythum30@");

        assertEquals(pass.getAttribute("value"), "Rythum30@", "Password field value is not as expected");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        System.out.println("Login done !");
    }

    @Test
    void signUpTest() throws InterruptedException {
        driver.get(baseUrl);
        WebElement createAccount = driver.findElement(By.partialLinkText("Create new account"));
        createAccount.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Domain");

        assertEquals(firstname.getAttribute("value"), "Domain", "First name field value is not as expected");
        WebElement lastname = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastname.sendKeys("service");

        assertEquals(lastname.getAttribute("value"), "service", "Last Name field value is not as expected");
        WebElement email = driver.findElement(By.cssSelector("input[name = 'reg_email__']"));
        email.sendKeys("sandeep.birla@liseinfotech.com");

        assertTrue(email.isDisplayed(), "Email field is not displayed");
        assertEquals(email.getAttribute("value"), "sandeep.birla@liseinfotech.com");
        boolean displayed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();

        if (displayed) {
            WebElement regEmailConfirmation = driver.findElement(By.name("reg_email_confirmation__"));
            regEmailConfirmation.sendKeys("sandeep.birla@liseinfotech.com");
            assertEquals(regEmailConfirmation.getAttribute("value"), "sandeep.birla@liseinfotech.com");
        }

        WebElement password = driver.findElement(By.name("reg_passwd__"));
        password.sendKeys("sandeep002@");

        WebElement dayDropDown = driver.findElement(By.id("day"));
        Select selectDayDropDown = new Select(dayDropDown);
        selectDayDropDown.selectByValue("12");

        assertEquals(dayDropDown.getAttribute("value"), "12", "Day field value is not as expected");

        WebElement monthDropDown = driver.findElement(By.id("month"));
        Select selectMonthDropDown = new Select(monthDropDown);
        selectMonthDropDown.selectByValue("4");

        assertEquals(monthDropDown.getAttribute("value"), "4", "Month field value is not as expected");

        WebElement yearDropDown = driver.findElement(By.id("year"));
        Select selectYearDropDown = new Select(yearDropDown);
        selectYearDropDown.selectByValue("2007");

        assertEquals(yearDropDown.getAttribute("value"), "2007", "Year field value is not as expected");

        WebElement radioGender
                = driver.findElement(By.cssSelector("input[value='-1']"));
        radioGender.click();

        if (radioGender.getAccessibleName().equals("Custom")) {
            WebElement optionSelected = driver.findElement(By.name("preferred_pronoun"));
            Select selectOption = new Select(optionSelected);
            selectOption.selectByValue("2");

            WebElement customGender = driver.findElement(By.name("custom_gender"));
            customGender.sendKeys("Male");
        }

        WebElement websubmit = driver.findElement(By.name("websubmit"));
        websubmit.click();
    }

    @Test
    void amazonSignUpPageTest() {
        driver.navigate().to("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%" +
                "2Fs%3Fk%3Damaozn%2Bpay%26adgrpid%3D84811993817%26ext_vrnc%3Dhi%26gclid%3DCj0KCQiAnfmsBhDfARIsAM7MKi1KMSYKMCMu10BxvFtJEssopaKiphkDvV_" +
                "CPiBPYu5m9DLUe14ihLMaAl3pEALw_wcB%26hvadid%3D590431616040%26hvdev%3Dc%26hvlocphy%3D1007796%26hvnetw%3Dg%26hvqmt%3Db" +
                "%26hvrand%3D6567990490383795653%26hvtargid%3Dkwd-915707733732%26hydadcr%3D12495_2334764%26tag%3Dgooginhydr1-21%26ref%3Dnav_" +
                "custrec_signin&prevRID=NN24AR59Z5ZPJSB5SSXC&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&o" +
                "penid.assoc_handle=inflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.op" +
                "enid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        WebElement customerName = driver.findElement(By.name("customerName"));
        customerName.sendKeys("Ankit Birla");
        assertEquals(customerName.getAttribute("value"), "Ankit Birla");

        WebElement countryCodeDropDown = driver.findElement(By.id("auth-country-picker"));
        Select countryCodeSelect = new Select(countryCodeDropDown);
        countryCodeSelect.selectByValue("IN");

        assertEquals(countryCodeDropDown.getAttribute("value"), "IN");
        WebElement apPhoneNumber = driver.findElement(By.id("ap_phone_number"));
        apPhoneNumber.sendKeys("6264622129");

        assertEquals(apPhoneNumber.getAttribute("value"), "6264622129");

        WebElement email = driver.findElement(By.cssSelector("input[id = 'ap_email']"));
        email.sendKeys("sandeep.birla@liseinfotech.com");

        assertEquals(email.getAttribute("value"), "sandeep.birla@liseinfotech.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("sandeep8989@9");

        assertEquals(password.getAttribute("value"), "sandeep8989@9");

        WebElement continueButton = driver.findElement(By.cssSelector("input[type = 'submit']"));
        continueButton.submit();
    }

    @Test
    void testHandlingTabs() throws AWTException {
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        driver.navigate().to("http://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://testsigma.com/");

        /*Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);*/
    }

    @Test
    void testHandlingMultipleTabs() throws AWTException, InterruptedException {
        driver.get("https://www.javatpoint.com/selenium-tutorial");
        driver.manage().window().maximize();
        String currentWindowHandle = driver.getWindowHandle();

        WebElement loginTest = driver.findElement(By.linkText("IDE-Login Test"));
        loginTest.click();

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        Thread.sleep(2000);

        Set<String> driverWindowHandles = driver.getWindowHandles();

        for (String actual : driverWindowHandles) {
            if (!actual.equalsIgnoreCase(currentWindowHandle)) {
                driver.switchTo().window(actual);

                driver.get("https://www.google.com/");

                driver.switchTo().window(currentWindowHandle);
            }
        }
    }

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
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));
        //WebElement element = driver.findElement(By.id("APjFqb"));

        element.sendKeys("Java Interview questions");
        element.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("dURPMd")));
        List<WebElement> list = driver.findElements(By.className("dURPMd"));
        System.out.println(list.size());
    }
}
