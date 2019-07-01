package team.area237.lmlys.model.response;

public class GoodsGeneralResponse {
    //商品标题
    private String title;

    //商品价格
    private int price;

    //商品图片url
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
