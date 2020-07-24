package com.inetBanking.TestCases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TC_DataBaseTesting_004 {
	
public static Statement stmt;
public static Connection con;
public static Logger logger;
	
@BeforeTest
public void LDatabaseTest() throws SQLException {
	// TODO Auto-generated method stub
			//Step1:
			try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL2","scott","tiger");
			//Step2:
			stmt = con.createStatement();
			
			}
			catch (Exception e){
				e.printStackTrace();
			}
			logger = Logger.getLogger("TC_DataBaseTesting_004");
			PropertyConfigurator.configure("log4j.properties");
}

@Test
public void test() {
       try{
			//Step3: Execute SQL statements
			//String s="INSERT INTO FR_USERS VALUES ('venkata','Reddy')";
			String s = "select empno,ename from emp";
			
			ResultSet rs = stmt.executeQuery(s);
			logger.info("Oracle Connection is Established");
			logger.info("Data is retrived from DB");
			while(rs.next()) {
				
				String username = rs.getString("empno");
				String password = rs.getString("ename");
				
				
				System.out.println(username+"  "+password);
				
			}
       }
			catch(Exception e) {
				e.printStackTrace();
			}
}
@AfterTest
public void tearDown() throws Exception {
// Close DB connection
if (con != null) {
	logger.info("Connection is closed");
	con.close();
}
}
}
			


