package bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import website.component.Header;
import website.pages.Login;

public class BDDPositiveLoginTests {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Login.open();
    }

    @When("he enters a correct email {string} and password {string} and logs in")
    public void he_enters_a_correct_email_and_password(String correctEmail, String correctPW) {
        Login.login(correctEmail, correctPW);
    }

    @Then("he should be logged in")
    public void he_should_be_logged_in() {
        Header.verifyLogoutButtonExists("Did not login successfully");
    }


}
