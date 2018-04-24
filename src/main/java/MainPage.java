import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Hi git
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@class=\"text-bold text-white no-underline\" and text()=\"Sign in\"]");
    private By signUpButton = By.xpath("//a[@class=\"text-bold text-white no-underline\" and text()=\"Sign up\"]");
    private By usernameInputField = By.xpath("//*[@id=\"user[login]\"]");
    private By emailInputField = By.xpath("//*[@id=\"user[email]\"]");
    private By passwordInputField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpFormButton = By.xpath("//button[text()=\"Sign up for GitHub\"]");

    public LoginPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUsername(String username) {
        driver.findElement(usernameInputField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
        return this;
    }

    public SignUpPage register(String username, String email, String pass) {
        this.typeUsername(username);
        this.typeEmail(email);
        this.typePassword(pass);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }


}


