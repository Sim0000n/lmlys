package team.area237.lmlys.model.request;

import team.area237.lmlys.model.entity.Cart;

public class UpdateCartResquest {
    private Cart[] carts;

    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }
}
