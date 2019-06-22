package team.area237.lmlys.entity;

public class Order {
    private int userID;
    private int goodID;
    //0：下订单未付款; 1:下订单已付款; 2：已发货； 3：订单完成
    private int status;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getGoodID() {
        return goodID;
    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
