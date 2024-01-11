package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Suit Running...");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssb\\Downloads\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After suit completed..");
        if (driver != null) {
            /*driver.close();
            driver.quit();*/
        }
    }
}
