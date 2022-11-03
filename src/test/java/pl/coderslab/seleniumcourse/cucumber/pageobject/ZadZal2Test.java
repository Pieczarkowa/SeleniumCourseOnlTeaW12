package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.junit.jupiter.api.AfterEach;
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
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*Napisz skrypt, który:

zaloguje się na tego samego użytkownika z zadania 1,
wybierze do zakupu Hummingbird Printed Sweater
wybierze rozmiar M, wybierze 5 sztuk według parametru podanego w teście, dodaj produkt do koszyka,
przejdzie do opcji - checkout,potwierdzi address (możesz go dodać wcześniej ręcznie),
wybierze metodę odbioru - PrestaShop "pick up in store",wybierze opcję płatności - Pay by Check,
kliknie na "order with an obligation to pay",zrobi screenshot z potwierdzeniem zamówienia i kwotą.*/


public class ZadZal2Test {
    WebDriver driver;


    @Test
    public void PurchasingSweaters() throws IOException {
        driver.get("https://mystore-testlab.coderslab.pl");
        WebElement signInIcon = driver.findElement(By.className("user-info"));
        signInIcon.click();
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("alicja.testowa@wp.pl");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("tajne");
        WebElement signInBtnIcon = driver.findElement(By.id("submit-login"));
        signInBtnIcon.click();
        WebElement clothesIcon = driver.findElement(By.xpath("//*[@id=\"category-3\"]/a"));
        clothesIcon.click();
        WebElement birdSweater = driver.findElement(By.xpath("//img[@alt = 'Brown bear printed sweater']"));
        birdSweater.click();
        List<WebElement> sizes = driver.findElements(By.xpath("//*[@id=\"group_1\"]/option"));
        sizes.get(1).click();
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
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "purchase-success-evidence-" + currentDateTime + ".png"));
        WebElement yourAccount = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        yourAccount.click();
        WebElement yourOrders = driver.findElement(By.xpath("//*[@id=\"history-link\"]/span"));
        yourOrders.click();
    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        this.driver.quit();
    }
}