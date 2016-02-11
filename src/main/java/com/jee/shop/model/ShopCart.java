package com.jee.shop.model;

import java.util.List;

/**
 * Created by ZSt on 2016/2/11.
 */
public class ShopCart {
    private List<Goods> goodses;

    public List<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(List<Goods> goodses) {
        this.goodses = goodses;
    }
}
