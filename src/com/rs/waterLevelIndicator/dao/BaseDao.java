package com.rs.waterLevelIndicator.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.rs.waterLevelIndicator.utils.DbUtil;

/**
 * 
 * @author xiez
 *�������ݿ�����Ӷ����ù�����������Ŀ�����ݿ�򽻵�
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
