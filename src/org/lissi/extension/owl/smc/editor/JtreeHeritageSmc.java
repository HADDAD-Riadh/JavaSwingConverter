package org.lissi.extension.owl.smc.editor;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.semanticweb.owlapi.model.OWLOntology;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.PropertyModel;

import com.lissi.parisest.readontology.MicroConcept;

public class JtreeHeritageSmc extends JPanel {

	/**
	 * 
	 */
	static JTree tree;
	private static final long serialVersionUID = 1L;


	// public JtreeHeritage(){
	// super("JTreeobject frame");
	// setSize(300, 250);
	// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// }

	public JTree init(ArrayList<ConceptModel> _classes, ArrayList<ActionModel> _actions, ArrayList<PropertyModel> _properties, ArrayList<MicroConcept> _microconceptList, OWLOntology myOntology)
	{

		// = new JTree(hash);
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("My Ontology");

		createNodes(top, _classes, _actions, _properties, _microconceptList, myOntology);

		// Create a tree that allows one selection at a time.

		FilteredTreeModelSmc model = new FilteredTreeModelSmc(new DefaultTreeModel(top));

		/* JTree */tree = new JTree(model);

		tree.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e)
			{

			}


			@Override
			public void mouseMoved(MouseEvent e)
			{

				TreePath tp = ((JTree) e.getSource()).getPathForLocation(e.getX(), e.getY());

				if (tp != null)
				{
					((JTree) e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));

				} else
				{
					((JTree) e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
		// ((DefaultTreeModel) tree.getModel()).reload();

		ToolTipManager.sharedInstance().registerComponent(tree);
		// ImageIcon ConceptIcon = createImageIcon("Concept.png");
		// ImageIcon propertyIcon = createImageIcon("Property.png");
		ImageIcon ConceptIcon = new ImageIcon(getClass().getResource("/icons/Concept.png"));
		ImageIcon propertyIcon = new ImageIcon(getClass().getResource("/icons/Property.png"));
		MyRendererSmc m = new MyRendererSmc(ConceptIcon, propertyIcon);
		if (ConceptIcon != null)
		{
			tree.setCellRenderer(m);
		}

		// JScrollPane scrollPane = new JScrollPane(tree) ;

		return tree;
		// getContentPane().add(scrollPane, BorderLayout.CENTER);
	}


	private void createNodes(DefaultMutableTreeNode top, ArrayList<ConceptModel> classes, ArrayList<ActionModel> actions, ArrayList<PropertyModel> properties, ArrayList<MicroConcept> _microconceptList, OWLOntology myOntology)
	{

		DefaultMutableTreeNode pere = new DefaultMutableTreeNode("Concepts");
		DefaultMutableTreeNode ActionPere = new DefaultMutableTreeNode("Actions");
		top.add(pere);

		for (int i = 0; i < classes.size(); i++)
		{
			if (!classes.get(i).toString().contains("owl:Thing"))
			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(classes.get(i));
				{
					if (classes.get(i).getParentConcepts().size() == 0)
					{
						for (MicroConcept ll : _microconceptList)
						{
							if (classes.get(i).getUri().substring(classes.get(i).getUri().indexOf("#") + 1, classes.get(i).getUri().length()).equals(ll.getName()))
							{
								for (MicroConcept g : ll.getChildrenConcept())
								{
									DefaultMutableTreeNode filsDefils = new DefaultMutableTreeNode(g);
									fils.add(filsDefils);
									showFils(g, filsDefils, properties);
								}
							}
						}

						for (int m = 0; m < properties.size(); m++)
						{

							if (properties.get(m).getDomains().size() > 0)
							{
								for (int h = 0; h < properties.get(m).getDomains().size(); h++)
								{
									if (properties.get(m).getDomains().get(h).toString().endsWith(classes.get(i).getUri().substring(classes.get(i).getUri().indexOf("#") + 1)))

									{
										DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m));
										fils.add(filsdefisprop);

									}

								}
							}
							pere.add(fils);
						}
					}

				}
			}
			top.add(pere);

		}

		for (int p = 0; p < actions.size(); p++)
		{

			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(actions.get(p));
				ActionPere.add(fils);
			}
		}
		top.add(ActionPere);
	}


	/*
	 * for (int m = 0; m < classes.get(i).getPropertyRestrictions().size(); m++)
	 * {// MCProperty s=classes.get(i).getPropertyMap().get(m); // System
	 * .out.println(classes.get(i).getPropertyMap().get(m).getType() //
	 * instanceof MCReferencable); System.out.println(classes.get(
	 * i).getPropertyRestrictions().get(m) instanceof MCProperty); {
	 * DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode
	 * (classes.get(i).getPropertyRestrictions().get(m));
	 * fils.add(filsdefisprop);
	 * 
	 * } }
	 */
	// if (classes.get(i).getParentConcepts().size() == 0)

	// showFils(classes.get(i), fils, myOntology);

	/*
	 * @SuppressWarnings("rawtypes") void showFils(ConceptModel classe,
	 * DefaultMutableTreeNode fils, OWLOntology myOntology) {
	 * 
	 * for (ConceptModel kk : classe.getChildrenConcept()) {
	 * DefaultMutableTreeNode filsdefis = new DefaultMutableTreeNode(kk);
	 * fils.add(filsdefis);
	 * 
	 * showFils((MicroConcept) kk, filsdefis, myOntology);
	 * 
	 * } }
	 */

	void showFils(MicroConcept classe, DefaultMutableTreeNode fils, ArrayList<PropertyModel> properties)
	{

		for (MicroConcept microConcept : classe.getChildrenConcept())
		{
			DefaultMutableTreeNode filsdefis = new DefaultMutableTreeNode(microConcept);
			fils.add(filsdefis);
			/*
			 * for (int m = 0; m < microConcept.getPropertyMap().size(); m++) {
			 */

			for (int m = 0; m < properties.size(); m++)
			{
				String jj = microConcept.getName();

				if (properties.get(m).getDomains() != null)
				{
					for (int j = 0; j < properties.get(m).getDomains().size(); j++)
					{

						if (properties.get(m).getDomains().get(j).toString().endsWith("#" + jj))
						{

							DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m));

							filsdefis.add(filsdefisprop);
						}
					}
				}
			}

			// }
			showFils(microConcept, filsdefis, properties);

		}
	}


	protected static ImageIcon createImageIcon(String path)
	{

		java.net.URL imgURL = JtreeHeritageSmc.class.getResource(path);
		if (imgURL != null)
		{
			return new ImageIcon(imgURL);
		} else
		{
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}