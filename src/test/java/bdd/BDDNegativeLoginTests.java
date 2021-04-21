package bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Browser;
import website.pages.Login;

public class BDDNegativeLoginTests {
    @Before
    public void setup() {
        Browser.openBrowser();
    }


    @After
    public void tearDown(){
        Browser.quit();
    }

    @When("he enters a wrong email {string} and password {string} and tries to log in")
    public void he_enters_a_wrong_email_and_password(String invalidEMail, String invalidPW) {
        Login.login(invalidEMail, invalidPW);
    }

    @Then("error message should appear")
    public void errorMessageWarningNoMatchForEMailAddressAndOrPasswordShouldAppear() {
        Login.verifyLoginFormValidationMessage("No validation upon trying to login with wrong credentials.");
    }
}

