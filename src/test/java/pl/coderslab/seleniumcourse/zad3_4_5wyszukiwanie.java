package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

/* Zad 3. Na stronie https://hotel-testlab.coderslab.pl//en/ znajdz pola za pomocą lokalizatora By.className:
(przycisk) Sign In
(pole tekstowe) Email address
Następnie kliknij przycisk Sign In i wpisz dowolny adres e-mail w pole Email address.
Rozpocznij tworzenie nowego użytkownika za pomocą kliknięcia przycisku Create an account
 (nie musi być z wykorzystaniem lokalizatora By.className)
 */

public class zad3_4_5wyszukiwanie {
    WebDriver driver;

    @Test
    public void shouldFindByClassName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
        WebElement emailPlace = driver.findElement(By.id("email_create"));
        emailPlace.clear();
        emailPlace.sendKeys("test.testowy@wp.pl");
        WebElement createAccBtn = driver.findElement(By.id("SubmitCreate"));
        createAccBtn.submit();
        //wyszukaj za pomocą lok. xpath wymagane pola i wypełnij je dowolnymi danymi. Kliknij przycisk Register.
        WebElement GenderBtnMrs = driver.findElement(By.xpath("//input[@id='id_gender2']"));
        GenderBtnMrs.click();
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        firstNameField.sendKeys("Anna");
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastNameField.sendKeys("Kowalska");
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Password");
        WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
        registerButton.click();
        //Zad. 5 Po utworzeniu konta zidentyfikuj pole My Personal Information uzywajac lokalizatora By.cssSelector
        WebElement myPersonalInfo = driver.findElement(By.cssSelector("i.icon-user"));


    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

   @AfterEach
   public void afterEach() {
        this.driver.quit();
    }
}