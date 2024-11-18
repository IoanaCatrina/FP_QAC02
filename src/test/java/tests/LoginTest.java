package tests;

import objectModels.LoginModel;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = dataProviders.LoginDataProvider.class)
    public void loginTest(LoginModel loginModel) {

    }
}
