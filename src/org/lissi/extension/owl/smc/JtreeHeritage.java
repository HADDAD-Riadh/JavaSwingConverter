package org.lissi.extension.owl.smc;

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

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLProperty;
import org.sembysem.modeldescription.ActionModel;

public class JtreeHeritage extends JPanel {

	/**
	 * 
	 */
	static JTree tree;
	private static final long serialVersionUID = 1L;


	@SuppressWarnings("rawtypes")
	public JTree init(ArrayList<OWLClass> classes, ArrayList<OWLProperty> properties, ArrayList<ActionModel> actions, OWLOntology myOntology)
	{

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("My Ontology");

		createNodes(top, classes, properties, actions, myOntology);

		FilteredTreeModel model = new FilteredTreeModel(new DefaultTreeModel(top));

		tree = new JTree(model);

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

		ToolTipManager.sharedInstance().registerComponent(tree);
		ImageIcon ConceptIcon = new ImageIcon(getClass().getResource("/icons/Concept.png"));
		ImageIcon propertyIcon = new ImageIcon(getClass().getResource("/icons/Property.png"));
		MyRenderer m = new MyRenderer(ConceptIcon, propertyIcon);
		if (ConceptIcon != null)
		{
			tree.setCellRenderer(m);
		}

		return tree;
	}


	@SuppressWarnings("rawtypes")
	private void createNodes(DefaultMutableTreeNode top, ArrayList<OWLClass> classes, ArrayList<OWLProperty> properties, ArrayList<ActionModel> actions, OWLOntology myOntology)
	{

		DefaultMutableTreeNode pere = new DefaultMutableTreeNode("Concepts");
		DefaultMutableTreeNode ActionPere = new DefaultMutableTreeNode("Actions");
		top.add(pere);
		for (int i = 0; i < classes.size(); i++)
		{
			if (!classes.get(i).toString().contains("owl:Thing") && !(classes.get(i).getSuperClasses(myOntology).size() > 0))
			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(classes.get(i));
				pere.add(fils);

				for (int m = 0; m < properties.size(); m++)
				{
					String jj;
					if (!classes.get(i).toString().contains("owl:Thing"))
					{
						jj = classes.get(i).toString().substring(1 + classes.get(i).toString().lastIndexOf("#"), classes.get(i).toString().lastIndexOf(">"));
						if (properties.get(m).getDomains(myOntology).toString().contains(jj))
						{
							DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m));
							fils.add(filsdefisprop);
						}
					}
				}

				showFils(classes.get(i), fils, properties, myOntology);
			}
		}

		top.add(ActionPere);

		for (int conteurAction = 0; conteurAction < actions.size(); conteurAction++)
		{
			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(actions.get(conteurAction));
				ActionPere.add(fils);
			}
		}
	}


	@SuppressWarnings("rawtypes")
	void showFils(OWLClass classe, DefaultMutableTreeNode fils, ArrayList<OWLProperty> properties, OWLOntology myOntology)
	{

		for (OWLClassExpression kk : classe.getSubClasses(myOntology))
		{
			DefaultMutableTreeNode filsdefis = new DefaultMutableTreeNode(kk);
			fils.add(filsdefis);

			if (properties.size() > 0)
			{
				for (int m = 0; m < properties.size(); m++)
				{
					String jj = kk.toString().substring(1 + kk.toString().lastIndexOf("#"), kk.toString().lastIndexOf(">"));

					if (properties.get(m).getDomains(myOntology) != null)
					{
						if (properties.get(m).getDomains(myOntology).toString().contains(jj))
						{
							DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m));

							filsdefis.add(filsdefisprop);
						}

					}
				}

			}

			showFils((OWLClass) kk, filsdefis, properties, myOntology);

		}
	}


	protected static ImageIcon createImageIcon(String path)
	{

		java.net.URL imgURL = JtreeHeritage.class.getResource(path);
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