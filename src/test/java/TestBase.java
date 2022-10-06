import com.codeborne.selenide.Configuration;
import configuration.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = ConfigurationReader.getBaseUrl();
        Configuration.headless = ConfigurationReader.getHeadlessBoolean();
        Configuration.browser = ConfigurationReader.getBrowser();
        Configuration.pageLoadTimeout = ConfigurationReader.getPageLoadTimeout();
    }

}
