package org.lissi.extension.owl.smc.editor;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.semanticweb.owlapi.model.OWLOntology;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.ValuesList;

public class ControleurTableResultatSmc implements ListSelectionListener {
	JTable table;
	OWLOntology MyOntologie;
	TowOfEditorSmc editor;
	ArrayList<String> list;
	String[] colNames = { "List of properties" };


	public ControleurTableResultatSmc(JTable table, OWLOntology MyOntologie, TowOfEditorSmc editor)
	{

		this.editor = editor;
		this.table = table;
		this.MyOntologie = MyOntologie;
	}


	@SuppressWarnings("static-access")
	public void valueChanged(ListSelectionEvent listSelectionEvent)
	{

		if (listSelectionEvent.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel) listSelectionEvent.getSource();
		if (lsm.isSelectionEmpty())
		{
			System.out.println("No rows selected");
		} else
		{

			int ligne = table.getSelectedRow();
			int colonne = table.getSelectedColumn();
			InstanceModel cellule = (InstanceModel) table.getModel().getValueAt(ligne, colonne);
			list = new ArrayList<String>();
			for (Entry<String, ValuesList> hh : cellule.getPropertiesValues())
			{

				list.add(hh.getKey().toString().substring(hh.getKey().toString().indexOf("#") + 1));
			}
			editor.jTable1.setModel(new MyListTableModel(list, colNames));
			editor.jTable1.revalidate();
		}
	}
}