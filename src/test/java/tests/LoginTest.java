package tests;

import objectModels.AccountModel;
import objectModels.LoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = dataProviders.LoginDataProvider.class)
    public void loginTest(LoginModel loginModel) {
        loginWithLoginModel(loginModel);
    }

    protected void loginWithLoginModel(LoginModel loginModel) {
        setUP();
        driver.navigate().to(baseURL);

        LoginPage loginPage = new LoginPage(driver);
        System.out.println(loginModel);
        AccountModel account = loginModel.getAccount();
        loginPage.login(account.getEmail(), account.getPassword());

        if (areCredentialsValid(loginModel)) {
            System.out.println("Verify login successful");
            Assert.assertTrue(loginPage.verifyLoginSuccessful());
        } else if (areCredentialsInvalid(loginModel)) {
            System.out.println("Verify login failed with message: " + loginModel.getLoginError());
            Assert.assertTrue(loginPage.verifyLoginFailed(loginModel.getLoginError()));
        } else if (isValidationMessagePresent(loginModel)) {
            System.out.println("Verify validation message: " + loginModel.getValidationMessage());
            Assert.assertTrue(loginPage.verifyValidationMessage(loginModel.getValidationMessage()));
        }
    }

    private boolean areCredentialsValid(LoginModel loginModel) {
        return loginModel.getLoginError().isEmpty() && loginModel.getValidationMessage().isEmpty();
    }

    private boolean areCredentialsInvalid(LoginModel loginModel) {
        return !loginModel.getLoginError().isEmpty();
    }

    private boolean isValidationMessagePresent(LoginModel loginModel) {
        return !loginModel.getValidationMessage().isEmpty();
    }

}

