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

    public void clickOnSubmitButton() {
        $(By.cssSelector("button[type=\"submit\"]")).click();
    }
}
