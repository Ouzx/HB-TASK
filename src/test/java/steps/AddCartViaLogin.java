package steps;

import io.cucumber.java.en.Given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pageFactory.*;

public class AddCartViaLogin {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	SearchPage sp;
	ProductPage pp;

	@Given("browser is open")
	public void browser_is_open() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@And("navigate to hepsiburada")
	public void user_is_on_login_page() throws InterruptedException {
		driver.navigate().to("https://www.hepsiburada.com/");
	}

	@When("user logins to the hepsiburada")
	public void user_enters_username_and_password() throws InterruptedException {
		hp = new HomePage(driver);
		hp.GetLoginPage();

		lp = new LoginPage(driver);
		lp.Login("email", "password");
	}

	// Eger sistem botu kabul etmezse ya da hatali kullanici girisi yapilirsa burasi hata verir.
	@And("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
	    hp.CheckDriverWhereIs();
	}
	
	@And("^user searches for (.*)$") 
	public void user_searches_for_prod(String prod) throws InterruptedException {
		hp.Search(prod);
	}

	@And("pick one from the list")
	public void pick_one_from_the_list() {
		sp = new SearchPage(driver);
		sp.CheckProducts();
	}

	@And("add to cart")
	public void add_to_cart() {
		pp = new ProductPage(driver);
		pp.AddToCart();
	}
	
	@And("close recommendation")
	public void close_recommendation() {
		pp.closeRecommendation();
	}
	
	@And("add from different store")
	public void add_from_different_store() {
		pp.FromDifferentStore();
	}
	

	@Then("user have products from different stores")
	public void user_have_products_from_different_stores(){
		driver.close();
		driver.quit();
	}
}
