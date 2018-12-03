import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver-linux");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
