package com.alhashe2.DepartmentStore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Inventory implements Updateable {

    private Map<UUID, Item> inventoryMap;

    /*
     * private constructor for empty inventory
     */
    private Inventory() {
        this.setInventoryMap(new HashMap<>());
    }

    /**
     * Getter for inventoryMap
     * @return Map<UUID, Item>
     */
    public Map<UUID, Item> getInventoryMap() {
        return inventoryMap;
    }


    /**
     * Setter for inventoryMap
     * @param inventoryMap
     */
    public void setInventoryMap(HashMap<UUID, Item> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }


    /**
     * Static factory for creating an empty inventory
     * @return Inventory
     */
    public static Inventory empty() {
        return new Inventory();
    }

    /**
     * Builds a new inventory from an array of productNames
     * @param productNames
     * @return Inventory
     */
    public static Inventory fromProductNames(String[] productNames) {
        Inventory inventory = empty();
        for (String name : productNames) {
            inventory.addItem(name);
        }

        return inventory;
    }


    /**
     * Builds a new inventory from an array of Items
     * @param items
     * @return Inventory
     */
    public static Inventory fromItems(Item[] items) throws InventoryError {
        Inventory inventory = empty();
        for (Item item : items) {
                inventory.addItem(item.getName(), item.getProductQuantity(), item.getProductUuid());
        }
        return inventory;
    }

    /**
     * Adds item to a HashMap with default quantity
     * @param name
     * @return UUID { product UUID }
     */
    public UUID addItem(String name) {
        Item item = Item.ofName(name);
        this.inventoryMap.put(item.getProductUuid(), item);
        return item.getProductUuid();
    }


    /**
     * Adds item to HashMap with quantity
     * @param name
     * @param quantity
     * @return UUID { product UUID }
     */
    public UUID addItem(String name, int quantity) {
        Item item = Item.ofNameWithQuantity(name, quantity);
        this.inventoryMap.put(item.getProductUuid(), item);
        return item.getProductUuid();
    }

    /**
     * Adds item to HashMap with name, quantity, and specific id
     * @param name
     * @param quantity
     * @param id
     * @return UUID { product UUID }
     * @throws InventoryError
     */
    public UUID addItem(String name, int quantity, UUID id) throws InventoryError {
        Item item = Item.ofNameWithQuantityAndID(name, quantity, id);
        if (this.getInventoryMap().containsKey(id)) {
            String msg = "Inventory already contains item with id: " + id.toString();
            throw new InventoryError(msg);
        }

        this.inventoryMap.put(id, item);
        return id;
    }

    @Override
    public void updateProductQuantity(UUID productID, int amt) throws InventoryError {
        if (this.inventoryMap.containsKey(productID)) {
            this.inventoryMap.get(productID).updateProductQuantity(amt);
        } else {
            String msg = "Product does not exist";
            throw new InventoryError(msg);
        }        
    }

}
