package analysis;

public class Group {

    private boolean isJet;
    private String seller;
    private String deliveryType;
    private String shippingDate;
    private String deliveryDate;
    private String category;

    public Group(boolean isJet, String seller, String deliveryType, String shippingDate, String deliveryDate,
            String category) {
        this.setJet(isJet);
        this.setSeller(seller);
        this.setDeliveryType(deliveryType);
        this.setShippingDate(shippingDate);
        this.setDeliveryDate(deliveryDate);
        this.setCategory(category);
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    private void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    private void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    private void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getSeller() {
        return seller;
    }

    private void setSeller(String seller) {
        this.seller = seller;
    }

    public boolean isJet() {
        return isJet;
    }

    private void setJet(boolean isJet) {
        this.isJet = isJet;
    }

}
