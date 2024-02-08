package testing.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.UploadPage;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UploadAndDownloadTest extends BaseClass {
    @Test
    public void uploadTest() {
        try {

            WebDriver driver = getDriver();
            UploadPage uploadPage = new UploadPage(driver);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            uploadPage.uploadFile();

            uploadPage.clickOnTermsAndCondition();

            uploadPage.clickOnSubmitButton();
        } finally {
            tearDown();
        }
    }

    @Test
    public void downloadTest() {
        try {
            WebDriver driver = getDriver();
            String downlaodDir = "C:\\Users\\ssb\\Downloads";
            driver.get("https://the-internet.herokuapp.com/download");
            String fileName = "download.jpg";
            //Thread.sleep(3000);
            WebElement downlaodLink = driver.findElement(By.linkText(fileName));
            downlaodLink.click();

            String filePath = downlaodDir + File.separator + fileName;
            File downloadFile = new File(filePath);

            //assertTrue(downloadFile.exists(), "File Download Successfully");
        } finally {
            tearDown();
        }
    }

    @Test
    public void iFrameClickTest() {
        try {

            WebDriver driver = getDriver();
            driver.get("https://demo.automationtesting.in/Frames.html");
            driver.switchTo().frame(0);
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'text']")));
            driver.findElement(By.cssSelector("input[type = 'text']")).sendKeys("abcdef");
        } finally {
            tearDown();
        }
    }


    @Test
    public void NestedIframeTest() {
        WebDriver driver = getDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");

        driver.findElement(By.linkText("Iframe with in an Iframe")).click();

        //Switch to the inner iframe
        driver.switchTo().frame(1);
        // Switch to the inner iframe
        driver.switchTo().frame(0);

        WebElement element = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
        element.sendKeys("fdsfd");

        driver.switchTo().defaultContent();
        tearDown();
    }
}
