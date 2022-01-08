package pl.coderslab.seleniumcourse.cucumber.pageobject;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZadZal1Steps {
    private WebDriver driver;
    private ZadZal1SignInPage zadZal1SignInPage;
    private ZadZal1YourAccPage zadZal1YourAccPage;
    private ZadZal1YourAddressesPage zadZal1YourAddressesPage;

    private ZadZal1CreateAddressPage zadZal1CreateAddressPage;


    @Given("^Landing page (.*) opened in browser$")
    public void landingPageOpened(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get(url);
    }

    @When("^Sign in button pressed$")
    public void goToSignIn() {
        WebElement signInIcon = driver.findElement(By.className("user-info"));
        signInIcon.click();
    }

    @And("^Username and password entered in the form fields and 'Sign in' button pressed$")
    public void fillOutEmailAndPassword() {
        this.zadZal1SignInPage = new ZadZal1SignInPage(driver);
        zadZal1SignInPage.FillOutTheSignInForm();
    }

    @And("^Section 'Addresses' on user account page selected$")
    public void chooseAddressesSection() {
        this.zadZal1YourAccPage = new ZadZal1YourAccPage(driver);
        zadZal1YourAccPage.GoToAddresses();
    }

    @And("^Section '\\+ Create new address' chosen and pressed$")
    public void goToAddressCreation() {
        this.zadZal1YourAddressesPage = new ZadZal1YourAddressesPage(driver);
        zadZal1YourAddressesPage.CreateNewAddress();
    }

    @And("^New address form filled out with: (.*), (.*), (.*), (.*), (.*), (.*) then checked and saved$")
    public void fillTheAddressesForm(String alias, String address, String zip, String city, String country, String phone) {
        ZadZal1AddressesData zadZal1AddressesData = new ZadZal1AddressesData()
                .setNewAlias(alias)
                .setNewAddress(address)
                .setZip(zip)
                .setCity(city)
                .setCountry(country)
                .setPhone(phone);


        this.zadZal1CreateAddressPage = new ZadZal1CreateAddressPage(driver);
        zadZal1CreateAddressPage.fillAddressesForm(zadZal1AddressesData);

        assertEquals(alias, zadZal1AddressesData.getNewAlias());
        assertEquals(address, zadZal1AddressesData.getNewAddress());
        assertEquals(zip, zadZal1AddressesData.getZip());
        assertEquals(city, zadZal1AddressesData.getCity());
        assertEquals(country, zadZal1AddressesData.getCountry());
        assertEquals(phone, zadZal1AddressesData.getPhone());

        zadZal1CreateAddressPage.catchExceptionToSave();

    }

    @And("^New address deleted$")
    public void deleteTheAddress() {
     //   zadZal1YourAddressesPage.DeleteNewAddress();
    }

    @Then("^New address deletion confirmed$")
    public void verifyDeletion() {
     //   zadZal1YourAddressesPage.CheckIfAddrDeleted();

    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }
}


