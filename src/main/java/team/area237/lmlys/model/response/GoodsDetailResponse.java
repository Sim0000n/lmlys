package team.area237.lmlys.model.response;

public class GoodsDetailResponse {
    //商品图片url字符串数组，有序的
    private String[] imgs;

    //商品的描述
    private String content;

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs(String[] imgs) {
        this.imgs = imgs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
