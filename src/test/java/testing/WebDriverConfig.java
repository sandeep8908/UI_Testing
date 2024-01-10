package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class WebDriverConfig {
    public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.out.println("Before Suit Running...");
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ssb\\Downloads\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("After suit completed..");
        if (driver != null) {
           /* driver.close();
            driver.quit();*/
        }
    }
}
