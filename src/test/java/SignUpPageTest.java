import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver-linux");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver-linux");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPass() {
        SignUpPage sp = signUpPage.typePassword("qwe");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and needs at least one number", error);
    }

    @Test
    public void signUpReservedUsernameTest() {
        SignUpPage sp = signUpPage.typeUsername("username");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username name 'username' is a reserved word", error);
    }

    @Test
    public void signUpTakenUsernameTest() {
        SignUpPage sp = signUpPage.typeUsername("user");
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Username is already taken", error);
    }

    @Test
    public void getHeadingTest() {
        SignUpPage sp = signUpPage;
        String heading = sp.getHeaderText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @Test
    public void registerWithInvalidCreds() {
        SignUpPage sp = signUpPage.registerWithSomeCreds("userqweqwe", "umacte@gmail.cam", "qweqwe");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
