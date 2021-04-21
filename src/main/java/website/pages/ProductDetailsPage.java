package website.pages;
import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

import javax.print.attribute.standard.MediaSize;

public class ProductDetailsPage extends Base {
    private static final By ADD_TO_CART_VALIDATION_MESSAGE = By.cssSelector(".alert-success");
    private static final By ADD_TO_CART_BUTTON = By.id("button-cart");
    private static final By NAME_OF_PRODUCT = By.xpath("//*[@id=\"content\"]//h1");


    public static void open(String productDetailsPageUrlSuffix) {
        String url = "http://shop.pragmatic.bg/index.php?route=product/" + productDetailsPageUrlSuffix;
        Browser.driver.get(url);
    }


    public static void addToCart() {
        Browser.driver.findElement(ADD_TO_CART_BUTTON).click();
    }


    public static void verifySuccessMessageExists() {
        String actualLoginFormValidationMessage = getText(ADD_TO_CART_VALIDATION_MESSAGE);
        String nameOfProduct = Browser.driver.findElement(NAME_OF_PRODUCT).getText();
        String expectedAddedToCartValidationMessage = String.format("Success: You have added %s to your " +
                "shopping cart!", nameOfProduct);
        String messageOnFailure = "Add to cart validation message wasn't displayed or was wrong.";
        Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedAddedToCartValidationMessage),
                messageOnFailure);
    }
}