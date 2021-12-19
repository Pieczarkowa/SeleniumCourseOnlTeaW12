package pl.coderslab.seleniumcourse.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterAccountSteps {
    private WebDriver driver;

    @Given("^Landing page (.*) opened in browser$")
    public void openWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(url);
    }
    @When("^Sign in button pressed$")
    public void pressSignIn() {
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();

    }
    @And("^provided email address in Create an account section$")
    public void provideEmail() {
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField .sendKeys("emailtest@wp.pl");
    }
    @And("Create an account button pressed")
    public void pressCreateAnAccount() {
        WebElement createButtn = driver.findElement(By.id("SubmitCreate"));
        createButtn.click();
    }
    @And("New user form filled out")
    public void fillingTheForm() {
        WebElement createButtn = driver.findElement(By.id("SubmitCreate"));
       createButtn.click();
        WebElement GenderBtnMrs = driver.findElement(By.xpath("//input[@id='id_gender2']"));
       GenderBtnMrs.click();
       WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
       firstNameField.sendKeys("Anna");
       WebElement lastNameField = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastNameField.sendKeys("Testowa");
        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Password");

    }
        @And("Register button pressed")
        public void pressRegisterBttn() {
            WebElement registerButton = driver.findElement(By.xpath("//button[@type='submit']"));
            registerButton.click();
    }
   @Then("^New account registered on https://hotel-testlab\\.coderslab\\.pl/ website$")
  public void checkIfRegistered() {
       WebElement registeredNameVisible = driver.findElement(By.id("user_info_acc"));
//       WebElement registeredNameVisible = driver.findElement(By.cssSelector(".account_user_name.hide_xs"));
       assertNotNull(registeredNameVisible);


    }
}