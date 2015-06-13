package org.lissi.extension.owl.smc.editor;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class MyListTableModel extends AbstractTableModel {
	@SuppressWarnings("rawtypes")
	private ArrayList list;

	private final String headers[];


	@SuppressWarnings("rawtypes")
	public MyListTableModel(ArrayList list, String[] headers)
	{

		this.list = list;
		this.headers = headers;
	}


	public int getRowCount()
	{

		return list.size();
	}


	public int getColumnCount()
	{

		return headers.length;
	}


	public Object getValueAt(int rowIndex, int columnIndex)
	{

		return list.get(rowIndex);
	}


	public void setValueAt(Object object, int rowIndex, int columnIndex)
	{

	}


	public String getColumnName(int column)
	{

		return headers[column];
	}
}
