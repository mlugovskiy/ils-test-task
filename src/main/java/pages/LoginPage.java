package pages;

import com.codeborne.selenide.Selenide;
import configuration.ConfigurationReader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void open() {
        Selenide.open(ConfigurationReader.getBaseUrl());
    }

    public void enterLogin(String login) {
        $(By.id("login")).val(login);
    }

    public void enterPassword(String password) {
        $(By.id("password")).val(password);
    }

    public String getValidationMessage() {
        return $(By.cssSelector("div.ant-notification-notice-description > div.content")).text();
    }

    public void clickOnSubmitButton() {
        $(By.cssSelector("button[type=\"submit\"]")).click();
    }

    public String getLoginFieldAlert() {
        return $(By.cssSelector("form>div:nth-child(1) div[role=\"alert\"] ")).text();
    }

    public String getPasswordFieldAlert() {
        return $(By.cssSelector("form>div:nth-child(2) div[role=\"alert\"] ")).text();
    }
}
