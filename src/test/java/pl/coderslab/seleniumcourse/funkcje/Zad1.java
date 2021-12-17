package pl.coderslab.seleniumcourse.funkcje;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class Zad1 {
    WebDriver driver;

    @Test
    public void shouldFindByClassName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@wp.pl"; // Tworzenie random maila
        emailInput.clear();
        emailInput.sendKeys(randomEmail);
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();

        WebElement genderMr = driver.findElement(By.cssSelector("input#id_gender1"));
        genderMr.click();
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        if(!firstNameInput.isDisplayed() || !firstNameInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        firstNameInput.sendKeys("Jan");
        WebElement lastNameInput = driver.findElement(By.id("customer_lastname"));
        if(!lastNameInput.isDisplayed() || !lastNameInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        lastNameInput.sendKeys("Janowski");
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        if(!passwordInput.isDisplayed() || !passwordInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        passwordInput.sendKeys("HasloTest123");
        WebElement registerBtn = driver.findElement(By.id("submitAccount"));
        if(!registerBtn.isDisplayed()){
            Assertions.fail("element not visible!");
        }
        registerBtn.click();
    }


    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

}
