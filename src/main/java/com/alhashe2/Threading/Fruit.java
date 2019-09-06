package com.alhashe2.Threading;

import java.math.BigDecimal;
import java.util.List;

public class Fruit extends BaseORM implements Identifiable {

	private String productName;
	private BigDecimal quantity;

	public Fruit(String id, String productName, BigDecimal quantity) {
		this.setID(id);
		this.setProductName(productName);
		this.setQuantity(quantity);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity2) {
		this.quantity = quantity2;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + this.getID() + ", quantity=" + quantity + "]";
	}

	public static Fruit create(List<Object> fields) {
		String name = String.valueOf(fields.get(0));
		String productName = (String) fields.get(1);
		BigDecimal quantity = (BigDecimal) fields.get(2);
		return new Fruit(name, productName, quantity);
	}

}

