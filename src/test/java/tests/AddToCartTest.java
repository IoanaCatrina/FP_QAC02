package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void AddToCartTest() {
        setUP();
        navigateToURL("laptop-tablete/laptop-notebook");

        AddToCartPage addToCartPage = new AddToCartPage(driver);
        addToCartPage.addProductToCart();
        System.out.println("Verify the product added to cart is the same with product from cart");
        Assert.assertEquals(addToCartPage.getProductTitle(), addToCartPage.getProductAddedToCart());
    }
}
