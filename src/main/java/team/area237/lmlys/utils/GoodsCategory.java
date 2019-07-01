package team.area237.lmlys.utils;

public enum GoodsCategory {
    book("图书音像"),
    sport("运动健康"),
    beauty("个护美妆"),
    digit("电子产品"),
    drink("酒水饮料");
    private String category;
    GoodsCategory(String category){
        this.category=category;
    }

    public String getCategory() {
        return category;
    }
}
