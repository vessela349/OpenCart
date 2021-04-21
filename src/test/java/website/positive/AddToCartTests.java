package website.positive;

import core.BaseTest;
import org.testng.annotations.Test;
import utils.Browser;
import website.pages.ProductDetailsPage;
import website.pages.ProductDetailsPageWithOptions;

import java.awt.*;

public class AddToCartTests extends BaseTest {

    @Test
    public void addiMacToCart(){
        ProductDetailsPage.open("product&path=20_27&product_id=41");
        ProductDetailsPage.addToCart();
        ProductDetailsPage.verifySuccessMessageExists();
    }


    @Test
    public void addAppleCinemaToCart() throws InterruptedException, AWTException {
        ProductDetailsPage.open("product&path=25_28&product_id=42");
        ProductDetailsPageWithOptions.selectRadioButton("medium");
        ProductDetailsPageWithOptions.selectCheckBox(2);
        ProductDetailsPageWithOptions.selectCheckBox(3);
        ProductDetailsPageWithOptions.inputTextInTextBox("This is my text");
        ProductDetailsPageWithOptions.selectDropDownOption("blue");
        ProductDetailsPageWithOptions.inputTextInBigTextBox("This is a lot of text, oh my!");
        ProductDetailsPageWithOptions.uploadFile("C:\\Users\\user\\Pictures\\1422.jpg");
        Thread.sleep(5000);
        ProductDetailsPageWithOptions.verifyUploadedFile();
        ProductDetailsPageWithOptions.enterDateDecTenth();
        ProductDetailsPageWithOptions.enterTime00_00();
        ProductDetailsPageWithOptions.enterDateDecTenthTime00_00();
        ProductDetailsPage.addToCart();
        ProductDetailsPage.verifySuccessMessageExists();
    }
}
