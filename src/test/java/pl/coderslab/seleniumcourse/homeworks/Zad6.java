package pl.coderslab.seleniumcourse.homeworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class Zad6 {
    WebDriver driver;

    @Test
    public void rejestracjaUzytkownika() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signInBtn = driver.findElement(By.className("user-info"));
        signInBtn.click();
        WebElement createAccBtn = driver.findElement(By.className("no-account"));
        createAccBtn.click();
        WebElement socialTitle = driver.findElement(By.xpath("//input")); // to jest pewnie źle
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement emailAddr = driver.findElement(By.xpath("//input[@name='email']"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailAddr.clear();
        emailAddr.sendKeys(randomEmail);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement showBtnn= driver.findElement(By.xpath("//button[@type='button']"));
        WebElement birthdateField= driver.findElement(By.xpath("//input[@name='birthday']"));

    }

        @BeforeEach
        public void beforeEach() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        }
    }

