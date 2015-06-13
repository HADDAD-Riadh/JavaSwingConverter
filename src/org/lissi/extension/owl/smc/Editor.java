package org.lissi.extension.owl.smc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationAssertionAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLAnnotationSubject;
import org.semanticweb.owlapi.model.OWLAnonymousIndividual;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLIndividualAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLogicalAxiom;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLNegativeDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLNegativeObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObject;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectVisitor;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubAnnotationPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.UnknownOWLOntologyException;

public class Editor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTree jTree0;
	private JScrollPane jScrollPane0;
	static// donnes
	ArrayList<OWLClass> _classes;
	@SuppressWarnings("rawtypes")
	static ArrayList<OWLProperty> _properties;
	static OWLOntology _myOntology;
	private JInternalFrame jInternalFrame0;
	private JInternalFrame jInternalFrame1;
	private JInternalFrame jInternalFrame2;
	private JPanel panel_graph;
	private JLabel jLabel0;
	private JScrollPane jScrollPane1;
	private JTable jTable0;
	private JScrollPane jScrollPane2;
	String[] colNames = { "List" };
	ArrayList<OWLIndividual> list = new ArrayList<OWLIndividual>();
	Object[][] donnees = {};
	private JMenuItem jMenuItem0;
	private JMenu jMenu0;
	private JMenuItem jMenuItem1;
	private JMenu jMenu1;
	private JMenuItem jMenuItem2;
	private JMenu jMenu2;
	private JMenuBar jMenuBar0;
	private JMenuItem jMenuItem3;
	private JSplitPane jSplitPane0;

	private JTextField jTextField0;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";


	@SuppressWarnings("rawtypes")
	public Editor(ArrayList<OWLClass> classes, ArrayList<OWLProperty> properties, OWLOntology myOntology) throws PropertyVetoException
	{

		_classes = classes;
		_properties = properties;
		_myOntology = myOntology;
		initComponents();
		panel_graph.revalidate();

	}


	@SuppressWarnings({ "serial", "rawtypes" })
	public Editor() throws PropertyVetoException
	{

		_classes = new ArrayList<OWLClass>();
		_properties = new ArrayList<OWLProperty>();
		_myOntology = new OWLOntology() {

			@Override
			public int compareTo(OWLObject o)
			{

				return 0;
			}


			@Override
			public boolean isTopEntity()
			{

				return false;
			}


			@Override
			public boolean isBottomEntity()
			{

				return false;
			}


			@Override
			public Set<OWLClassExpression> getNestedClassExpressions()
			{

				return null;
			}


			@Override
			public Set<OWLAnonymousIndividual> getAnonymousIndividuals()
			{

				return null;
			}


			@Override
			public <O> O accept(OWLObjectVisitorEx<O> arg0)
			{

				return null;
			}


			@Override
			public void accept(OWLObjectVisitor arg0)
			{

			}


			@Override
			public boolean isEmpty()
			{

				return false;
			}


			@Override
			public boolean isDeclared(OWLEntity arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean isDeclared(OWLEntity arg0)
			{

				return false;
			}


			@Override
			public boolean isAnonymous()
			{

				return false;
			}


			@Override
			public Set<OWLTransitiveObjectPropertyAxiom> getTransitiveObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getTBoxAxioms(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSymmetricObjectPropertyAxiom> getSymmetricObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubClassOfAxiom> getSubClassAxiomsForSuperClass(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubClassOfAxiom> getSubClassAxiomsForSubClass(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubAnnotationPropertyOfAxiom> getSubAnnotationPropertyOfAxioms(OWLAnnotationProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEntity> getSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEntity> getSignature()
			{

				return null;
			}


			@Override
			public Set<OWLSameIndividualAxiom> getSameIndividualAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLReflexiveObjectPropertyAxiom> getReflexiveObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getReferencingAxioms(OWLEntity arg0, boolean arg1)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getReferencingAxioms(OWLAnonymousIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getReferencingAxioms(OWLEntity arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAnonymousIndividual> getReferencedAnonymousIndividuals()
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getRBoxAxioms(boolean arg0)
			{

				return null;
			}


			@Override
			public OWLOntologyID getOntologyID()
			{

				return null;
			}


			@Override
			public Set<OWLSubObjectPropertyOfAxiom> getObjectSubPropertyAxiomsForSuperProperty(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubObjectPropertyOfAxiom> getObjectSubPropertyAxiomsForSubProperty(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectPropertyRangeAxiom> getObjectPropertyRangeAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectPropertyDomainAxiom> getObjectPropertyDomainAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectPropertyAssertionAxiom> getObjectPropertyAssertionAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectProperty> getObjectPropertiesInSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectProperty> getObjectPropertiesInSignature()
			{

				return null;
			}


			@Override
			public OWLOntologyManager getOWLOntologyManager()
			{

				return null;
			}


			@Override
			public Set<OWLNegativeObjectPropertyAssertionAxiom> getNegativeObjectPropertyAssertionAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLNegativeDataPropertyAssertionAxiom> getNegativeDataPropertyAssertionAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLLogicalAxiom> getLogicalAxioms()
			{

				return null;
			}


			@Override
			public int getLogicalAxiomCount()
			{

				return 0;
			}


			@Override
			public Set<OWLIrreflexiveObjectPropertyAxiom> getIrreflexiveObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLInverseObjectPropertiesAxiom> getInverseObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLInverseFunctionalObjectPropertyAxiom> getInverseFunctionalObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLNamedIndividual> getIndividualsInSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLNamedIndividual> getIndividualsInSignature()
			{

				return null;
			}


			@Override
			public Set<OWLImportsDeclaration> getImportsDeclarations()
			{

				return null;
			}


			@Override
			public Set<OWLOntology> getImportsClosure() throws UnknownOWLOntologyException
			{

				return null;
			}


			@Override
			public Set<OWLOntology> getImports() throws UnknownOWLOntologyException
			{

				return null;
			}


			@Override
			public Set<OWLHasKeyAxiom> getHasKeyAxioms(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<OWLClassAxiom> getGeneralClassAxioms()
			{

				return null;
			}


			@Override
			public Set<OWLFunctionalObjectPropertyAxiom> getFunctionalObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLFunctionalDataPropertyAxiom> getFunctionalDataPropertyAxioms(OWLDataPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEquivalentObjectPropertiesAxiom> getEquivalentObjectPropertiesAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEquivalentDataPropertiesAxiom> getEquivalentDataPropertiesAxioms(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEquivalentClassesAxiom> getEquivalentClassesAxioms(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<OWLEntity> getEntitiesInSignature(IRI arg0, boolean arg1)
			{

				return null;
			}


			@Override
			public Set<OWLEntity> getEntitiesInSignature(IRI arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDisjointUnionAxiom> getDisjointUnionAxioms(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDisjointObjectPropertiesAxiom> getDisjointObjectPropertiesAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDisjointDataPropertiesAxiom> getDisjointDataPropertiesAxioms(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDisjointClassesAxiom> getDisjointClassesAxioms(OWLClass arg0)
			{

				return null;
			}


			@Override
			public Set<IRI> getDirectImportsDocuments() throws UnknownOWLOntologyException
			{

				return null;
			}


			@Override
			public Set<OWLOntology> getDirectImports() throws UnknownOWLOntologyException
			{

				return null;
			}


			@Override
			public Set<OWLDifferentIndividualsAxiom> getDifferentIndividualAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDeclarationAxiom> getDeclarationAxioms(OWLEntity arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDatatype> getDatatypesInSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDatatype> getDatatypesInSignature()
			{

				return null;
			}


			@Override
			public Set<OWLDatatypeDefinitionAxiom> getDatatypeDefinitions(OWLDatatype arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubDataPropertyOfAxiom> getDataSubPropertyAxiomsForSuperProperty(OWLDataPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLSubDataPropertyOfAxiom> getDataSubPropertyAxiomsForSubProperty(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataPropertyRangeAxiom> getDataPropertyRangeAxioms(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataPropertyDomainAxiom> getDataPropertyDomainAxioms(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataPropertyAssertionAxiom> getDataPropertyAssertionAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataProperty> getDataPropertiesInSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataProperty> getDataPropertiesInSignature()
			{

				return null;
			}


			@Override
			public Set<OWLClass> getClassesInSignature(boolean arg0)
			{

				return null;
			}


			@Override
			public Set<OWLClass> getClassesInSignature()
			{

				return null;
			}


			@Override
			public Set<OWLClassAssertionAxiom> getClassAssertionAxioms(OWLClassExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLClassAssertionAxiom> getClassAssertionAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getAxiomsIgnoreAnnotations(OWLAxiom arg0, boolean arg1)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getAxiomsIgnoreAnnotations(OWLAxiom arg0)
			{

				return null;
			}


			@Override
			public <T extends OWLAxiom> Set<T> getAxioms(AxiomType<T> arg0, boolean arg1)
			{

				return null;
			}


			@Override
			public Set<OWLDatatypeDefinitionAxiom> getAxioms(OWLDatatype arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAnnotationAxiom> getAxioms(OWLAnnotationProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLIndividualAxiom> getAxioms(OWLIndividual arg0)
			{

				return null;
			}


			@Override
			public Set<OWLDataPropertyAxiom> getAxioms(OWLDataProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLObjectPropertyAxiom> getAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLClassAxiom> getAxioms(OWLClass arg0)
			{

				return null;
			}


			@Override
			public <T extends OWLAxiom> Set<T> getAxioms(AxiomType<T> arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getAxioms()
			{

				return null;
			}


			@Override
			public <T extends OWLAxiom> int getAxiomCount(AxiomType<T> arg0, boolean arg1)
			{

				return 0;
			}


			@Override
			public <T extends OWLAxiom> int getAxiomCount(AxiomType<T> arg0)
			{

				return 0;
			}


			@Override
			public int getAxiomCount()
			{

				return 0;
			}


			@Override
			public Set<OWLAsymmetricObjectPropertyAxiom> getAsymmetricObjectPropertyAxioms(OWLObjectPropertyExpression arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAnnotation> getAnnotations()
			{

				return null;
			}


			@Override
			public Set<OWLAnnotationPropertyRangeAxiom> getAnnotationPropertyRangeAxioms(OWLAnnotationProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAnnotationPropertyDomainAxiom> getAnnotationPropertyDomainAxioms(OWLAnnotationProperty arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAnnotationProperty> getAnnotationPropertiesInSignature()
			{

				return null;
			}


			@Override
			public Set<OWLAnnotationAssertionAxiom> getAnnotationAssertionAxioms(OWLAnnotationSubject arg0)
			{

				return null;
			}


			@Override
			public Set<OWLAxiom> getABoxAxioms(boolean arg0)
			{

				return null;
			}


			@Override
			public boolean containsObjectPropertyInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsObjectPropertyInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsIndividualInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsIndividualInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsEntityInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsEntityInSignature(OWLEntity arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsEntityInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsEntityInSignature(OWLEntity arg0)
			{

				return false;
			}


			@Override
			public boolean containsDatatypeInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsDatatypeInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsDataPropertyInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsDataPropertyInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsClassInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsClassInSignature(IRI arg0)
			{

				return false;
			}


			@Override
			public boolean containsAxiomIgnoreAnnotations(OWLAxiom arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsAxiomIgnoreAnnotations(OWLAxiom arg0)
			{

				return false;
			}


			@Override
			public boolean containsAxiom(OWLAxiom arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsAxiom(OWLAxiom arg0)
			{

				return false;
			}


			@Override
			public boolean containsAnnotationPropertyInSignature(IRI arg0, boolean arg1)
			{

				return false;
			}


			@Override
			public boolean containsAnnotationPropertyInSignature(IRI arg0)
			{

				return false;
			}
		};
		;
		;

		initComponents();
	}


	private void initComponents() throws PropertyVetoException
	{

		setLayout(new GroupLayout());
		add(getJInternalFrame0(), new Constraints(new Leading(9, 10, 10), new Bilateral(8, 12, 33)));
		add(getJSplitPane0(), new Constraints(new Leading(373, 786, 12, 12), new Bilateral(8, 12, 33)));
		setJMenuBar(getJMenuBar0());
		setSize(1177, 648);
	}


	private JTextField getJTextField0()
	{

		if (jTextField0 == null)
		{
			jTextField0 = new JTextField();
			jTextField0.getDocument().addDocumentListener(createDocumentListener(getJTree0(), jTextField0));
		}
		return jTextField0;
	}


	private static DocumentListener createDocumentListener(final JTree tree, final JTextField filter)
	{

		return new DocumentListener() {

			@Override
			public void insertUpdate(final DocumentEvent e)
			{

				applyFilter();
			}


			@Override
			public void removeUpdate(final DocumentEvent e)
			{

				applyFilter();
			}


			@Override
			public void changedUpdate(final DocumentEvent e)
			{

				applyFilter();
			}


			public void applyFilter()
			{

				FilteredTreeModel filteredModel = (FilteredTreeModel) tree.getModel();
				filteredModel.setFilter(filter.getText());

				DefaultTreeModel treeModel = (DefaultTreeModel) filteredModel.getTreeModel();
				treeModel.reload();

				expandTree(tree);
			}
		};
	}


	private static void expandTree(final JTree tree)
	{

		for (int i = 0; i < tree.getRowCount(); i++)
		{
			tree.expandRow(i);
		}
	}


	private JSplitPane getJSplitPane0() throws PropertyVetoException
	{

		if (jSplitPane0 == null)
		{
			jSplitPane0 = new JSplitPane();
			jSplitPane0.setDividerLocation(384);
			jSplitPane0.setLeftComponent(getJInternalFrame1());
			jSplitPane0.setRightComponent(getJInternalFrame2());

		}
		return jSplitPane0;
	}


	@SuppressWarnings("unused")
	private JMenuItem getJMenuItem3()
	{

		if (jMenuItem3 == null)
		{
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Save as");
		}
		return jMenuItem3;
	}


	private JMenuBar getJMenuBar0()
	{

		if (jMenuBar0 == null)
		{
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getJMenu0());
			jMenuBar0.add(getJMenu1());
			jMenuBar0.add(getJMenu2());
		}
		return jMenuBar0;
	}


	private JMenu getJMenu2()
	{

		if (jMenu2 == null)
		{
			jMenu2 = new JMenu();
			jMenu2.setText("about");
			jMenu2.add(getJMenuItem2());
		}
		return jMenu2;
	}


	private JMenuItem getJMenuItem2()
	{

		if (jMenuItem2 == null)
		{
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("jMenuItem2");
		}
		return jMenuItem2;
	}


	private JMenu getJMenu1()
	{

		if (jMenu1 == null)
		{
			jMenu1 = new JMenu();
			jMenu1.setText("Help");
			jMenu1.add(getJMenuItem1());
		}
		return jMenu1;
	}


	private JMenuItem getJMenuItem1()
	{

		if (jMenuItem1 == null)
		{
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("jMenuItem1");
		}
		return jMenuItem1;
	}


	private JMenu getJMenu0()
	{

		if (jMenu0 == null)
		{
			jMenu0 = new JMenu();
			jMenu0.setText("File");
			jMenu0.add(getJMenuItem0());
		}
		return jMenu0;
	}


	private JMenuItem getJMenuItem0()
	{

		if (jMenuItem0 == null)
		{
			jMenuItem0 = new JMenuItem();
			jMenuItem0.setText("Import");
		}
		return jMenuItem0;
	}


	private JScrollPane getJScrollPane2()
	{

		if (jScrollPane2 == null)
		{
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBackground(new Color(128, 255, 128));
			jScrollPane2.setMinimumSize(new Dimension(32767, 32797));
			jScrollPane2.setViewportView(getJTable0());
		}
		return jScrollPane2;
	}


	@SuppressWarnings("unused")
	private JTable getJTable0()
	{

		if (jTable0 == null)
		{
			jTable0 = new JTable();
			jTable0.setRowHeight(35);
			jTable0.setAutoscrolls(true);

			ListSelectionModel listSelectionModel = jTable0.getSelectionModel();

		}
		return jTable0;
	}


	@SuppressWarnings("unused")
	private JScrollPane getJScrollPane1()
	{

		if (jScrollPane1 == null)
		{
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJPanel0());

		}
		return jScrollPane1;
	}


	private JLabel getJLabel0()
	{

		if (jLabel0 == null)
		{
			jLabel0 = new JLabel();
		}
		return jLabel0;
	}


	private JPanel getJPanel0()
	{

		if (panel_graph == null)
		{
			panel_graph = new JPanel();
			// panel_graph.setBackground(new Color(255, 128, 0));
			panel_graph.setLayout(new GridLayout(2, 2));
		}
		return panel_graph;
	}


	private JInternalFrame getJInternalFrame2() throws PropertyVetoException
	{

		if (jInternalFrame2 == null)
		{
			jInternalFrame2 = new JInternalFrame();
			jInternalFrame2.setVisible(true);
			jInternalFrame2.setSelected(true);
			jInternalFrame2.setOpaque(true);
			jInternalFrame2.add(getJPanel0(), BorderLayout.CENTER);
		}
		return jInternalFrame2;
	}


	private JInternalFrame getJInternalFrame1()
	{

		if (jInternalFrame1 == null)
		{
			jInternalFrame1 = new JInternalFrame();
			jInternalFrame1.setVisible(true);
			jInternalFrame1.setOpaque(true);
			jInternalFrame1.setLayout(new GroupLayout());
			jInternalFrame1.add(getJLabel0(), new Constraints(new Leading(18, 10, 10), new Leading(20, 10, 10)));
			jInternalFrame1.add(getJScrollPane2(), new Constraints(new Leading(7, 360, 10, 10), new Leading(46, 508, 10, 10)));
		}
		return jInternalFrame1;
	}


	private JInternalFrame getJInternalFrame0() throws PropertyVetoException
	{

		if (jInternalFrame0 == null)
		{
			jInternalFrame0 = new JInternalFrame();
			jInternalFrame0.setVisible(true);
			jInternalFrame0.setSelected(true);
			jInternalFrame0.setOpaque(true);
			jInternalFrame0.setLayout(new GroupLayout());
			jInternalFrame0.add(getJScrollPane0(), new Constraints(new Leading(7, 329, 10, 10), new Leading(36, 532, 10, 10)));
			jInternalFrame0.add(getJTextField0(), new Constraints(new Leading(8, 326, 12, 12), new Leading(7, 10, 10)));
		}
		return jInternalFrame0;
	}


	private JScrollPane getJScrollPane0()
	{

		if (jScrollPane0 == null)
		{
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTree0());
		}
		return jScrollPane0;
	}


	private JTree getJTree0()
	{

		if (jTree0 == null)
		{

			// JtreeHeritage J = new JtreeHeritage();
			Collections.sort(_classes);
			Collections.sort(_properties);
			// jTree0 = J.init(_classes, _properties, _myOntology);
			jTree0.setCellRenderer(new OwlTreeCellRenderer());

			jTree0.addTreeSelectionListener(new TreeSelectionListener() {

				@SuppressWarnings("unused")
				@Override
				public void valueChanged(TreeSelectionEvent event)
				{

					list = new ArrayList<OWLIndividual>();

					DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree0.getLastSelectedPathComponent();

					if (node == null)
						return;
					Object nodeInfo = node.getUserObject();

					if (nodeInfo instanceof OWLClass)
					{
						try
						{

							OWLClass classe = (OWLClass) nodeInfo;

							for (OWLIndividual ff : classe.getIndividuals(_myOntology))
							{
								list.add(ff);
								// System.out.println("Individual--"+ff.toString());
								for (OWLObjectPropertyExpression dd : ff.getObjectPropertiesInSignature())
								{
									// System.out.println("property Individual--"+dd.toString());

								}

							}
							// list = Arrays.asList();
							Collections.sort(list);

							getJTable0().revalidate();
							getJPanel0().revalidate();

							getJTable0().setModel(new MyListTableModel(list, colNames));

							jLabel0.setText("Number Of Instances  :\t \t(" + classe.getIndividuals(_myOntology).size() + "\t)");

							panel_graph.removeAll();

							/*
							 * System.out.println(m == null);
							 * System.out.println(m.panel == null);
							 * System.out.println(panel_graph == null);
							 */
							panel_graph.revalidate();
							// m.panel.setBackground(Color.blue);
							// panel_graph.add(m.panel, new Constraints(new
							// Leading(0, 0, 10), new Leading(0, 0, 0)));
							panel_graph.revalidate();
						} catch (Exception e2)
						{

							e2.printStackTrace();
						}
					} else if (nodeInfo instanceof OWLObjectProperty)
					{
						try
						{

							OWLObjectProperty classe = (OWLObjectProperty) nodeInfo;

							jLabel0.setText("Nombre des instances :\t" + classe.getIndividualsInSignature().size());

						} catch (Exception e2)
						{

							e2.printStackTrace();
						}

					}

				}
			});
		}

		return jTree0;
	}


	@SuppressWarnings("rawtypes")
	public void setClasses(ArrayList<OWLClass> classes, ArrayList<OWLProperty> properties, OWLOntology myOntology)
	{

		_classes = classes;
		_properties = properties;
		_myOntology = myOntology;
	}


	@SuppressWarnings("unused")
	private static void installLnF()
	{

		try
		{
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e)
		{
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL + " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */

}


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
