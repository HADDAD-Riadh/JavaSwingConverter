package org.lissi.extension.owl.smc;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;

public class ControleurTableResultatMicroConcept implements ListSelectionListener {
	JTable jj;
	OWLOntology MyOntologie;
	TowOfEditorMicroConcept editor;
	String[] colNames = { "List of properties" };
	ArrayList<OWLObjectPropertyExpression> _ListIndividualProperties;


	public ControleurTableResultatMicroConcept(JTable jj, OWLOntology MyOntologie, TowOfEditorMicroConcept editor)
	{

		this.editor = editor;
		this.jj = jj;
		this.MyOntologie = MyOntologie;
	}


	@SuppressWarnings("static-access")
	public void valueChanged(ListSelectionEvent listSelectionEvent)
	{

		_ListIndividualProperties = new ArrayList<OWLObjectPropertyExpression>();

		if (listSelectionEvent.getValueIsAdjusting())
			return;
		ListSelectionModel lsm = (ListSelectionModel) listSelectionEvent.getSource();
		if (lsm.isSelectionEmpty())
		{
			System.out.println("No rows selected");
		} else
		{
			int selectedRow = lsm.getMinSelectionIndex();
			System.out.println("The row " + selectedRow + " is now selected");

			int ligne = jj.getSelectedRow();
			int colonne = jj.getSelectedColumn();// Si
			OWLIndividual cellule = (OWLIndividual) jj.getValueAt(ligne, colonne);
			System.out.println(cellule.toString());
			for (OWLObjectPropertyExpression dd : cellule.getObjectPropertyValues(MyOntologie).keySet())
			{
				System.out.println(dd.toString());

				_ListIndividualProperties.add(dd);
			}

			/*
			 * ClickHandler frame = new ClickHandler();
			 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 * frame.setSize(400, 320); frame.setLocationRelativeTo(null);
			 * frame.setAlwaysOnTop(true); frame.setVisible(true);
			 */
			editor.jTable1.setModel(new MyListTableModel(_ListIndividualProperties, colNames));
			editor.jTable1.revalidate();
		}
	}
}