package website.pages;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Map;

public class ProductDetailsPageWithOptions extends ProductDetailsPage {
    private static final Map<String, By> RADIO_BUTTONS_BY_NAME =
            ImmutableMap.of(
                    "large", By.cssSelector("input[name=\"option[218]\"][value=\"7\"]"),
                    "medium", By.cssSelector("input[name=\"option[218]\"][value=\"6\"]"),
                    "small", By.cssSelector("input[name=\"option[218]\"][value=\"5\"]")
            );
    private static final Map<String, String> DROP_DOWN_VALUES_BY_NAME =
            ImmutableMap.of(
                    "red", "4",
                    "blue", "3",
                    "green", "1",
                    "yellow", "2"
            );
    private static final By TEXTBOX = By.cssSelector("input[name=\"option[208]\"]");
    private static final By DROPDOWN = By.id("input-option217");
    private static final By BIG_TEXTBOX = By.id("input-option209");
    private static final By UPLOAD_BUTTON = By.id("button-upload222");
    private static final By DATE_BUTTON = By.cssSelector("[class=\"input-group date\"]>[class=\"input-group-btn\"]");
    private static final By TIME_BUTTON = By.cssSelector("[class=\"input-group time\"]>[class=\"input-group-btn\"]");
    private static final By DATE_AND_TIME_BUTTON = By.cssSelector("[class=\"input-group datetime\"]>[class=\"input-group-btn\"]");
    private static final By MONTH_PICKER = By.cssSelector(".picker-open .datepicker-days .picker-switch");
    private static final By HOUR_PICKER = By.cssSelector(".picker-open .timepicker-picker .timepicker-hour");
    private static final By MINUTE_PICKER = By.cssSelector(".picker-open .timepicker-picker .timepicker-minute");
    private static final By DATE_DECEMBER = By.xpath("//*[contains(@class,\"picker-open\")]//*[@class=\"datepicker-months\"]" +
            "//*[contains(text(), \"Dec\")]");
    private static final By DATE_NEXT_MONTHS_BUTTON = By.cssSelector(".picker-open .datepicker-months .next");
    private static final By DATE_TENTH = By.xpath("//*[contains(@class,\"picker-open\")]//*[@class=\"datepicker-days\"]" +
            "//*[contains(text(), \"10\")]");
    private static final By HOUR_ZERO = By.xpath("//*[contains(@class,\"picker-open\")]//*[@class=\"timepicker-hours\"]" +
            "//*[contains(text(), \"00\")]");
    private static final By MINUTES_ZERO = By.xpath("//*[contains(@class,\"picker-open\")]//*" +
            "[@class=\"timepicker-minutes\"]//*[contains(text(), \"00\")]");
    private static final By TIME_TOGGLE = By.cssSelector(".picker-open .picker-switch .btn");


    public static void selectRadioButton(String button) {
        By selector = RADIO_BUTTONS_BY_NAME.get(button);
        Assert.assertNotNull(selector, "Invalid Radiobutton entered.");
        Browser.driver.findElement(selector).click();
    }

    public static By checkBoxNumber(int num) {
        if (num < 0 || num > 4) {
            Assert.fail("Wrong checkbox option entered.");
        }
        return By.cssSelector(String.format(
                "input[name=\"option[223][]\"][value=\"%d\"]",
                num + 7));
    }

    public static void selectCheckBox(int option) {
        Browser.driver.findElement(checkBoxNumber(option)).click();
    }

    public static void inputTextInTextBox(String text) {
        Browser.driver.findElement(TEXTBOX).sendKeys(text);
    }

    public static void inputTextInBigTextBox(String text) {
        Browser.driver.findElement(BIG_TEXTBOX).sendKeys(text);
    }

    public static void selectDropDownOption(String color) {
        Select drpColor = new Select(Browser.driver.findElement(DROPDOWN));
        String value = DROP_DOWN_VALUES_BY_NAME.get(color);
        Assert.assertNotNull(value, "Invalid dropdown option entered.");
        drpColor.selectByValue(value);
    }

    public static void uploadFile(String fileToUpload) throws AWTException {
        Browser.driver.findElement(UPLOAD_BUTTON).click();
        StringSelection strSelection = new StringSelection(fileToUpload);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);

        Robot robot = new Robot();

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void verifyUploadedFile() {
        Alert uploadConfirmation = Browser.driver.switchTo().alert();
        String actualAlertMessage = Browser.driver.switchTo().alert().getText();
        String expectedAlertMessage = "Your file was successfully uploaded!";
        Assert.assertEquals(expectedAlertMessage, actualAlertMessage, "Wrong alert message, expected was " +
                expectedAlertMessage + " actual was: " + actualAlertMessage);
        uploadConfirmation.accept();
        //dismiss?
    }

    public static void enterDateDecTenth(){
        Browser.driver.findElement(DATE_BUTTON).click();
        DecemberTenth();
    }

    private static void DecemberTenth(){
        Browser.driver.findElement(MONTH_PICKER).click();
        Browser.driver.findElement(DATE_DECEMBER).click();
        Browser.driver.findElement(DATE_TENTH).click();
    }

    public static void enterTime00_00(){
        Browser.driver.findElement(TIME_BUTTON).click();
        enterTime();
        Browser.driver.findElement(TIME_BUTTON).click();
    }

    private static void enterTime(){
        Browser.driver.findElement(HOUR_PICKER).click();
        Browser.driver.findElement(HOUR_ZERO).click();
        Browser.driver.findElement(MINUTE_PICKER).click();
        Browser.driver.findElement(MINUTES_ZERO).click();
    }

    public static void enterDateDecTenthTime00_00(){
        Browser.driver.findElement(DATE_AND_TIME_BUTTON).click();
        DecemberTenth();
        Browser.driver.findElement(TIME_TOGGLE).click();
        enterTime();
        Browser.driver.findElement(DATE_AND_TIME_BUTTON).click();
    }


}
