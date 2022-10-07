import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import configuration.ConfigurationReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = ConfigurationReader.getBaseUrl();
        Configuration.headless = ConfigurationReader.getHeadlessBoolean();
        Configuration.browser = ConfigurationReader.getBrowser();
        Configuration.pageLoadTimeout = ConfigurationReader.getPageLoadTimeout();
        Configuration.timeout = ConfigurationReader.getTimeout();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
