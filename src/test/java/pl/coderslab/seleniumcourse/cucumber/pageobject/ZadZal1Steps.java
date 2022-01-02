package pl.coderslab.seleniumcourse.cucumber.pageobject;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZadZal1Steps {
    private WebDriver driver;
    private ZadZal1SignInPage zadZal1SignInPage;
    private ZadZal1YourAccPage zadZal1YourAccPage;
    private ZadZal1YourAddressesPage zadZal1YourAddressesPage;
    private ZadZal1AddressesData zadZal1AddressesData;
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
    @And("^New address form filled out with: (.*), (.*), (.*), (.*), (.*), (.*) and saved$")
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


    }

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
    }
}

//    @And("^Create an account button clicked$")
//    public void clickCreateAccount() {
  //      loginPage.clickCreateAnAccount();
  //  }

 //   @And("^Form filled with data: (.*), (.*), (.*), (.*), (.*), (.*)$")
 //   public void fillForm(String firstName, String lastName, boolean isMr, String password, boolean isNewsletter, boolean isSpecialOffers) {
     //   UserData userData = new UserData()
            //    .setFirstName(firstName)
           //     .setLastName(lastName)
           //     .setMr(isMr)
           //     .setEmail("")
           //     .setPassword(password)
          //      .setNewsletter(isNewsletter)
            //    .setGetSpecialOffers(isSpecialOffers);

     //   this.createAnAccountPage = new CreateAnAccountPage(driver);
     //   assertTrue(createAnAccountPage.areMandatoryInputsAccessible(), "element not interactable!");
     //   assertEquals(randomEmail, createAnAccountPage.getEmail());
     //   createAnAccountPage.fillForm(userData);
 //   }

 //   @And("^Register button clicked$")
  //  public void clickRegisterButton() {
    //    createAnAccountPage.clickRegister();
  //  }

 //   @Then("^User account creation success confirmation panel displayed$")
 //   public void accountCreationConfirmed() {
    //    MyAccountPage myAccountPage = new MyAccountPage(driver);
   //     assertTrue(myAccountPage.isAccountCreationConfirmed());
 //   }

 //   @And("Take screenshot")
  //  public void takeScreenshot() throws IOException {
    //    TakesScreenshot screenshot = (TakesScreenshot)driver;
////Take screenshot (will be saved in default location) and automatically removed after test
     //   File tmpScreenshot = screenshot.getScreenshotAs(OutputType.FILE);
////Copy the screenshot to desired location
////Path to the location to save screenshot
////(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        //String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
       // Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "registration-success-evidence-12-"+currentDateTime+".png"));
   // }

  //  @And("Close browser")
  //  public void closeBrowser() {
    //    this.driver.quit();
  //  }
//}

