package pages;

import static com.codeborne.selenide.Selenide.$;

public class DesktopPage {
    public String getUserName () {
        return $(".current-user").text();
    }

    public String getPageMainTitle() {
        return $("h1.ils-title").text();
    }
}
