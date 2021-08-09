// import java.util.ArrayList;
// import java.util.concurrent.TimeUnit;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.By;

import analysis.*;

public class HBTASK {
    public static void main(String[] args) throws InterruptedException {

        PreAnalysis preAnalysis = new PreAnalysis(true);
        new Analysis(preAnalysis.driver, preAnalysis.products, true);

        // #region Demo Data
        // ArrayList<Product> products = new ArrayList<Product>();

        // products.add(new Product("Çaykur Tiryaki 1000 gr Dökme Çay", "OTHER",
        // "Hepsiburada"));
        // products.add(new Product("Netflix Hediye Kartı", "OTHER", "Hepsiburada"));
        // products.add(new Product("iPhone 11 64 GB", "TECH", "Hepsiburada"));
        // products.add(new Product("Apple Watch SE 44mm GPS Space Gray Alüminyum Kasa
        // ve Siyah Spor Kordon MYDT2TU/A",
        // "OTHER", "Hepsiburada"));
        // products.add(new Product("Apple AirPods 2. Nesil Kulaklık MV7N2TU/A (Apple
        // Türkiye Garantili)", "OTHER",
        // "Hepsiburada"));
        // products.add(new Product("Apple iPad 8. Nesil 32 GB 10.2\" WiFi Tablet -
        // MYL92TU/A", "TECH", "Hepsiburada"));
        // products.add(new Product(
        // "Apple MacBook Air M1 Çip 8GB 256GB SSD macOS 13\" QHD Taşınabilir Bilgisayar
        // Gümüş MGN93TU/A", "TECH",
        // "Hepsiburada"));
        // products.add(new Product("Samsung Galaxy A21s 64 GB (Samsung Türkiye
        // Garantili)", "TECH", "Hepsiburada"));
        // products.add(new Product("Sony Playstation 5 Oyun Konsolu (Eurasia
        // garantili)", "OTHER", "Hepsiburada"));
        // products.add(new Product("Grundig GDF 6503 D 6 Program (14 Kişilik) Bulaşık
        // Makinesi", "OTHER", "Hepsiburada"));

        // String projectPath = System.getProperty("user.dir");
        // System.setProperty("webdriver.chrome.driver", projectPath +
        // "/src/test/resources/drivers/chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        // driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // driver.manage().window().maximize();

        // driver.navigate().to("https://giris.hepsiburada.com/");
        // print("Logging in...");

        // driver.findElement(By.id("txtUserName")).sendKeys("oguzhankandakoglu@gmail.com");
        // driver.findElement(By.id("txtPassword")).sendKeys("Kyrill123.");

        // Thread.sleep(2000);

        // driver.findElement(By.id("btnLogin")).click();

        // if (driver.getPageSource().contains("Beklenmeyen bir hata oluştu."))
        // throw new RuntimeException("Hepsiburada did not accept login request.");

        // Thread.sleep(2000);
        // print("Logged in.");

        // Create a new Analysis
        /* Analysis analysis = */
        // #endregion

    }

}
