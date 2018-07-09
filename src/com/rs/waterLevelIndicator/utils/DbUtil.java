package com.rs.waterLevelIndicator.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author xiez
 *?????????????
 */
public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/db_waterLeverindicator?useUnicode=true&characterEncoding=utf8"; // ???????????
	private String dbUserName="root"; // ?????
	private String dbPassword=""; // ????
	private String jdbcName="com.mysql.jdbc.Driver"; // ????????
	/**
	 * ????????????
	 * @return
	 * @throws Exception
	 */
	public Connection getCon(){
		try {
			Class.forName(jdbcName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * ????????????
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("?????????????");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("????????????");
		}
	}
}
