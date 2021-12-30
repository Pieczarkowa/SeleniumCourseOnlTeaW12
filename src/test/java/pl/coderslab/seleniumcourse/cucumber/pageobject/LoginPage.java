package pl.coderslab.seleniumcourse.cucumber.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCreateAnAccountRandomEmail() {
        WebElement emailInput = driver.findElement(By.id("email_create"));
        String randomEmail = UUID.randomUUID() + "@mail.pl";
        emailInput.clear();
        emailInput.sendKeys(randomEmail);
    }

    public void fillCreateAnAccountEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("email_create"));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    //tu dodaje zad2
    public void fillEmailToRegister(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordToRegister(String password) {
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInRegistered() {
        WebElement signInBtnRegistered = driver.findElement(By.id("SubmitLogin"));
        signInBtnRegistered.click();
    }
    //tu sie konczy zad2

    public void clickCreateAnAccount() {
        WebElement createAccountBtn = driver.findElement(By.id("SubmitCreate"));
        createAccountBtn.click();

    }
}