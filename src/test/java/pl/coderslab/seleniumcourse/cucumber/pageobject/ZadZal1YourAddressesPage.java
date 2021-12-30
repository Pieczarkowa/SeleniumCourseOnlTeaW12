package pl.coderslab.seleniumcourse.cucumber.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ZadZal1YourAddressesPage {
   private WebDriver driver;

    public ZadZal1YourAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void CreateNewAddress() {
        WebElement createNewBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/a/span"));
        createNewBtn.click();
    }

    }

