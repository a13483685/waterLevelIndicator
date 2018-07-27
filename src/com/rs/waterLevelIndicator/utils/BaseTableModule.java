package com.rs.waterLevelIndicator.utils;

/**
 * 
 * 说明:自定义TabelModel工具类
 * 
 * @author xiez
 * 
 * */

import com.rs.waterLevelIndicator.model.SensorData;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class BaseTableModule extends AbstractTableModel {

	Vector<Vector> rows;// 定义行
	Vector<String> colums;// 定义列

	public BaseTableModule(String[] params, Vector<Vector> items) {
		// 初始化列
		this.colums = new Vector<String>();
		for (String colum : params) {
			colums.add(colum);
		}
		// 初始化行
		this.rows = new Vector<Vector>();
		for(Vector v:items)
		{
			rows.add(v);
		}
//		this.rows = items;
//		System.out.println("0 is :"+items.get(0).toString());
//		System.out.println("1 is :"+items.get(1).toString());
	}

	@Override
	public String getColumnName(int column) {
		return this.colums.get(column);
	}

	@Override
	public int getColumnCount() {
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
			return ((Vector) rows.get(rowIndex)).get(columnIndex);
	}

}
