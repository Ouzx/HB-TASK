package analysis;

public class Product {

    public Product(String productName, String category, String seller) {
        this.setProductName(productName);
        this.setSeller(seller);
        this.setCategory(category);
    }

    private String productName;
    private String category;
    private String seller;

    public String getSeller() {
        return seller;
    }

    private void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    String getProductName() {
        return productName;
    }

    private void setProductName(String productName) {
        this.productName = productName;
    }

}