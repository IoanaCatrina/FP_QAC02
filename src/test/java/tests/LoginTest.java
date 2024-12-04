package tests;

import POJO.AccountModel;
import POJO.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginValidDataProvider", dataProviderClass = data.LoginDataProvider.class)
    public void loginPositiveTest(String email, String password) {
        setUP();
        driver.navigate().to(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        System.out.println("Verify login successful");
        Assert.assertTrue(loginPage.verifyLoginSuccessful());
    }

    @Test(dataProvider = "loginInvalidDataProvider", dataProviderClass = data.LoginDataProvider.class)
    public void loginNegativeTest(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }

    private void loginWithLoginModel(LoginModel loginModel) {
        setUP();
        driver.navigate().to(baseURL);
        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginModel);
        AccountModel account = loginModel.getAccount();
        loginPage.login(account.getEmail(), account.getPassword());

        if (areCredentialsInvalid(loginModel)) {
            System.out.println("Verify login failed with message: " + loginModel.getLoginError());
            Assert.assertTrue(loginPage.verifyLoginFailed(loginModel.getLoginError()));
        } else {
            System.out.println("Verify validation message: " + loginModel.getValidationMessage());
            Assert.assertTrue(loginPage.verifyValidationMessage(loginModel.getValidationMessage()));
        }
    }

    private boolean areCredentialsInvalid(LoginModel loginModel) {
        return !loginModel.getLoginError().isEmpty();
    }
}

