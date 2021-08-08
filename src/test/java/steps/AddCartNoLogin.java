package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import pageFactoryNoLogin.*;

public class AddCartNoLogin {

    WebDriver driver;
    HomePage hp;

    public void openBrowser() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
    }

    @Given("browser ready")
    public void browser_is_open() {
        openBrowser();
        if (driver == null)
            throw new IllegalStateException("Browser is not open");
    }

    @And("navigate user to hepsiburada")
    public void user_is_on_login_page() throws InterruptedException {
        driver.navigate().to("https://www.hepsiburada.com/");
    }

    @When("user selects category")
    public void user_selects_cateory() {
        hp = new HomePage(driver);
        hp.SelectCategory();
    }

    @And("selects subcategory")
    public void selects_subcategory() {
        hp.SelectSubCategory();
    }

    @And("selects filter")
    public void selects_filter() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("adds product to cart")
    public void adds_product_to_cart() {
        closeBrowser();
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
