package dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class DBcon{
	protected String dbms;
	protected String jarFile;
	protected String dbName;
	protected String userName;
	protected String password;
	protected String sid;
	protected String urlString;

	protected String driver;
	protected String serverName;
	protected int portNumber;
	protected Properties prop;
	protected Connection conn = null;
	
	protected void setProperties(String databasename,String fileName) {
		Logger logger = Logger.getLogger("defaultLogger");
		this.prop = new Properties();
		try {
			this.prop = new Properties();
			InputStream xmlFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			prop.loadFromXML(xmlFile);
		} catch (IOException e) {
			logger.severe("Could not read from database properties file");
		}

		dbms = prop.getProperty(databasename+"_dbms");
		jarFile = prop.getProperty(databasename+"_jar_file");
		driver = prop.getProperty(databasename+"_driver");
		dbName = prop.getProperty(databasename+"_database_name");
		userName = prop.getProperty(databasename+"_user_name");
		password = prop.getProperty(databasename+"_password");
		sid = prop.getProperty(databasename+"_sid");
		serverName = prop.getProperty(databasename+"_server_name");
		portNumber = Integer.parseInt(prop.getProperty(databasename+"_port_number"));
		logger.config("Server properties: "+prop);
		
	}

	public abstract Connection getConnection();
	public final void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}