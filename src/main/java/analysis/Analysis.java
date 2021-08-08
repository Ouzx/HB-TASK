package analysis;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class Analysis {
    WebDriver driver;
    ArrayList<Product> products;

    private static boolean sysout = true;

    public Analysis(WebDriver driver, ArrayList<Product> products) {
        this.driver = driver;
        this.products = products;
        print("Anaysis started...");

    }

    private void print(String message) {
        if (sysout)
            System.out.println(message);
    }
}
