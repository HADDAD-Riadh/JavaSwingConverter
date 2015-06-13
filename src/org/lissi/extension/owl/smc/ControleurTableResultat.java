package org.lissi.extension.owl.smc;

import java.util.ArrayList;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;

import staticClass.actionStatic;

public class ControleurTableResultat implements ListSelectionListener {
	JTable table;
	OWLOntology MyOntologie;
	TowOfEditor editor;
	String[] colNames = { "List of properties" };
	ArrayList<OWLObjectPropertyExpression> _ListIndividualProperties;


	public ControleurTableResultat(JTable table, OWLOntology MyOntologie, TowOfEditor editor)
	{

		this.editor = editor;
		this.table = table;
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

			int ligne = table.getSelectedRow();
			int colonne = table.getSelectedColumn();// Si

			OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();

			ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
			OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
			OWLReasoner reasoner = reasonerFactory.createReasoner(actionStatic.MyOntologie, config);

			reasoner.precomputeInferences();
			OWLNamedIndividual cellule = (OWLNamedIndividual) table.getValueAt(ligne, colonne);
			actionStatic.owlNamedIndividual = cellule;
			System.out.println(cellule.toString());
			for (OWLObjectPropertyExpression dd : cellule.getObjectPropertyValues(MyOntologie).keySet())
			{
				System.out.println(dd.toString());
				NodeSet<OWLNamedIndividual> petValuesNodeSet = reasoner.getObjectPropertyValues(cellule, dd);
				Set<OWLNamedIndividual> values = petValuesNodeSet.getFlattened();
				System.out.println("The has_pet property values for " + dd.toString() + "are: ");
				for (OWLNamedIndividual ind : values)
				{
					System.out.println("    " + ind);
				}
				_ListIndividualProperties.add(dd);
			}

			editor.jTable1.setModel(new MyListTableModel(_ListIndividualProperties, colNames));
			editor.jTable1.revalidate();
		}
	}
}