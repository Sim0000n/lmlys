package team.area237.lmlys.model.response;

public class FinishBillResponse {
    //0:结账成功
    //1：结账失败，库存不足
    //2:结账失败，其他原因
    private int result;

    //库存不足商品清单
    private int[] soldUpGoods;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int[] getSoldUpGoods() {
        return soldUpGoods;
    }

    public void setSoldUpGoods(int[] soldUpGoods) {
        this.soldUpGoods = soldUpGoods;
    }
}
