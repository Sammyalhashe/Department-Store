package com.alhashe2.Threading;

import java.sql.SQLException;


public interface CRUD<T> {
	
	public T read(String id) throws SQLException;
}
