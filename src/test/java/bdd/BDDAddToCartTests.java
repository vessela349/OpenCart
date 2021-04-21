package bdd;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import website.pages.Login;
import website.pages.ProductDetailsPage;
import website.pages.ProductDetailsPageWithOptions;

import java.awt.*;

public class BDDAddToCartTests {
    @Given("the user is on the iMac product details page")
    public void the_user_is_on_the_iMac_product_details_page() {
        ProductDetailsPage.open("product&path=20_27&product_id=41");
    }

    @When("he selects to add iMac to cart")
    public void heSelectsToAddIMacToCart() {
        ProductDetailsPage.addToCart();
    }

    @Then("he should receive a success message")
    public void heShouldReceiveASuccessMessage() {
        ProductDetailsPage.verifySuccessMessageExists();
    }

    @Given("the user is on the Apple Cinema product details page")
    public void theUserIsOnTheAppleCinemaProductDetailsPage() {
        ProductDetailsPage.open("product&path=25_28&product_id=42");
    }

    @When("he selects all necessary configurations")
    public void heSelectsAllNecessaryConfigurations() throws AWTException, InterruptedException {
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
    }

    @When("he selects to add Apple Cinema to cart")
    public void heSelectsToAddAppleCinemaToCart() {
        ProductDetailsPage.addToCart();
    }
}
