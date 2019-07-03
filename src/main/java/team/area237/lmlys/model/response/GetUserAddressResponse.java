package team.area237.lmlys.model.response;

public class GetUserAddressResponse {
    //地址为空，则返回true
    private boolean empty;

    //省
    private String province;

    //市
    private String city;

    //街道地址
    private String home;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
