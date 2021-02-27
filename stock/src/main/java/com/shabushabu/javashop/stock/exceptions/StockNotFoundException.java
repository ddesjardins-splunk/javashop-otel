package com.shabushabu.javashop.stock.exceptions;

public class StockNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public StockNotFoundException() {
    }

    public StockNotFoundException(String message) {
        super(message);
    }

    public StockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
