package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/"; // Assigning the URL

    @Before // First step to be executed
    public void setUp() {
        openBrowser(baseUrl); // Calling the method from BaseTest class
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        System.out.println("The Page Title : " + driver.getTitle()); // Getting page title
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click(); // Performing the click on Log in button
        // Locating the email element and sending the value to it
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        // Locating the password element and sending the value to it
        driver.findElement(By.id("Password")).sendKeys("Prime123");
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found"; // Expected message displayed on the webpage
        // Getting the actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]"));
        String actualMessage = actualTextElement.getText(); // Storing the Actual message
        assertEquals(expectedMessage, actualMessage); // Comparing both messages
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        String expectedMessage = "Register";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Register']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public static String getRandomEmail() { // Method generating the Random email everytime
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Register']")).click(); // Clicking on the Register link
        driver.findElement(By.id("gender-male")).click(); // Selecting the Male Option
        // Locating the First name element and sending the value to it
        driver.findElement(By.id("FirstName")).sendKeys("Roopen");
        // Locating the Last name element and sending the value to it
        driver.findElement(By.id("LastName")).sendKeys("Patel");
        // Locating the Day element and sending the value to it
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).sendKeys("25");
        // Locating the Month element and sending the value to it
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).sendKeys("November");
        // Locating the Year element and sending the value to it
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).sendKeys("1981");
        // Locating the Email element and sending the value to it
        driver.findElement(By.id("Email")).sendKeys(getRandomEmail());
        // Locating the Password element and sending the value to it
        driver.findElement(By.id("Password")).sendKeys("Aryan1008");
        // Locating the Confirm Password element and sending the value to it
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Aryan1008");
        // Locating the Register button and clicking on it
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        // Verifying the Successful registration and whether the confirmation text is displayed or not
        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='Your registration completed']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void cutOff() {
        closeBrowser();
    } // Closing the browser
}
