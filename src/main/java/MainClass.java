import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.print.PageFormat;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1000, 800));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com");

        MainPage mainPage = new MainPage(driver);
        mainPage.register("username", "qweqwe@qewqwe.qwe", "pass");



    }







}
