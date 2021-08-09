package analysis;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreAnalysis {
    public WebDriver driver;
    public ArrayList<Product> products;

    ArrayList<String> elements;

    private static boolean sysout = true;

    public PreAnalysis(boolean sysout) throws InterruptedException {
        PreAnalysis.sysout = sysout;

        print("Logs are " + sysout);

        print("Pre-Analysis started...");
        products = new ArrayList<Product>();
        elements = new ArrayList<String>();

        openBrowser();
        login();
        collectProducts();

        print("Pre-Analysis Complete.");

    }

    private void collectProducts() {
        driver.navigate().to("https://checkout.hepsiburada.com/sepetim");

        print("");
        print("Collecting products...");
        for (WebElement element : driver.findElements(By.cssSelector(".product_name_3Lh3t a"))) {
            String link = element.getAttribute("href");
            elements.add(link);
            print(link + " added to queue");
        }
        print("Products collected: " + elements.size());

        print("");
        print("Iterating over products...");
        for (String element : elements) {

            print("Navigating to " + element);
            driver.navigate().to(element);

            String productName = driver.findElement(By.cssSelector("#product-name")).getText();
            String seller = driver.findElement(By.xpath("//span[contains(@class,'seller')]/span[2]/a")).getText();

            String category = parseCategory();

            Product product = new Product(productName, seller, category);
            products.add(product);

            print("");
            print(product.getProductName());
            print(product.getCategory());
            print(product.getSeller());
            print("=========================");
        }
        print("Products iterated: " + products.size());
        driver.navigate().back();
    }

    public String parseCategory() {
        for (WebElement breadcrumb : driver.findElements(By.cssSelector(".breadcrumbs span"))) {
            if (breadcrumb.getText().equals("iPhone iOS Telefonlar") || breadcrumb.getText().equals("Diğer Telefonlar")
                    || breadcrumb.getText().equals("Android Telefonlar")
                    || breadcrumb.getText().equals("Laptop & Notebook") || breadcrumb.getText().equals("Tablet")) {
                return "TECH";
            }
        }
        return "OTHER";
    }

    private void login() throws InterruptedException {
        driver.navigate().to("https://giris.hepsiburada.com/");
        print("Logging in...");

        driver.findElement(By.id("txtUserName")).sendKeys("email");
        driver.findElement(By.id("txtPassword")).sendKeys("password");

        Thread.sleep(2000);

        driver.findElement(By.id("btnLogin")).click();

        if (driver.getPageSource().contains("Beklenmeyen bir hata oluştu."))
            throw new RuntimeException("Hepsiburada did not accept login request.");

        WebDriverWait wait = new WebDriverWait(driver, 20000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("desktopOldAutosuggestTheme-input")));
        print("Logged in.");

    }

    private void openBrowser() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void print(String message) {
        if (sysout)
            System.out.println(message);
    }

}
