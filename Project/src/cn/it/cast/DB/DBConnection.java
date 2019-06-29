package cn.it.cast.DB;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBConnection {
	
	private static DBConnection dbConnection;
	private static ComboPooledDataSource dataSource;
	
	static {
		dbConnection = new DBConnection();
	}
	
	public DBConnection() {
		try {
			dataSource = new ComboPooledDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("123456");
			dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/kechengsheji?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true");//数据库名字
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setMinPoolSize(2);
			dataSource.setMaxPoolSize(10);
			dataSource.setMaxStatements(50);
			dataSource.setMaxIdleTime(60);
		}catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
	}


public final static DataSource getDataSource() {
	return dataSource;
}

public final Connection getConnection() {
	try {
		return dataSource.getConnection();
	}catch (SQLException e) {
		throw new RuntimeException("无法从数据源获取连接",e);
		
	}
}

}
