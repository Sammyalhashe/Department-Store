package com.alhashe2.DepartmentStore;

import java.util.UUID;

public class Item {
    private UUID productUuid;
    private String name;
    private int productQuantity;

    /**
     * Private constructor that creates a product with zero quantity
     * @param productName
     */
    private Item(String productName) {
        this.setProductUuid(UUID.randomUUID());
        this.setName(productName);
        this.setProductQuantity(0);
    }

    /**
     * Private constructor that takes both name and quantity
     * @param productName
     * @param productQuantity
     */
    private Item(String productName, int productQuantity) {
        this(productName);
        this.setProductQuantity(productQuantity);
    }


    /**
     * Private constructor that takes name, quantity, and UUID
     * @param productName
     * @param productQuantity
     * @param id
     */
    private Item(String productName, int productQuantity, UUID id) {
        this(productName, productQuantity);
        this.productUuid = id;
    }

    /**
     * Getter for productQuantity
     * @return productQuantity
     */
    public int getProductQuantity() {
		return productQuantity;
	}

    /**
     * setter for productQuantity
     * @param productQuantity
     */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

    /**
     * Updates the product quantity
     * @param amt { Value to update }
     * @return int
     */
    public int updateProductQuantity(int amt) {
        int quantity = this.getProductQuantity();
        this.setProductQuantity(quantity - amt);
        return this.getProductQuantity();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getProductUuid() {
		return productUuid;
	}

	public void setProductUuid(UUID productUuid) {
		this.productUuid = productUuid;
	}

	/**
     * Static factory that returns an Item of name specified
     * @param name
     * @return Item
     */
    public static Item ofName(String name) {
        return new Item(name);
    }

    /**
     * Static factory that returns an Item of name and quantity specified
     * @param name
     * @param quantity
     * @return Item
     */
    public static Item ofNameWithQuantity(String name, int quantity) {
        return new Item(name, quantity);
    }

    public static Item ofNameWithQuantityAndID(String name, int quantity, UUID id) {
        return new Item(name, quantity, id);
    }

}
