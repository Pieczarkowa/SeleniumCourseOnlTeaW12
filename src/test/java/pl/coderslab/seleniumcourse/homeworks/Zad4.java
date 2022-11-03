package pl.coderslab.seleniumcourse.homeworks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/*Ćwiczenie z wyszukiwania xPath. Na portalu sklepu https://mystore-testlab.coderslab.pl/index.php?controller=authentication&create_account=1
 wyszukaj następujące elementy:

        social title
        First name
        Last name
        Email
        Password
        Show
        Birthdate */

public class Zad4 {

    WebDriver driver;

    @Test
    public void shouldFindByXpath(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&create_account=1");
        WebElement socialTitle = driver.findElement(By.xpath("//input")); // to jest pewnie źle
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement emailAddr = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement showBtnn= driver.findElement(By.xpath("//button[@type='button']"));
        WebElement birthdateField= driver.findElement(By.xpath("//input[@name='birthday']"));

    }


    @BeforeEach
    public void BeforeEach(){
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
        this.driver = new EdgeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));

    }
}
