package org.lissi.extension.owl.smc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.PropertyModel;

//VS4E -- DO NOT REMOVE THIS LINE!
public class TowOfEditor extends JFrame {

	private static TowOfEditor instance;
	String path;


	public static final TowOfEditor getInstance(ArrayList<OWLClass> _owlClassList, ArrayList<OWLProperty> _owlPropertyList, ArrayList<ActionModel> _owlactionList, OWLOntology MyOntologie) throws PropertyVetoException
	{

		if (instance == null)
		{
			instance = new TowOfEditor(_owlClassList, _owlPropertyList, _owlactionList, MyOntologie);
			/*
			 * instance.getContentPane().revalidate();
			 * instance.getContentPane().repaint();
			 * instance.getContentPane().revalidate();
			 * instance.getContentPane().repaint();
			 * 
			 * instance.getJTree0().updateUI();
			 * instance.getJTree0().revalidate();
			 * instance.getJTree0().repaint(); instance.getJTree0().updateUI();
			 */
		}
		/*
		 * instance.getContentPane().revalidate();
		 * instance.getContentPane().repaint();
		 * instance.getJTree0().revalidate(); instance.getJTree0().repaint();
		 * instance.getJTree0().updateUI();
		 */

		return instance;

	}

	EditorComponent c = new EditorComponent();
	private static final long serialVersionUID = 1L;
	public JTree jTree0;
	private JScrollPane jScrollPane0;
	public ArrayList<OWLClass> _classes;
	public ArrayList<ActionModel> _actions;
	@SuppressWarnings("rawtypes")
	public ArrayList<OWLProperty> _properties;
	public OWLOntology _myOntology;
	private JInternalFrame jInternalFrame0;
	private JInternalFrame jInternalFrame1;
	private JInternalFrame jInternalFrame2;
	private JLabel jLabel0;

	private JTable jTable0;
	private JScrollPane jScrollPane2;
	String[] colNames = { "List of Instances" };
	ArrayList<OWLIndividual> list = new ArrayList<OWLIndividual>();
	Object[][] donnees = {};
	private JMenuItem jMenuItem0, jMenuItem5, jMenuItem6;
	private JMenu jMenu0;
	private JMenuItem jMenuItem2;
	private JMenu jMenu2;
	private JMenuBar jMenuBar0;
	private JMenuItem jMenuItem3;
	private JSplitPane jSplitPane0;

	private JTextField jTextField0;

	private JScrollPane jScrollPane4;

	static JTable jTable1;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";


	@SuppressWarnings("rawtypes")
	public TowOfEditor(ArrayList<OWLClass> classes, ArrayList<OWLProperty> properties, ArrayList<ActionModel> actions, OWLOntology myOntology) throws PropertyVetoException
	{

		_actions = actions;
		_classes = classes;
		_properties = properties;
		_myOntology = myOntology;

		initComponents();

	}


	@SuppressWarnings("rawtypes")
	public TowOfEditor(ArrayList<OWLClass> _owlClassList, ArrayList<OWLProperty> _owlPropertyList, OWLOntology myOntologie) throws PropertyVetoException
	{

		_classes = new ArrayList<OWLClass>();
		_properties = new ArrayList<OWLProperty>();
		_myOntology = myOntologie;

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


	private JTable getJTable1()
	{

		if (jTable1 == null)
		{
			jTable1 = new JTable();
			jTable1.setAutoscrolls(true);
			jTable1.setRowHeight(35);
			// jTable0.setBackground(Color.orange);
			ListSelectionModel listSelectionModel = jTable1.getSelectionModel();
			listSelectionModel.addListSelectionListener(new ControleurTableResultatTable1(jTable1, _myOntology, this));

		}
		return jTable1;
	}


	private JScrollPane getJScrollPane4()
	{

		if (jScrollPane4 == null)
		{
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setFocusable(false);
			jScrollPane4.setViewportView(getJTable1());
		}
		return jScrollPane4;
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


	private JMenuItem getJMenuItem3()
	{

		if (jMenuItem3 == null)
		{
			ImageIcon SaveIcon = new ImageIcon(getClass().getResource("/icons/save.png"));
			jMenuItem3 = new JMenuItem(SaveIcon);
			jMenuItem3.setBackground(Color.orange);
			jMenuItem3.setText("View and Save Smc File");
			jMenuItem3.addActionListener(new MenuActionListenerSaveFile());
		}
		return jMenuItem3;
	}


	private JMenuBar getJMenuBar0()
	{

		if (jMenuBar0 == null)
		{
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getJMenu0());
			// jMenuBar0.add(getJMenu1());
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
			jMenuItem2.setText("LISSI OwlToSmc Editor ");
			jMenuItem2.addActionListener(new MenuActionListenerOpenFile());
		}
		return jMenuItem2;
	}


	private JMenu getJMenu0()
	{

		if (jMenu0 == null)
		{
			jMenu0 = new JMenu();
			jMenu0.setText("File");
			jMenu0.add(getJMenuItem0());
			jMenu0.add(getJMenuItem5());
			jMenu0.add(getJMenuItem6());
			jMenu0.addSeparator();
			jMenu0.add(getJMenuItem3());
		}
		return jMenu0;
	}


	private JMenuItem getJMenuItem0()
	{

		if (jMenuItem0 == null)
		{
			ImageIcon AddIcon = new ImageIcon(getClass().getResource("/icons/a.png"));
			jMenuItem0 = new JMenuItem(AddIcon);
			jMenuItem0.setText("Add Action");
			jMenuItem0.setBackground(Color.orange);

			jMenuItem0.addActionListener(new MenuActionListenerAction());
		}
		return jMenuItem0;
	}


	private JMenuItem getJMenuItem5()
	{

		if (jMenuItem5 == null)
		{
			ImageIcon AddIcon = new ImageIcon(getClass().getResource("/icons/c.png"));
			jMenuItem5 = new JMenuItem(AddIcon);
			jMenuItem5.setText("Add Concept");
			jMenuItem5.setBackground(Color.orange);

			jMenuItem5.addActionListener(new MenuActionListenerConcept());
		}
		return jMenuItem5;
	}


	private JMenuItem getJMenuItem6()
	{

		if (jMenuItem6 == null)
		{
			ImageIcon AddIcon = new ImageIcon(getClass().getResource("/icons/p.png"));
			jMenuItem6 = new JMenuItem(AddIcon);
			jMenuItem6.setText("Add Property");
			jMenuItem6.setBackground(Color.orange);

			jMenuItem6.addActionListener(new MenuActionListenerProperty());
		}
		return jMenuItem6;
	}

	class MenuActionListenerAction implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			Action action = new Action();
			action.setLocationRelativeTo(null);
			action.setResizable(false);
			action.setVisible(true);
			/*
			 * TextEditor ee = TextEditor.getInstance();
			 * ee.textArea.setText(LoadSemanticModel.Refresh());
			 * action.setVisible(true);
			 */

		}
	}

	class MenuActionListenerProperty implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			Property action = new Property();
			action.setLocationRelativeTo(null);
			action.setResizable(false);
			action.setVisible(true);
			/*
			 * TextEditor ee = TextEditor.getInstance();
			 * ee.textArea.setText(LoadSemanticModel.Refresh());
			 * action.setVisible(true);
			 */

		}
	}

	class MenuActionListenerConcept implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			Concept action = new Concept();
			action.setLocationRelativeTo(null);
			action.setResizable(false);
			action.setVisible(true);
			/*
			 * TextEditor ee = TextEditor.getInstance();
			 * ee.textArea.setText(LoadSemanticModel.Refresh());
			 * action.setVisible(true);
			 */

		}
	}

	class MenuActionListenerOpenFile implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			try
			{
				// URL url =
				// this.getClass().getClassLoader().getResource("resources/Documentation.pdf");
				// path = url.toString().replace("file:/", "");
				// File file = new File(path);
				File file = new File(getClass().getResource("/resources/Documentation.pdf").toURI());
				Desktop.getDesktop().open(file);
			} catch (Exception eee)
			{
				eee.printStackTrace();
			}
			// Process p = Runtime.getRuntime().exec(in);
			/*
			 * TextEditor ee = TextEditor.getInstance();
			 * ee.textArea.setText(LoadSemanticModel.Refresh());
			 * action.setVisible(true);
			 */

		}
	}

	class MenuActionListenerSaveFile implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{

			TextEditor textEditor = TextEditor.getInstance();
			// TextEditor textEditor = new TextEditor();
			textEditor.textArea.setText(LoadSemanticModel.Refresh());
			textEditor.setVisible(true);
			textEditor.setSize(1200, 750);
			textEditor.setLocationRelativeTo(null);
			textEditor.setVisible(true);

		}
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


	private JTable getJTable0()
	{

		if (jTable0 == null)
		{
			jTable0 = new JTable();
			jTable0.setRowHeight(35);
			jTable0.setAutoscrolls(true);
			// jTable0.setBackground(Color.orange);
			ListSelectionModel listSelectionModel = jTable0.getSelectionModel();
			listSelectionModel.addListSelectionListener(new ControleurTableResultat(jTable0, _myOntology, this));
			listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			/*
			 * int ligne = getJTable1().getSelectedRow();//Si tu veut la ligne
			 * selectionnée int colonne = getJTable1().getSelectedColumn();//Si
			 * tu veut la colonne selectionnée OWLIndividual cellule =
			 * (OWLIndividual) getJTable1().getValueAt(ligne,colonne);
			 * System.out.println("Celluuuuuuuuuuuuule"+cellule.toString());
			 */
		}
		return jTable0;
	}


	private JLabel getJLabel0()
	{

		if (jLabel0 == null)
		{
			jLabel0 = new JLabel();
		}
		return jLabel0;
	}


	private JInternalFrame getJInternalFrame2()
	{

		if (jInternalFrame2 == null)
		{
			jInternalFrame2 = new JInternalFrame();
			jInternalFrame2.setVisible(true);
			jInternalFrame2.setOpaque(true);
			jInternalFrame2.add(getJScrollPane4(), BorderLayout.CENTER);
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
			jInternalFrame1.add(getJInternalFrame2(), new Constraints(new Leading(389, 391, 10, 10), new Leading(-23, 603, 10, 10)));
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


	public JTree getJTree0()
	{

		if (jTree0 == null)
		{

			JtreeHeritage J = new JtreeHeritage();
			Collections.sort(_classes);
			Collections.sort(_properties);
			jTree0 = J.init(_classes, _properties, _actions, _myOntology);
			jTree0.setCellRenderer(new OwlTreeCellRenderer());

			jTree0.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
			// add MouseListener to tree
			MouseAdapter ma = new MouseAdapter() {
				private void myPopupEvent(MouseEvent e)
				{

					int x = e.getX();
					int y = e.getY();
					JTree tree = (JTree) e.getSource();
					TreePath path = tree.getPathForLocation(x, y);
					if (path == null)
						return;

					DefaultMutableTreeNode rightClickedNode = (DefaultMutableTreeNode) path.getLastPathComponent();

					TreePath[] selectionPaths = tree.getSelectionPaths();

					// check if node was selected
					boolean isSelected = false;
					if (selectionPaths != null)
					{
						for (TreePath selectionPath : selectionPaths)
						{
							if (selectionPath.equals(path))
							{
								isSelected = true;
							}
						}
					}
					// if clicked node was not selected, select it
					if (!isSelected)
					{
						tree.setSelectionPath(path);
					}

					if (rightClickedNode.isLeaf())
					{
						JPopupMenu menu = new JPopupMenu();

						final JMenuItem item = new JMenuItem("Change Type To Functional");
						item.addActionListener(getFunctionalPropertyListener());
						item.setBackground(Color.orange);
						menu.add(item);
						menu.addSeparator();

						final JMenuItem item2 = new JMenuItem("Change Type To List");
						item2.addActionListener(getListPropertyListener());
						item2.setBackground(Color.orange);
						menu.add(item2);
						menu.addSeparator();
						final JMenuItem item3 = new JMenuItem("Change Type To Set");
						item3.addActionListener(getSetPropertyListener());
						item3.setBackground(Color.orange);
						menu.add(item3);

						menu.show(tree, x, y);
					}
				}


				public void mousePressed(MouseEvent e)
				{

					if (e.isPopupTrigger())
						myPopupEvent(e);
				}


				public void mouseReleased(MouseEvent e)
				{

					if (e.isPopupTrigger())
						myPopupEvent(e);
				}
			};

			jTree0.addMouseListener(ma);

			// jTree0.setComponentPopupMenu(getPopUpMenu());

			jTree0.addTreeSelectionListener(new TreeSelectionListener() {
				@Override
				public void valueChanged(TreeSelectionEvent event)
				{

					// getJTable1().setModel(new MyListTableModel(null,
					// colNames));
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

							}
							Collections.sort(list);

							// getJTable0().revalidate();
							// getJTable1().revalidate();
							getJTable0().setModel(new MyListTableModel(list, colNames));

							jLabel0.setText("Number Of Instances  :\t \t(" + classe.getIndividuals(_myOntology).size() + "\t)");

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


	private ActionListener getFunctionalPropertyListener()
	{

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree0.getLastSelectedPathComponent();

				if (node == null)
					return;
				Object nodeInfo = node.getUserObject();

				if (nodeInfo instanceof OWLObjectProperty)
				{
					nodeInfo = node.getUserObject();

					PropertyModel m = (PropertyModel) Activator.model.getElement("http://www.sembysem.org/LastOwlWidhIndividual#" + nodeInfo.toString().substring(nodeInfo.toString().indexOf("#") + 1, nodeInfo.toString().length() - 1));

					c.ChangePropertyType(m, "Functional");

				}

			}

		};
	}


	private ActionListener getSetPropertyListener()
	{

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree0.getLastSelectedPathComponent();

				if (node == null)
					return;
				Object nodeInfo = node.getUserObject();

				if (nodeInfo instanceof OWLObjectProperty)
				{
					nodeInfo = node.getUserObject();

					PropertyModel m = (PropertyModel) Activator.model.getElement("http://www.sembysem.org/LastOwlWidhIndividual#" + nodeInfo.toString().substring(nodeInfo.toString().indexOf("#") + 1, nodeInfo.toString().length() - 1));

					c.ChangePropertyType(m, "Set");

				}

			}

		};
	}


	private ActionListener getListPropertyListener()
	{

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree0.getLastSelectedPathComponent();

				if (node == null)
					return;
				Object nodeInfo = node.getUserObject();

				if (nodeInfo instanceof OWLObjectProperty)
				{
					nodeInfo = node.getUserObject();

					PropertyModel m = (PropertyModel) Activator.model.getElement("http://www.sembysem.org/LastOwlWidhIndividual#" + nodeInfo.toString().substring(nodeInfo.toString().indexOf("#") + 1, nodeInfo.toString().length() - 1));

					c.ChangePropertyType(m, "List");

				}

			}

		};
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
