package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/"; // Assigning the URL

    @Before // First step to be executed
    public void setUp() {
        openBrowser(baseUrl); // Calling the method from BaseTest class
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        System.out.println("The Page Title : " + driver.getTitle()); // Getting page title
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click(); // Performing the click on Log in button
        String expectedMessage = "Welcome, Please Sign In!"; // Test case to compare the text displayed on the webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText(); // Storing the Actual message
        Assert.assertEquals(expectedMessage, actualMessage); // Comparing both messages
    }

    @After
    public void cutOff() {
        closeBrowser();
    } // Closing the browser
}