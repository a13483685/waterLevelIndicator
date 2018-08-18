package com.rs.waterLevelIndicator.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rs.waterLevelIndicator.model.Admin;

public class AdminDao extends BaseDao {
	/**
	 * ????????
	 */
	public Admin login(Admin admin) throws SQLException {
		String sql = "select * from s_admin where name=? and password=?";
		Admin adminRst = null;
		PreparedStatement prst = null;
		ResultSet executeQuery = null;
		try {
			prst = con.prepareStatement(sql);//??sql?????????????????
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} finally {
			if(executeQuery!=null)
				executeQuery.close();
			if(prst!=null)
				prst.close();
			if(con!=null)
				con.close();
		}
		return adminRst;
	}
	public String editPassword(Admin admin,String newPassword) throws SQLException {
		String sql = "select * from s_admin where id=? and password=?";
		PreparedStatement prst = null;
		ResultSet executeQuery = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			executeQuery = prst.executeQuery();
			if(!executeQuery.next()){
				String retString = "?????????";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//??sql?????????????????
		String retString = "??????";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0){
				retString = "???????????";
			}
		}finally {
			if(executeQuery!=null)
			executeQuery.close();
			if(prst!=null)
			prst.close();
			if(con!=null)
			con.close();
		}
		return retString;
	}
}
