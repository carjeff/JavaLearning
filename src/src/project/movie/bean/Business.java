package project.movie.bean;

/**
 * @author Jason
 * @date 2022/7/13 11:25
 * @Description
 */
public class Business extends User{
    private String shopName;
    private String address;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
