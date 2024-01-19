package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.out.println("Before Suit Running...");

        String runMode = System.getProperty("env");

        if (runMode != null && runMode.equalsIgnoreCase("remote")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "103.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "11");
            caps.setCapability("project", "BrowserStack Sample");
            caps.setCapability("build", "browserstack-build-1");

            caps.setCapability("browserstack.user", "sandeepbirla_6W5isF");
            caps.setCapability("browserstack.key", "fGQN8biMZzdaCzgc34xg");

            // Initialize the driver with BrowserStack capabilities
            driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        } else {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After suit completed..");
        if (driver != null) {
           // driver.close();
            driver.quit();
        }
    }
}
