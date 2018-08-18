package com.rs.waterLevelIndicator.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.rs.waterLevelIndicator.utils.DbUtil;

/**
 *
 * @author xiez
 *??????????????????ù?????????????????????
 */
public class BaseDao {
	public Connection con = new DbUtil().getCon();
	public void closeDao(){
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
