package pl.coderslab.seleniumcourse.cucumber.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZadZal1YourAccPage {
    private WebDriver driver;

    public ZadZal1YourAccPage(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToAddresses() {
        WebElement addressesField = driver.findElement(By.id("addresses-link"));
        addressesField.click();
    }

}
