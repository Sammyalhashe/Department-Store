package com.alhashe2.Threading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO<T extends BaseORM> implements CRUD<BaseORM>, AutoCloseable {
	private Connection connection;
	private String table;
	private String primaryKey;

	public DAO(String table, String primaryKey) throws ClassNotFoundException, SQLException {
		this.table = table;
		this.primaryKey = primaryKey;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// don't hard code things
		String connectionString = "jdbc:oracle:thin:@88.211.122.42:1521:oradb1";
		String uid = "delegate";
		String pwd = "pass";
		Connection connection = DriverManager.getConnection(connectionString, uid, pwd);
		this.connection = connection;
        System.out.println("Connection created");
	}

	public T read(String id) throws SQLException {
		if (this.connection.isClosed()) {
			throw new IllegalStateException("connection is gone, cannot proceed...");
		}
		T t = null;
		Statement stmt = connection.createStatement();
		String query = 
			"Select * from " 
					+ this.getTable() 
					+ " where " 
					+ this.getPrimaryKey() 
					+ "='"
					+ id
					+"'";
        System.out.println("Query Created");
		if (!stmt.execute(query)) {
			String msg = 
				"Cannot retrieve record for id " + id + " in class" + t.getClass();
			throw new IllegalStateException(msg);
		}
        System.out.println("Query Executed");
		ResultSet rs = stmt.getResultSet();
		final ResultSetMetaData meta = rs.getMetaData();
		final int fieldCount = meta.getColumnCount();
		rs.next();	
		List<Object> fields = new ArrayList<>();
		for (int field = 1; field <= fieldCount; ++field) {
		    fields.add(rs.getObject(field));
		}
		// warning for class cast
		return (T) BaseORM.create(this.getTable(), fields);
	}

	private String getPrimaryKey() {
		return this.primaryKey;
	}

	private String getTable() {
		return this.table;
	}

	@Override
	public void close() throws Exception {
		this.connection.close();
	}
}

