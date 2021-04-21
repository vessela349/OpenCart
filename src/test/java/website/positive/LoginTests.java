package website.positive;

import website.component.Header;
import website.pages.Login;
import core.BaseTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLogin() {
        Login.open();
        Login.login("testing@example.com", "Testing123");
        Header.verifyLogoutButtonExists("Did not login successfully");
    }
}