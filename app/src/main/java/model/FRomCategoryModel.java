package model;

/**
 * Created by wolfsoft4 on 22/8/18.
 */

public class FRomCategoryModel {
    Integer img1, img2;
    String offer, price,shoes;

    public Integer getImg1() {
        return img1;
    }

    public void setImg1(Integer img1) {
        this.img1 = img1;
    }

    public Integer getImg2() {
        return img2;
    }

    public void setImg2(Integer img2) {
        this.img2 = img2;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public FRomCategoryModel(Integer img1, Integer img2, String offer, String price, String shoes) {
        this.img1 = img1;
        this.img2 = img2;
        this.offer = offer;
        this.price = price;
        this.shoes = shoes;
    }
}
