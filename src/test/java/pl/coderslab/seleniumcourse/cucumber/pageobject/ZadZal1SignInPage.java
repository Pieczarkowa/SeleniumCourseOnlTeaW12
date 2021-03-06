package pl.coderslab.seleniumcourse.cucumber.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ZadZal1SignInPage {
    private WebDriver driver;

    public ZadZal1SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void FillOutTheSignInForm() {
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("alicja.testowa@wp.pl");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("tajne");
        WebElement signInBtnIcon = driver.findElement(By.id("submit-login"));
        signInBtnIcon.click();
    }

}

