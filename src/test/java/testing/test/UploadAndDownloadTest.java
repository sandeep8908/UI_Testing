package testing.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import testing.BaseClass;
import testing.page.UploadPage;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class UploadAndDownloadTest extends BaseClass {
    @Test
    public void uploadTest() {
        WebDriver driver = getDriver();
        UploadPage uploadPage = new UploadPage(driver);

        uploadPage.uploadFile();

        uploadPage.clickOnTermsAndCondition();

        uploadPage.clickOnSubmitButton();

    }

    @Test
    public void downloadTest() throws InterruptedException {
        WebDriver driver = getDriver();
        String downlaodDir = "C:\\Users\\ssb\\Downloads";
        driver.get("https://the-internet.herokuapp.com/download");
        String fileName = "IMG_8955.JPG";
        WebElement downlaodLink = driver.findElement(By.linkText(fileName));
        downlaodLink.click();

        Thread.sleep(5000);

        String filePath = downlaodDir + File.separator + fileName;
        File downloadFile = new File(filePath);

        //assertTrue(downloadFile.exists(), "File Download Successfully");
    }

    @Test
    public void iFrameClickTest() {
        WebDriver driver = getDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame(0);

        driver.findElement(By.cssSelector("input[type = 'text']")).sendKeys("abcdef");
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
    }
}
