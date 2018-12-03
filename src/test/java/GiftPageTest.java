import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.testng.Assert.*;

public class GiftPageTest extends Page {
    private GiftPage giftPage;

    @Before
    public void setUp() {
        super.setUp();
        driver.get("https://www.scentbird.com/gift");
        giftPage = new GiftPage(driver);
    }

    /**
     * Offers should appeared after clicking "Buy the gift for him/her" button.
     * */
    @Test
    public void checkOffersAppeared() {
        giftPage.clickBuyForHim();
        assertTrue(giftPage.isOffersModalAppered());
        giftPage.closeModal();
        assertFalse(giftPage.isOffersModalAppered());
        giftPage.clickBuyForHer();
        assertTrue(giftPage.isOffersModalAppered());
    }

    /**
     * Recipient info modal window should appeared after choosing subscription size (3,6,12 month) in the Offers modal window.
     * */
    @Test
    public void checkRecipientInfoModalAppeared() {
        for (int i = 0; i < 2; i++) {
            giftPage.clickBuyForHim();
            assertTrue(giftPage.isOffersModalAppered());
            giftPage.clickOrderGiftBtn(i);
            assertTrue(giftPage.isRecipientInfoModalAppeared());
            giftPage.closeModal();
            assertFalse(giftPage.isRecipientInfoModalAppeared());
        }
    }

    @Test
    public void emptyRecipientInfoForm() {
        giftPage.getRecipientInfoModal();
        giftPage.fillRecipientInfo(null, null, null);
        giftPage.clickGiftPersonNextBtn();
        String nameFiledErrorMsg = giftPage.getNameFieldErrorMsg();
        String emailFiledErrorMsg = giftPage.getEmailFieldErrorMsg();
        String msgFiledErrorMsg = giftPage.getMessageFieldErrorMsg();
        assertEquals(nameFiledErrorMsg, "Required");
        assertEquals(emailFiledErrorMsg, "Required");
        assertEquals(msgFiledErrorMsg, "Required");
    }

    @Test
    public void enterInvalidRecipientEmail() {
        giftPage.getRecipientInfoModal();
        giftPage.fillRecipientInfo("name", "qwe", "some message");
        giftPage.clickGiftPersonNextBtn();
        String emailFiledErrorMsg = giftPage.getEmailFieldErrorMsg();
        assertEquals(emailFiledErrorMsg, "Valid email address required");
    }

    /**
     * TODO: Need login first.
     * After clicking on cartCounter should appear block whith its contents
     */
    @Test @Ignore
    public void checkCartCounterContentAppear() {
        giftPage.clickCartCounter();
        assertTrue(giftPage.iscartCounterContentAppeared());
    }

    @Test
    public void enterInvalidSubscriberEmail() {
        giftPage.enterSubscriberEmail("invalidEmail");
        giftPage.submitSubscriberEmail();
        assertEquals(giftPage.getSubscriberEmailInputErrorText(),"Valid email address required");
    }

    @Test
    public void enterValidSubscriberEmail() {
        giftPage.enterSubscriberEmail("umacte@gmail.com");
        giftPage.submitSubscriberEmail();
        assertEquals(giftPage.getSubscriberEmailAfterText(),"Thanks for subscribing to our newsletter!");
    }
}
