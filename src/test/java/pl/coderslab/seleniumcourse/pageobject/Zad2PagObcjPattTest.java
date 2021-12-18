package pl.coderslab.seleniumcourse.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.UUID;

public class Zad2PagObcjPattTest {
    WebDriver driver;

    @Test

    public void searchHotelByName() {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignIn();

        LoginPage loginPage = new LoginPage(driver);
        String email = "email.testowy@wp.pl";
        loginPage.fillEmailToRegister(email);
        String password = "random";
        loginPage.fillPasswordToRegister(password);
        loginPage.clickSignInRegistered();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.BackToLandingPage();
        LandingPage lp = new LandingPage(driver);
        lp.searchHotel("","","","");

    }
        @BeforeEach
        public void beforeEach() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }

}


//new user na potrzeby testowe:
// email: email.testowy@wp.pl
//Gender: Mrs.
//firstName: Alicja
//lastName: Testowa
//password: random
//dateOfBirth: 1 January 2021
