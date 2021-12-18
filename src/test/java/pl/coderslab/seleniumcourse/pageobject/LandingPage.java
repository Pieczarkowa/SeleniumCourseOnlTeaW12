package pl.coderslab.seleniumcourse.pageobject;

// this is our first implementation of Page Object Pattern

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignIn() {
        WebElement signInBtn = driver.findElement(By.className("hide_xs"));
        signInBtn.click();
    }
        //zad 2
        public void searchHotel(String location, String name, String checkinDate, String checkoutdDate ) {
            WebElement hotelLocation = driver.findElement(By.id("hotel_location"));
            hotelLocation.sendKeys("Warsaw");
            WebElement hotelField = driver.findElement(By.className("arrow_span"));
            hotelField .click();
            WebElement hotelName = driver.findElement(By.className("hotel_name"));
            hotelName .click();
        }
    //koniec zad 2

}