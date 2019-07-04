package team.area237.lmlys.model.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    private int goodsId;
    private int count;
    private int stock;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}
