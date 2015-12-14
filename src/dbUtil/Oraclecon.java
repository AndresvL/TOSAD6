package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class Oraclecon extends DBcon {
	
	public Oraclecon(String databasename){
		super();
		super.setProperties(databasename,"/xml/database/oracle-properties.xml");
	}
	public final Connection getConnection() {
		Logger logger = Logger.getLogger("defaultLogger");
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", super.userName);
		connectionProps.put("password", super.password);
	
		String currentUrlString = null;
			currentUrlString = "jdbc:" + super.dbms + ":thin:@" + super.serverName + ":" + super.portNumber + ":" + super.sid;
			System.out.println(currentUrlString);
			//				  jdbc:oracle:thin:@" + host + ":" + port + ":" + sid, user, password);
			// String test = "jdbc:oracle:thin:@145.89.21.30:8521:cursus01";
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());			
				conn = DriverManager.getConnection(currentUrlString,connectionProps);
				this.urlString = currentUrlString + this.dbName;
				conn.setCatalog(this.dbName);
			} catch (SQLException e) {
				this.closeConnection();;				
			} 
		logger.info("Connected to oracle database");
		return conn;
	}
	
}
