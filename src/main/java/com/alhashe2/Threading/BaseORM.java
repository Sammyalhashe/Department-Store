package com.alhashe2.Threading;

import java.util.List;

public abstract class BaseORM implements Identifiable {
//	
//	public BaseORM(List<Object> fields) {
//		
//	}
	
	private String id;
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public static BaseORM create(String table, List<Object> fields) {
		System.out.println("Here are the fields: " + fields);
		if (table.equals("sammy_fruits")) {
			return Fruit.create(fields);
		}
		return null;
		
	}

}

