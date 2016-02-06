package com.jee.shop.model;

/**
 * Created by ZSt on 2016/2/6.
 */
public class ShopException extends RuntimeException {

    public ShopException() {
        super();
    }

    public ShopException(String message) {
        super(message);
    }

    public ShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopException(Throwable cause) {
        super(cause);
    }
}
