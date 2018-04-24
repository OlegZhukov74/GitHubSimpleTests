import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//*[@id=\"login_field\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By submitBtn = By.xpath("//input[@type=\"submit\"]");
    private By heading = By.xpath("//div[contains(@class, \"auth-form-header\")]/h1");
    private By errorMsg = By.xpath("//*[@id=\"js-flash-container\"]//div[@class=\"container\"]");
    private By createAccLink = By.xpath("//*[@id=\"login\"]//*[contains(@class, \"create-account-callout\")]//a");

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithSomeCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(submitBtn).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorMsg).getText();
    }

    public SignUpPage createAccountLinkClick() {
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}
