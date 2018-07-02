package com.rs.waterLevelIndicator.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.rs.waterLevelIndicator.utils.DbUtil;

/**
 * 
 * @author xiez
 *创建数据库的连接对象，用过这里整个项目与数据库打交道
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
