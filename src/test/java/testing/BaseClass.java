package testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method Running...");

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
            try {
                driverThreadLocal.set(new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driverThreadLocal.set(new ChromeDriver());
            driverThreadLocal.get().manage().window().maximize();
            driverThreadLocal.get().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method completed..");
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }
}
