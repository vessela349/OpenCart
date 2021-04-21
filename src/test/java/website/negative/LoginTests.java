package website.negative;

import core.BaseTest;
import sun.rmi.runtime.Log;
import website.pages.Login;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void unsuccessfulLoginInvalidEmail() {
        Login.open();
        Login.login("blahlblahblah", "pwpwpw");
        Login.verifyLoginFormValidationMessage("No validation upon trying " +
                "to login with invalid email format.");
    }

    @Test
    public void unsuccessfulLoginWrongEmail(){
        Login.open();
        Login.login("testin@example.com", "Testing123");
        Login.verifyLoginFormValidationMessage("No validation upon trying " +
                "to login with wrong email.");
    }

    @Test
    public void unsuccessfulLoginWrongPasswordLowercase(){
        Login.open();
        Login.login("testing@example.com", "testing123");
        Login.verifyLoginFormValidationMessage("No validation upon trying " +
                "to login with lowercase password.");
    }

    @Test
    public void unsuccessfulLoginWrongPassword(){
        Login.open();
        Login.login("testing@example.com", "!@#sdfAA");
        Login.verifyLoginFormValidationMessage("No validation upon trying " +
                "to login with entirely wrong password.");
    }
}
