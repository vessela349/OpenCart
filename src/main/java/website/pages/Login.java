package website.pages;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;
import website.component.Header;

public class Login extends Base {

    private static final By EMAIL_FIELD = By.id("input-email");
    private static final By PASSWORD_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector("input[class=\"btn btn-primary\"]");
    private static final By LOGIN_FORM_VALIDATION_MESSAGE = By.cssSelector(".alert-danger");


    public static void open() {
        Browser.driver.get("https://opencart.abstracta.us/index.php?route=account/login");
    }

    public static void login(String email, String password) {
        type(EMAIL_FIELD, email);
        type(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);
    }


    public static void verifyLoginFormValidationMessage(String messageOnFailure) {
        if (Browser.driver.findElements(LOGIN_FORM_VALIDATION_MESSAGE).size() > 0) {
            String expectedLoginFormValidationMessage = "Warning: No match for E-Mail Address and/or Password.";
            String actualLoginFormValidationMessage = getText(LOGIN_FORM_VALIDATION_MESSAGE);
            Assert.assertTrue(actualLoginFormValidationMessage.contains(expectedLoginFormValidationMessage),
                    messageOnFailure);
        } else {
            Header.verifyLogoutButtonDoesNotExist("User managed to login with wrong credentials!!!");
        }
    }
}
