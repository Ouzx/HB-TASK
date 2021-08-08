package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import pageFactoryLogin.*;

// Multi threading oldugunda @before ve @after hooklari bug olusturuyor. Bundan dolayi hook kullanmiyorum.
public class AddCartLogin {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	SearchPage sp;
	ProductPage pp;

	@Before
	public void setProps() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
	}

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

	@Given("browser is open")
	public void browser_is_open() {
		openBrowser();
		if (driver == null)
			throw new IllegalStateException("Browser is not open");
	}

	@And("navigate to hepsiburada")
	public void user_is_on_login_page() {
		driver.navigate().to("https://www.hepsiburada.com/");
	}

	@When("user logins to the hepsiburada")
	public void user_enters_username_and_password() throws InterruptedException {
		hp = new pageFactoryLogin.HomePage(driver);
		hp.GetLoginPage();

		lp = new LoginPage(driver);
		lp.Login("email", "password");
	}

	// Eger sistem botu kabul etmezse ya da hatali kullanici girisi yapilirsa burasi
	// hata verir.
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

	@Then("add from different store")
	public void add_from_different_store() {
		pp.FromDifferentStore();
		pp.CheckCart();
		closeBrowser();
	}
}
