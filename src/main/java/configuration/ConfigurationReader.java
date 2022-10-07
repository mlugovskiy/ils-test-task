package configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    private ConfigurationReader() {
    }

    static {
        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/test.properties"))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLogin() { return properties.getProperty("login"); }

    public static String getPassword() { return properties.getProperty("password"); }

    public static String getUsername() { return properties.getProperty("username"); }


    public static String getBaseUrl() { return properties.getProperty("baseUrl"); }

    public static boolean getHeadlessBoolean() { return Boolean.parseBoolean(properties.getProperty("headless")); }

    public static String getBrowser() { return properties.getProperty("browser"); }

    public static long getPageLoadTimeout() { return Long.parseLong(properties.getProperty("pageLoadTimeout")); }

    public static long getTimeout() { return Long.parseLong(properties.getProperty("timeout")); }




}
