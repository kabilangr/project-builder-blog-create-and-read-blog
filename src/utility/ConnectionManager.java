package utility;

import java.sql.*;
import java.util.*;

import java.io.*;

public class ConnectionManager
{
	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException
	{
		Properties prop=null;
		prop=loadPropertiesFile();
		final String url=prop.getProperty("url");
		final String driver=prop.getProperty("driver");
		Class.forName(driver);
		Connection ob=null;
		ob=DriverManager.getConnection(url);
		if(ob!=null)
			System.out.println("Established");
		return ob;
	}
	public Properties loadPropertiesFile() throws IOException
	{
		Properties prop=new Properties();
		InputStream in=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
}
