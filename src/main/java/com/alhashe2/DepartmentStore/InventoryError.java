package com.alhashe2.DepartmentStore;

public class InventoryError extends Exception {

    private static final long serialVersionUID = 1L;


    public InventoryError() {
        super();
    }

    public InventoryError(String message) {
        super(message);
    }

    public InventoryError(String message, Throwable cause) {
        super(message, cause);
    }

    public InventoryError(Throwable cause) {
        super(cause);
    }

    public InventoryError(String message, Throwable cause, boolean enableSuppression, boolean writeableStackTrace) {
        super(message, cause, enableSuppression, writeableStackTrace);
    }

}
