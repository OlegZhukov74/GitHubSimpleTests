import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.*;


public class GiftPage {
    private WebDriver driver;

    public GiftPage(WebDriver driver) {
        this.driver = driver;
    }

    private By buyForHim = By.id("buyForHim");
    private By buyForHer = By.id("buyForHer");
    private By offers = By.xpath("//*[@data-testid='offers']");

    private By orderGiftSize0Btn = By.id("giftSize0Button");
    private By orderGiftSize1Btn = By.id("giftSize1Button");
    private By orderGiftSize2Btn = By.id("giftSize2Button");
    private By modalCloseIcon = By.xpath("//*[@data-testid='modalCloseIcon']");

    private By recipientInfoModal = By.xpath("//*[@data-testid='setGiftRecipientInfoModal']");
    private By recipientName = By.id("giftModalRecipientName");
    private By nameFieldErrorMsg = By.xpath("//*[@id='giftModalRecipientName']/parent::div//following-sibling::div");
    private By recipientEmail = By.id("giftModalRecipientEmail");
    private By emailFieldErrorMsg = By.xpath("//*[@id='giftModalRecipientEmail']/parent::div//following-sibling::div");
    private By recipientMessage = By.id("giftModalPersonalMessage");
    private By messageFieldErrorMsg = By.xpath("//*[@id='giftModalPersonalMessage']/parent::div//following-sibling::div");
    private By giftPersonNextBtn = By.id("giftPersonNextButton");
    private By giftPersonBackBtn = By.xpath("//*[@data-testid='modalGoBackButton']");

    public void clickBuyForHim() {
        driver.findElement(buyForHim).click();
    }

    public void clickBuyForHer() {
        driver.findElement(buyForHer).click();
    }

    public boolean isOffersModalAppered() {
        try {
            driver.findElement(offers);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * @param size size of gift. Could be 0,1,2 (equals 3,6,12-month gift).
     */
    public void clickOrderGiftBtn(int size) {
        switch (size) {
            case 0:
                driver.findElement(orderGiftSize0Btn).click();
                break;
            case 1:
                driver.findElement(orderGiftSize1Btn).click();
                break;
            case 2:
                driver.findElement(orderGiftSize2Btn).click();
                break;
        }
    }

    public boolean isRecipientInfoModalAppeared() {
        try {
            driver.findElement(recipientInfoModal);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeModal() {
        driver.findElement(modalCloseIcon).click();
    }


    public void getRecipientInfoModal() {
        driver.findElement(buyForHim).click();
        assertTrue(isOffersModalAppered());
        driver.findElement(orderGiftSize0Btn).click();
        assertTrue(isRecipientInfoModalAppeared());
    }

    public void fillRecipientInfo(String name, String email, String msg) {
        if (name != null) {
            driver.findElement(recipientName).sendKeys(name);
        }
        if (email != null) {
            driver.findElement(recipientEmail).sendKeys(email);
        }
        if (msg != null) {
            driver.findElement(recipientMessage).sendKeys(msg);
        }
    }

    public void clickGiftPersonNextBtn() {
        driver.findElement(giftPersonNextBtn).click();
    }

    public String getNameFieldErrorMsg() {
        return driver.findElement(nameFieldErrorMsg).getText();
    }

    public String getEmailFieldErrorMsg() {
        return driver.findElement(emailFieldErrorMsg).getText();
    }

    public String getMessageFieldErrorMsg() {
        return driver.findElement(nameFieldErrorMsg).getText();
    }
}


