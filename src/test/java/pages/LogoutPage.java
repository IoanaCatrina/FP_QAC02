package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage{

    @FindBy(xpath = "//*[@class='user-action']//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    LoginPage loginPage = new LoginPage(driver);

    public LogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        loginPage.login("ioanacorinaoancea@gmail.com", "SnoopyDog12!");
        loginPage.authenticationButtonDisplayed();
        loginPage.moveToAuthenticationButton();
        System.out.println("Logout button is visible");
        waitUntilElementIsClickable(logoutButton);
        System.out.println("Click Logout button");
        logoutButton.click();
    }

    public String verifyLogoutSuccessful() {
        logout();
        return loginPage.getAuthenticationHoverButton().getText();
    }
}
