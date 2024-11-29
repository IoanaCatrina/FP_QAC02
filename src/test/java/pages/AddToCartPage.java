package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class AddToCartPage extends BasePage {

    @FindBy(xpath = "//*[@class='products-list']")
    private List<WebElement> productsList;

    @FindBy(id = "quick-cart")
    private WebElement shoppingCart;

    @FindBy(id = "cart-count")
    private WebElement cartCount;

    @FindBy(xpath = "//*[@class='heading-holder']/h1/strong[contains(text(),'COMANDA RAPIDA ')]")
    private WebElement shoppingCartPageName;

    @FindBy(xpath = "//*[@id='products-cart-list']//h2/a")
    private WebElement productAddedToCart;

    public AddToCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        WebElement product = getFirstProductFromList();
        WebElement addToCartButton = product.findElement(By.id("add-to-cart"));
        System.out.println("Add product to cart");
        addToCartButton.click();
    }

    public WebElement getFirstProductFromList() {
        wait.until(d -> productsList.size() > 0);
        WebElement firstProductFromList = productsList.get(1);
        return firstProductFromList;
    }

    public String getProductTitle() {
        WebElement product = getFirstProductFromList();
        WebElement productTitle = product.findElement(By.xpath("//*[@class='title']/a"));
        System.out.println("Product added to cart: " + productTitle.getText());
        return productTitle.getText();
    }


    public void shoppingCartPageIsDisplayed() {
        waitUntilElementVisible(shoppingCartPageName);
        System.out.println("Shopping Cart page is displayed: " + shoppingCartPageName.getText());
        shoppingCartPageName.isDisplayed();
    }

    public String getProductAddedToCart() {
        shoppingCartPageIsDisplayed();
//        waitUntilElementVisible(productAddedToCart);
        System.out.println("Product in the cart: " + productAddedToCart.getText());
        return productAddedToCart.getText();
    }
}
