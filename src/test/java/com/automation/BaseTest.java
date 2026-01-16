package com.automation;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.corejava.BrowserType;
import com.automation.corejava.LoginData;
import com.automation.util.YamlConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginData loginData;
    protected String email;
    protected String password;

    @BeforeEach
    public void setup(){
        YamlConfigReader reader = new YamlConfigReader("config.yaml");
        String env = System.getProperty("env", "QA");
        String userType = System.getProperty("userType", "user");
        String browserName = System.getProperty("browser", "CHROME");
        BrowserType browser = BrowserType.valueOf(browserName.toUpperCase());

        Map<String, Object> envConfig = reader.getEnvConfig(env);
        String baseUrl = (String) envConfig.get("baseUrl");

        Map<String, String> userConfig = (Map<String, String>) envConfig.get(userType);
        loginData = new LoginData(userConfig.get("email"), userConfig.get("password"));

        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new org.openqa.selenium.firefox.FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new org.openqa.selenium.edge.EdgeDriver();
                break;
            // Add other browsers (FIREFOX, EDGE, SAFARI) as needed
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Store email and password in fields if needed for your test methods
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
