package org.lissi.extension.owl.smc.editor;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.ToolTipManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.semanticweb.owlapi.model.OWLOntology;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.PropertyModel;

public class treeHeritageMicroConceptSmc extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public JTree init(ArrayList<ConceptModel> classes, ArrayList<PropertyModel> properties, ArrayList<ActionModel> actions, OWLOntology myOntology)
	{

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("My Ontology");

		createNodes(top, classes, properties, actions, myOntology);

		FilteredTreeModelSmc model = new FilteredTreeModelSmc(new DefaultTreeModel(top));
		JTree tree = new JTree(model);

		ToolTipManager.sharedInstance().registerComponent(tree);
		ImageIcon ConceptIcon = createImageIcon("Concept.png");
		ImageIcon propertyIcon = createImageIcon("Property.png");

		MyRendererSmc m = new MyRendererSmc(ConceptIcon, propertyIcon);
		if (ConceptIcon != null)
		{
			tree.setCellRenderer(m);
		}

		// JScrollPane scrollPane = new JScrollPane(tree) ;

		return tree;
		// getContentPane().add(scrollPane, BorderLayout.CENTER);
	}


	private void createNodes(DefaultMutableTreeNode top, ArrayList<ConceptModel> classes, ArrayList<PropertyModel> properties, ArrayList<ActionModel> actions, OWLOntology myOntology)
	{

		DefaultMutableTreeNode pere = new DefaultMutableTreeNode("Concepts");

		top.add(pere);
		for (int i = 0; i < classes.size(); i++)
		{

			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(classes.get(i));
				pere.add(fils);

				System.out.println(fils.getUserObject() instanceof ConceptModel);

				for (int m = 0; m < properties.size(); m++)
				{
					String jj;
					if (!classes.get(i).toString().contains("owl:Thing"))
					{
						jj = classes.get(i).getUri().substring(classes.get(i).getUri().indexOf("#") + 1);
						// System.out.println("22222222222222222222" + jj);

						for (int l = 0; l < properties.get(m).getDomains().size(); l++)
							if (properties.get(m).getDomains().get(l).toString().endsWith(jj))
							{
								DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m)/*
																													 * .
																													 * getUri
																													 * (
																													 * )
																													 */);
								fils.add(filsdefisprop);
							}
					}
				}

				// createNodes(top, classes, properties, myOntology);

			}
		}
		DefaultMutableTreeNode ActionPere = new DefaultMutableTreeNode("Actions");

		top.add(ActionPere);
		for (int p = 0; p < actions.size(); p++)
		{
			// if (!classes.get(i).toString().contains("owl:Thing") &&
			// !(classes.get(i).getParentConcepts().size() > 0))
			// if (classes.get(i).getParentConcepts().size() == 0)
			{
				DefaultMutableTreeNode fils = new DefaultMutableTreeNode(actions.get(p));
				ActionPere.add(fils);
			}
		}

	}


	void showFils(ConceptModel classe, DefaultMutableTreeNode fils, ArrayList<PropertyModel> properties, OWLOntology myOntology)
	{

		for (int j = 0; j < classe.getParentConcepts().size(); j++)
		{
			// ConceptModel m=classe.getParentConcepts().get(j);
			DefaultMutableTreeNode filsdefis = new DefaultMutableTreeNode(classe.getParentConcepts().get(j));
			fils.add(filsdefis);

			if (properties.size() > 0)
			{
				for (int m = 0; m < properties.size(); m++)
				{
					String jj = classe.getParentConcepts().get(j).toString().substring(1 + classe.getParentConcepts().get(j).toString().lastIndexOf("#"), classe.getParentConcepts().get(j).toString().lastIndexOf(">"));

					if (properties.get(m).getDomains().size() > 0)
					{
						if (properties.get(m).getDomains().get(0).toString().endsWith(jj))
						{
							DefaultMutableTreeNode filsdefisprop = new DefaultMutableTreeNode(properties.get(m));

							filsdefis.add(filsdefisprop);
						}

					}
				}

			}

			showFils(classe, filsdefis, properties, myOntology);

		}
	}


	protected static ImageIcon createImageIcon(String path)
	{

		java.net.URL imgURL = treeHeritageMicroConceptSmc.class.getResource(path);
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