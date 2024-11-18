package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//h1[contains(text(), 'Cont nou)]")
    private WebElement pageIdentifier;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "person-0")
    private WebElement individualAccount;

    @FindBy(id = "person-1")
    private WebElement businessAccount;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "cpassword")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//form[@class='buttons']/a")
    private WebElement registrationButton;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void register(String lastName, String firstName, String phoneNumber, String email,
                         String address, String city, String county,
                         String password, String confirmPassword ) {
        waitUntilElementVisible(pageIdentifier);
        this.enterLastName(lastName);
        this.enterFirstName(firstName);
        this.enterPhoneNumber(phoneNumber);
        this.enterEmail(email);
        this.clickOnIndividualAccount();
        this.enterAddress(address);
        this.enterCity(city);
        this.enterCounty(county);
        this.enterPassword(password);
        this.enterConfirmPassword(confirmPassword);
        this.submit();
    }

    public void enterLastName(String lastName) {
        waitUntilElementVisible(lastNameInput);
        System.out.println("Enter lastName: " + lastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterFirstName(String firstName) {
        waitUntilElementVisible(firstNameInput);
        System.out.println("Enter lastName: " + firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(firstName);
    }

    public void enterPhoneNumber(String phoneNumber) {
        waitUntilElementVisible(phoneInput);
        System.out.println("Enter phone number: " + phoneNumber);
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(emailInput);
        System.out.println("Enter phone number: " + email);
        phoneInput.clear();
        phoneInput.sendKeys(email);
    }

    public void clickOnIndividualAccount() {
        waitUntilElementVisible(individualAccount);
        System.out.println("Choose individual account");
        individualAccount.click();
    }

    public void enterAddress(String address) {
        waitUntilElementVisible(addressInput);
        System.out.println("Enter your address: " + address);
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        waitUntilElementVisible(cityInput);
        System.out.println("Enter city: " + city);
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterCounty(String county) {
        waitUntilElementVisible(stateInput);
        System.out.println("Enter city: " + county);
        cityInput.clear();
        cityInput.sendKeys(county);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordInput);
        System.out.println("Enter password: " + password);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        waitUntilElementVisible(confirmPasswordInput);
        System.out.println("Enter confirm password: " + confirmPassword);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void submit() {
        waitUntilElementVisible(registrationButton);
        System.out.println("Click on registration button");
        registrationButton.click();
    }


}

