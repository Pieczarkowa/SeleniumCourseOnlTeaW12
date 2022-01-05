package pl.coderslab.seleniumcourse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

// Wyszukaj elementy za pomocą lokalizatora by.id
//Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora by.id:
//
//
//(pole tekstowe) Hotel Location
//(przycisk) Search Now
//(pole tekstowe) Enter your e-mail (pole na dole stron)
//Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//Hotel Location - Warsaw
//Enter your e-mail - test@test.com

// zad 1 - By.id

public class zad3_4_5wyszukiwanie {
    WebDriver driver;


// zad 3 By.className
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
        //przechodzi w zad 4 by.xpath
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
        //teraz zad 5
        WebElement myPersonalInfo = driver.findElement(By.cssSelector("i.icon-user"));
     //   myAddressesField.click();

    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

//    @AfterEach
//    public void afterEach() {
//        this.driver.quit();
//    }
}