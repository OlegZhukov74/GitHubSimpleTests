import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class=\"setup-header setup-org\"]//h1");
    private By signUpBtn = By.xpath("//*[@id=\"signup_button\"]");
    private By usernameField = By.xpath("//*[@id=\"user_login\"]");
    private By emailField = By.xpath("//*[@id=\"user_email\"]");
    private By passwordField = By.xpath("//*[@id=\"user_password\"]");

    private By mainError = By.xpath("//*[@id=\"signup-form\"]//*[@class=\"flash flash-error my-3\"]");
    private By usernameError = By.xpath("//*[@id=\"user_login\"]/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath("//*[@id=\"user_email\"]/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath("//*[@id=\"user_password\"]/ancestor::dd/following-sibling::dd");

    public SignUpPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage registerWithSomeCreds(String username, String email, String password) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpBtn).click();
        return new SignUpPage(driver);
    }

    public String getHeaderText() {
        return driver.findElement(heading).getText();
    }

    public String getMainErrorText() {
        return driver.findElement(mainError).getText();
    }

    public String getUsernameErrorText() {
        return driver.findElement(usernameError).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(emailError).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }















}
