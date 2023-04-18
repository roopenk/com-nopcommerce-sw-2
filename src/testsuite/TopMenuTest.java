package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/"; // Assigning the URL

    @Before // First step to be executed
    public void setUp() {
        openBrowser(baseUrl); // Calling the method from BaseTest class
    }

    @Test
    // Test to verify that user can Log in with valid credentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        System.out.println("The Page Title : " + driver.getTitle()); // Getting page title
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click(); // Performing the click on Log in button
        // Locating the email element and sending the value to it
        driver.findElement(By.id("Email")).sendKeys("rockpopone@rediffmail.com");
        // Locating the password element and sending the value to it
        driver.findElement(By.id("Password")).sendKeys("Aryan1008");
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
        String expectedMessage = "Log out"; // Expected message displayed on the webpage
        // Getting the actual message
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualMessage = actualTextElement.getText(); // Storing the Actual message
        Assert.assertEquals(expectedMessage, actualMessage); // Comparing both messages
    }

    @Test
    // Test to verify that Upon clicking on the Computers link, user can navigate to Computers page
    // And the "Computers" title is displayed
    public void userShouldNavigateToComputerPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Computers ']")).click();
        String expectedMessage = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Computers']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Electronics link, user can navigate to Electronics page
    // And the "Electronics" title is displayed
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
        String expectedMessage = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Apparel link, user can navigate to Apparel page
    // And the "Apparel" title is displayed
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Apparel ']")).click();
        String expectedMessage = "Apparel";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Apparel']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Digital Downloads link, user can navigate to Digital Downloads page
    // And the "Digital Downloads" title is displayed
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Digital downloads ']")).click();
        String expectedMessage = "Digital downloads";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Digital downloads']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Books link, user can navigate to Books page
    // And the "Books" title is displayed
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Books ']")).click();
        String expectedMessage = "Books";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Books']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Jewelry link, user can navigate to Jewelry page
    // And the "Jewelry" title is displayed
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Jewelry ']")).click();
        String expectedMessage = "Jewelry";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Jewelry']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    // Test to verify Upon clicking on the Gift Cards link, user can navigate to Gift Cards page
    // And the "Gift Cards" title is displayed
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Gift Cards ']")).click();
        String expectedMessage = "Gift Cards";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Gift Cards']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void cutOff() {
        closeBrowser();
    } // Closing the browser

}
