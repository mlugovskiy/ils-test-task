import configuration.ConfigurationReader;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.DesktopPage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest extends TestBase {

    @Test
    void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage();
        DesktopPage desktopPage = new DesktopPage();
        String validLogin = ConfigurationReader.getLogin();
        String validPassword = ConfigurationReader.getPassword();

        loginPage.open();
        loginPage.enterLogin(validLogin);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();

        assertEquals(ConfigurationReader.getUsername(), desktopPage.getUserName());
        assertEquals("Рабочий стол", desktopPage.getPageMainTitle());
        sleep(10000);
    }
}
