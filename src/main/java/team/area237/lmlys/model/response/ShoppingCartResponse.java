package team.area237.lmlys.model.response;

import team.area237.lmlys.model.entity.Cart;

public class ShoppingCartResponse {
    private Cart[] carts;

    public Cart[] getCarts() {
        return carts;
    }

    public void setCarts(Cart[] carts) {
        this.carts = carts;
    }
}
