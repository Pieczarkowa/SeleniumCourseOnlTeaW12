package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourse.pageobject.CreateAnAccountPage;
import pl.coderslab.seleniumcourse.pageobject.LoginPage;
import pl.coderslab.seleniumcourse.pageobject.MyAccountPage;
import pl.coderslab.seleniumcourse.pageobject.UserData;
import pl.coderslab.seleniumcourse.pageobject.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZadZal2Test {
    WebDriver driver;


    @Test
    public void LogInAndChooseProducts() throws IOException {
        driver.get("https://mystore-testlab.coderslab.pl");
        WebElement signInIcon = driver.findElement(By.className("user-info"));
        signInIcon.click();
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("alicja.testowa@wp.pl");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("tajne");
        WebElement signInBtnIcon = driver.findElement(By.id("submit-login"));
        signInBtnIcon.click();
        WebElement clothesIcon = driver.findElement(By.xpath("//a[@data-depth='0']"));
        clothesIcon.click();
        WebElement birdSweater = driver.findElement(By.xpath("//img[@alt = 'Brown bear printed sweater']"));
        birdSweater.click();
        WebElement sizeM = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        sizeM.click();
        WebElement quantityBtn = driver.findElement(By.xpath("//*[@name='qty']"));
        quantityBtn.clear();
        quantityBtn.sendKeys("5");
        WebElement addToCart = driver.findElement(By.xpath("//button[@data-button-action ='add-to-cart']"));
        addToCart.click();
        WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class = 'btn btn-primary']"));
        checkoutBtn.click();
        WebElement finalCheckout = driver.findElement(By.xpath("//a[@class = 'btn btn-primary']"));
        finalCheckout.click();
        WebElement confirmAddresses = driver.findElement(By.xpath("//button[@name = 'confirm-addresses']"));
        confirmAddresses.click();
        WebElement confirmShipping = driver.findElement(By.name("confirmDeliveryOption"));
        confirmShipping.click();
        WebElement payByCheckBtn = driver.findElement(By.id("payment-option-1"));
        payByCheckBtn.click();
        WebElement agreeTermsOfService = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        agreeTermsOfService.click();
        WebElement orderAndPay = driver.findElement(By.xpath("//button[@class = 'btn btn-primary center-block']"));
        orderAndPay.click();
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "registration-success-evidence-12-"+currentDateTime+".png"));
    }



    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

//   @AfterEach
    //  public void afterEach() {
    //      this.driver.quit();
//  }
}