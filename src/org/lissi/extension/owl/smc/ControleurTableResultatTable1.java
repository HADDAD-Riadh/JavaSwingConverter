package org.lissi.extension.owl.smc;

import java.beans.PropertyVetoException;
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

public class ControleurTableResultatTable1 implements ListSelectionListener {
	JTable jj;
	OWLOntology MyOntologie;
	TowOfEditor editor;
	String[] colNames = { "List of Instances" };
	ArrayList<OWLObjectPropertyExpression> _ListIndividualProperties;


	public ControleurTableResultatTable1(JTable jj, OWLOntology MyOntologie, TowOfEditor editor)
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
			OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
			// OWLReasonerFactory reasonerFactory = new
			// Reasoner.ReasonerFactory();
			// We'll now create an instance of an OWLReasoner (the
			// implementation
			// being provided by HermiT as we're using the HermiT reasoner
			// factory).
			// The are two categories of reasoner, Buffering and NonBuffering.
			// In
			// our case, we'll create the buffering reasoner, which is the
			// default
			// kind of reasoner. We'll also attach a progress monitor to the
			// reasoner. To do this we set up a configuration that knows about a
			// progress monitor. Create a console progress monitor. This will
			// print
			// the reasoner progress out to the console.
			ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
			// Specify the progress monitor via a configuration. We could also
			// specify other setup parameters in the configuration, and
			// different
			// reasoners may accept their own defined parameters this way.
			OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
			// Create a reasoner that will reason over our ontology and its
			// imports
			// closure. Pass in the configuration.
			OWLReasoner reasoner = reasonerFactory.createReasoner(actionStatic.MyOntologie, config);
			// Ask the reasoner to do all the necessary work now
			reasoner.precomputeInferences();
			OWLObjectPropertyExpression cellule = (OWLObjectPropertyExpression) jj.getValueAt(ligne, colonne);

			NodeSet<OWLNamedIndividual> petValuesNodeSet = reasoner.getObjectPropertyValues(actionStatic.owlNamedIndividual, cellule);
			Set<OWLNamedIndividual> values = petValuesNodeSet.getFlattened();
			System.out.println("The has_pet property values for " + cellule.toString() + "are: ");
			for (OWLNamedIndividual ind : values)
			{
				System.out.println("    " + ind);
			} // System.out.println(dd.toString());

			// System.out.println(cellule.getIRI().toString());
			// System.out.println("hhhhhhh" +
			// cellule.getAnonymousIndividuals().toString());
			// System.out.println(cellule.getAnnotationAssertionAxioms(MyOntologie).toString());
			// System.out.println(cellule.getIndividualsInSignature().toString());

			GrapheInstanceRelations g = new GrapheInstanceRelations(cellule, values, MyOntologie);
			g.setAlwaysOnTop(true);
			g.setSize(1200, 800);
			try
			{
				g.setLocationRelativeTo(TowOfEditor.getInstance(actionStatic._owlClassList, actionStatic._owlPropertyList, actionStatic._owlactionList, actionStatic.MyOntologie));
			} catch (PropertyVetoException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.setVisible(true);
		}

		editor.jTable1.setModel(new MyListTableModel(_ListIndividualProperties, colNames));
		// editor.jTable1.revalidate();
	}
}
