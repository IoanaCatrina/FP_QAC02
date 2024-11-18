package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import utils.ConfigUtils;
import utils.ConstantUtils;
import utils.BrowserUtils;

public class BaseTest {

    protected WebDriver driver;
    protected String baseURL;

    public void getBrowser(String browserName) {
        driver = BrowserUtils.getDriver(browserName);
    }

    public void getBrowser() {
        String browserName = ConfigUtils.readGenericElementFromConfig(ConstantUtils.DEFAULT_CONFIG_FILE,
                "browser", "chrome");
        System.out.println("Load browser type: " + browserName);
        driver = BrowserUtils.getDriver(browserName);
    }

    public void setUP() {
        getBaseURL();
        getBrowser();
    }

    private void closeBrowserAtEnd() {
        if (driver != null) {
            System.out.println("Close browser at end");
            driver.quit();
        }
    }

    @AfterTest
    public void cleanUp() {
        closeBrowserAtEnd();
    }

    @AfterMethod
    public void cleanAfterMethod() {
        closeBrowserAtEnd();
    }

    public void getBaseURL() {
        getBaseURL(ConstantUtils.DEFAULT_CONFIG_FILE);
    }

    public void getBaseURL(String configFileName) {
        baseURL = ConfigUtils.readGenericElementFromConfig(configFileName, "base.url");
    }

    public void navigateToURL(String path) {
        System.out.println("Open next URL: " + baseURL + path);
        driver.navigate().to(baseURL + path);
    }



}
