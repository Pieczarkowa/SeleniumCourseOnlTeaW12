package pl.coderslab.seleniumcourse.cucumber.pageobject;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZadZal1YourAddressesPage {
    private WebDriver driver;

    public ZadZal1YourAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CreateNewAddress() {
        WebElement createNewBtn = driver.findElement(By.xpath("//span[text()='Create new address']"));
        createNewBtn.click();


    }

    public void DeleteNewAddress() {
        WebElement deleteAddrBtn = driver.findElement(By.xpath("//span[text()='Delete']"));
        deleteAddrBtn.click();


    }

    public void CheckIfAddrDeleted() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        String successMessageText = successMessage.getText();
        assertEquals("Address successfully deleted!", successMessageText);


    }
}


