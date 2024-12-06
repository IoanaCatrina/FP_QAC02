package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigUtils;
import utils.ConstantUtils;
import utils.BrowserUtils;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected String baseURL;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReports/report.html");
        sparkReporter.config().setDocumentTitle("Test Report");
        sparkReporter.config().setReportName("Test results");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void startTest(Method method) {
        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
            test.log(Status.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        } else {
            test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public void flushExtentReport() {
        extent.flush();
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
