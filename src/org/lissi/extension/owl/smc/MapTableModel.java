package org.lissi.extension.owl.smc;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class MapTableModel extends AbstractTableModel {

	@SuppressWarnings("rawtypes")
	protected Map map;

	/**
	 * The column names array.
	 */
	protected String[] columnNames;


	public MapTableModel()
	{

		super();
	}


	public MapTableModel(@SuppressWarnings("rawtypes") Map map)
	{

		this(map, "Entry", "Value");
	}


	public MapTableModel(@SuppressWarnings("rawtypes") Map map, String keyName, String valueName)
	{

		this();
		setMap(map);
		setColumnNames(keyName, valueName);
	}


	// ------------------------------------------------------------------------
	// --- methods ---
	// ------------------------------------------------------------------------

	/**
	 * Returns the row count.
	 */
	public int getRowCount()
	{

		return map.size();
	}


	/**
	 * Returns the column count.
	 */
	public int getColumnCount()
	{

		return 2;
	}


	/**
	 * Returns the value at.
	 */
	@SuppressWarnings("rawtypes")
	public Object getValueAt(int row, int column)
	{

		Object[] entries = map.entrySet().toArray();
		Map.Entry entry = (Map.Entry) entries[row];
		if (column == 0)
		{
			return entry.getKey();
		} else if (column == 1)
		{ // column==1
			return entry.getValue();
		} else
		{
			throw new IndexOutOfBoundsException("MapTableModel provides a 2-column table, column-index " + column + " is illegal.");
		}
	}


	/**
	 * Returns the column name.
	 */
	public String getColumnName(int column)
	{

		return columnNames[column];
	}


	/**
	 * Sets the column names.
	 */
	public void setColumnNames(String keyName, String valueName)
	{

		String[] names = { keyName, valueName };
		columnNames = names;
	}


	/**
	 * Returns the map.
	 */
	@SuppressWarnings("rawtypes")
	public Map getMap()
	{

		return map;
	}


	/**
	 * Sets the map.
	 */
	@SuppressWarnings("rawtypes")
	public void setMap(Map _map)
	{

		map = _map;
	}

}