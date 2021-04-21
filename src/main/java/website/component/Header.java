package website.component;

import core.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class Header extends Base {
    private static final By MY_ACCOUNT_BUTTON = By.cssSelector("a[title=\"My Account\"]");
    private static final By LOGOUT_BUTTON = By.cssSelector("a[href$=\"logout\"]");

    public static void verifyLogoutButtonExists(String messageOnFailure) {
        Browser.driver.findElement(MY_ACCOUNT_BUTTON).click();
        boolean exists = Browser.driver.findElements(LOGOUT_BUTTON).size()!=0;
        Assert.assertTrue(exists, messageOnFailure);
    }

    public static void verifyLogoutButtonDoesNotExist(String messageOnFailure){
        Browser.driver.findElement(MY_ACCOUNT_BUTTON).click();
        boolean exists = Browser.driver.findElements(LOGOUT_BUTTON).size()!=0;
        Assert.assertFalse(exists, messageOnFailure);
    }
}