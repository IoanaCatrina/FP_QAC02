package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {
    @Test
    public void logoutTest() {
        setUP();
        driver.navigate().to(baseURL);
        LogoutPage logoutPage = new LogoutPage(driver);
        System.out.println("Verify logout successful");
        Assert.assertEquals(logoutPage.verifyLogoutSuccessful(), "Autentificare");
    }
}
