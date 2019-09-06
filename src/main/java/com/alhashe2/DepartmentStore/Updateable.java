package com.alhashe2.DepartmentStore;

import java.util.UUID;

public interface Updateable {
    public void updateProductQuantity(UUID productID, int amt) throws InventoryError;
}
