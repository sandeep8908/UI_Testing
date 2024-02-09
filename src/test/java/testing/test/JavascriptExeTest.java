package testing.test;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.JavaScriptExePage;

import java.util.concurrent.TimeUnit;

@Slf4j
public class JavascriptExeTest extends BaseClass {

    @Test
    public void loginTestThroughJS() throws InterruptedException {
        WebDriver driver = getDriver();
        JavaScriptExePage javaScriptExePage = new JavaScriptExePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        long startTime = System.currentTimeMillis();
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");

        log.info("Passed Time: " + (System.currentTimeMillis() - startTime));

        String domainName = js.executeScript("return document.domain;").toString();
        log.info("Domain name of website: " + domainName);

        String url = js.executeScript("return document.URL;").toString();
        log.info("Domain name of website: " + url);

        String title = js.executeScript("return document.title;").toString();
        log.info("Domain name of website: " + title);

        javaScriptExePage.setUsernameAndPassword();
        js.executeScript("arguments[0].click();", javaScriptExePage.button);
        Thread.sleep(2000);
        js.executeScript("alert('Welcome to Guru99');");
        tearDown();
    }
}
