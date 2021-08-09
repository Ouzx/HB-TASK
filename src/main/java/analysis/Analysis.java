package analysis;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Analysis {
    WebDriver driver;
    ArrayList<Product> products;
    ArrayList<Group> groups;

    private static boolean sysout = true;

    public Analysis(WebDriver driver, ArrayList<Product> products, boolean sysout) throws InterruptedException {
        this.driver = driver;
        this.products = products;
        Analysis.sysout = sysout;
        groups = new ArrayList<Group>();
        print("Anaysis initialized...");

        driver.get("https://checkout.hepsiburada.com/teslimat");

        CollectCart();
        CompareGroups();

        print("Analysis finished");
        Thread.sleep(3000);
        closeBrowser();
    }

    public void CollectCart() {
        print("Collecting cart...");
        print("");
        print("Grouping started...");
        print("");
        for (WebElement productList : driver.findElements(By.className("group_3mEiZ"))) {
            print("=============");
            boolean isJet = false;
            String deliveryType = "";
            String seller = "";
            String shippingDate = "";
            String deliveryDate = "";
            String category = "";

            deliveryType = productList.findElement(By.cssSelector("label div.name_vHGRK")).getText();
            print("Delivery type: " + deliveryType);

            if (!deliveryType.equals("Anında Teslimat")) {
                deliveryDate = productList.findElement(By.cssSelector("label div.delivery_date_1Mp9g span")).getText();
                try {
                    if (productList.findElement(By.cssSelector("label div.jetDeliveryText_oiUMC")) != null)
                        isJet = true;
                } catch (Exception e) {
                }
            } else
                deliveryDate = "x";
            print("Delivery date: " + deliveryDate);

            seller = productList.findElement(By.cssSelector("div.title_B83hJ span")).getText();
            print("Seller: " + seller);
            print("-------------");
            for (WebElement product : productList.findElements(By.cssSelector(".product_list_51yG5 li"))) {
                String productName = product.findElement(By.cssSelector(".name_vHGRK")).getText();
                if (!deliveryDate.equals("x")) {
                    String sd = product.findElement(By.cssSelector("div.shipping_date_1cUA5")).getText();
                    if (shippingDate.isEmpty())
                        shippingDate = sd;
                    else if (!shippingDate.equals(sd))
                        throw new RuntimeException("Different shipping dates");
                } else
                    shippingDate = "x";
                print("Product: " + productName);
                print("Shipping date: " + shippingDate);

                for (Product p : products) {
                    if (p.getProductName().equals(productName)) {
                        String cat = p.getCategory();
                        if (category.isEmpty())
                            category = cat;
                        else if (!category.equals(cat))
                            throw new RuntimeException("Different categories");
                        else
                            print("Categories are correct.");

                        if (!p.getSeller().equals(seller))
                            throw new RuntimeException("Different sellers");
                        else
                            print("Sellers are correct.");
                    }
                }
            }
            print("-------------");
            groups.add(new Group(isJet, seller, deliveryType, shippingDate, deliveryDate, category));
            print("Products added to group without any problem.");
            print("=============");
            print("");
        }
    }

    public void CompareGroups() {
        print("Comparing groups...");
        for (Group g : groups) {
            for (Group g2 : groups) {
                if (!g.equals(g2)) {
                    if (g.getCategory().equals(g2.getCategory()) && g.getSeller().equals(g2.getSeller())
                            && g.getDeliveryDate().equals(g2.getDeliveryDate())
                            && g.getShippingDate().equals(g2.getShippingDate()) && g.isJet() == g2.isJet()
                            && g.getDeliveryType().equals(g2.getDeliveryType())) {
                        throw new RuntimeException("Same parameters different groups");
                    }
                }
            }
        }
        print("Groups are correct!");
    }

    private void closeBrowser() {
        driver.close();
        driver.quit();
    }

    private void print(String message) {
        if (sysout)
            System.out.println(message);
    }
}
