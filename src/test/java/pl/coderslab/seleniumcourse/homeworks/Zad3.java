package pl.coderslab.seleniumcourse.homeworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/*      Wyszukiwanie elementów - formularz
        Pod linkiem https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html dostępny jest formularz,
        którego wypełnianie i wysyłanie należy zautomatyzować.Wypełnij dane w formularzu:

        First name: Karol
        Last name: Kowalski
        Gender: Male
        Date of birth: 05/22/2010
        Address: Prosta 51
        Email: karol.kowalski@mailinator.com
        Password: Pass123
        Company: Coders Lab
        Comment: To jest mój pierwszy automat testowy
        Zatwierdź formularz - SUBMIT */



public class Zad3 {

    WebDriver driver;

    @Test
    public void submittingTheForm () {
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("Karol");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Kowalski");
        WebElement genderFieldMr = driver.findElement(By.className("radio-inline"));
        genderFieldMr.click();

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.sendKeys("05/22/2010");
        WebElement addressField = driver.findElement(By.id("address"));
        addressField.sendKeys("Prosta 51");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("karol.kowalski@mailinator.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Pass123");
        WebElement companyField = driver.findElement(By.name("company"));
        companyField.sendKeys("Coders Lab");
        WebElement commentSection = driver.findElement(By.name("comment"));
        commentSection.sendKeys("To jest mój pierwszy automat testowy");
        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();
    }


        @BeforeEach
                public void beforeEach() {
            System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
            this.driver = new EdgeDriver();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

        }

    }



