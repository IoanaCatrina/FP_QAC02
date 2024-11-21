package tests;

import objectModels.RegistrationModel;
import objectModels.RegistrationDetailsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "registrationDataProvider", dataProviderClass = dataProviders.RegistrationDataProvider.class)
    public void registrationTest(RegistrationModel registrationModel) {
        registerWithRegisterModel(registrationModel);
    }

    private void registerWithRegisterModel(RegistrationModel registrationModel) {
        setUP();
        navigateToURL("cont-nou");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        System.out.println(registrationModel);

        RegistrationDetailsModel registrationForm = registrationModel.getRegistrationDetailsModel();

        registrationPage.register(registrationForm.getLastname(), registrationForm.getFirstname(),
                registrationForm.getPhone(), registrationForm.getEmail(),
                registrationForm.getAddress(), registrationForm.getCity(), registrationForm.getCounty(),
                registrationForm.getPassword(), registrationForm.getConfirmPassword());

        if (registrationModel.getRegisterError().isEmpty()) {
            System.out.println("Verify registration successful");
            Assert.assertTrue(registrationPage.successfulLandingURL());
            Assert.assertTrue(registrationPage.verifyRegistrationSuccessful(registrationForm.getFirstname(), registrationForm.getLastname()));
        } else {
            System.out.println("Verify registration failed message");
            Assert.assertEquals(registrationPage.getRegistrationError(), registrationModel.getRegisterError());
        }
    }

    @Test
    public void requiredAttributePresent() {
        setUP();
        navigateToURL("cont-nou");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        System.out.println("Verify that required attribute is present");

        Assert.assertTrue(registrationPage.verifyLastnameIsRequired());
        Assert.assertTrue(registrationPage.verifyFirstnameIsRequired());
        Assert.assertTrue(registrationPage.verifyPhoneNumberIsRequired());
        Assert.assertTrue(registrationPage.verifyEmailIsRequired());
        Assert.assertTrue(registrationPage.verifyAddressIsRequired());
        Assert.assertTrue(registrationPage.verifyCityIsRequired());
        Assert.assertTrue(registrationPage.verifyCountyIsRequired());
        Assert.assertTrue(registrationPage.verifyPasswordIsRequired());
        Assert.assertTrue(registrationPage.verifyConfirmPasswordIsRequired());
    }


}
