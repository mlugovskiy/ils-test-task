import configuration.ConfigurationReader;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.DesktopPage;

import static com.codeborne.selenide.Condition.exist;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTests extends TestBase {

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
    }

    @Test
    void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        String validLogin = ConfigurationReader.getLogin();
        String invalidPassword = "qwerty1234";

        loginPage.open();
        loginPage.enterLogin(validLogin);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnSubmitButton();

        assertEquals("Ошибка авторизации. Не верные логин/пароль", loginPage.getValidationMessage());
    }

    @Test
    void loginWithInvalidLoginName() {
        LoginPage loginPage = new LoginPage();
        String invalidLogin = "Tester";
        String validPassword = ConfigurationReader.getPassword();

        loginPage.open();
        loginPage.enterLogin(invalidLogin);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnSubmitButton();

        assertEquals("Ошибка авторизации. Не верные логин/пароль", loginPage.getValidationMessage());
    }

    @Test
    void loginWithInvalidPasswordAndInvalidLoginName() {
        LoginPage loginPage = new LoginPage();
        String invalidLogin = "Tester";
        String invalidPassword = "qwerty1234";

        loginPage.open();
        loginPage.enterLogin(invalidLogin);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickOnSubmitButton();

        assertEquals("Ошибка авторизации. Не верные логин/пароль", loginPage.getValidationMessage());
    }

    @Test
    void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.clickOnSubmitButton();

        assertEquals("Пожалуйста, введите логин", loginPage.getLoginFieldAlert());
        assertEquals("Пожалуйста, введите пароль", loginPage.getPasswordFieldAlert());
    }
}
