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

/* Wyszukaj elementy za pomocą lok. by.id
Na stronie https://hotel-testlab.coderslab.pl/en/ zidentyfikuj następująca pola:

(pole tekstowe) Hotel Location
(przycisk) Search Now
(pole tekstowe) Enter your e-mail
Po zidentyfikowaniu elementów wpisz następujące wartości w pola:

Hotel Location - Warsaw
Enter your e-mail - test@test.com

 zad 1 - By.id */

public class FindBy {
    WebDriver driver;

    @Test
    public void shouldFindById() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchNowBtn = driver.findElement(By.id("search_room_submit"));
        WebElement enterEmailInput = driver.findElement(By.id("newsletter-input"));
        hotelLocationInput.sendKeys("Warsaw");
        enterEmailInput.sendKeys("test@test.com");

     //zad 2. find By.name, j.w + przycisk subscribe. Dodatkowo kliknij przycisk Serach Now, używając metody Submit
    }

    @Test
    public void shouldFindByName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.name("hotel_location"));
        WebElement searchNowBtn = driver.findElement(By.name("search_room_submit"));
        WebElement enterYourEmailInput = driver.findElement(By.name("email"));
        WebElement subscribeBtn = driver.findElement(By.name("submitNewsletter"));
        hotelLocationInput.sendKeys("Warsaw");
        enterYourEmailInput.sendKeys("test@test.com");
        driver.findElement(By.name("search_room_submit")).submit();

    }
/* Zad 3. Na stronie https://hotel-testlab.coderslab.pl//en/ znajdz pola za pomocą lokalizatora By.className:
(przycisk) Sign In
(pole tekstowe) Email address
Następnie kliknij przycisk Sign In i wpisz dowolny adres e-mail w pole Email address.
Rozpocznij tworzenie nowego użytkownika za pomocą kliknięcia przycisku Create an account
(nie musi być z wykorzystaniem lokalizatora By.className)*/

    @Test
    public void shouldFindByClassName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailInput.clear();
        emailInput.sendKeys(randomEmail);
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();
        WebElement radioMr = driver.findElement(By.cssSelector("input#id_gender1"));
        radioMr.click();
        WebElement firstNameInput = driver.findElement(By.id("customer_firstname"));
        if(!firstNameInput.isDisplayed() || !firstNameInput.isEnabled()) {
            Assertions.fail("element not interactable!");
        }
        firstNameInput.sendKeys("Alek");
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