package org.lissi.extension.owl.smc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.PropertyModel;

@SuppressWarnings("serial")
class OwlTreeCellRendererMicroConcept extends JLabel implements TreeCellRenderer {
	private JLabel label;


	OwlTreeCellRendererMicroConcept()
	{

		label = new JLabel();

	}


	@SuppressWarnings("unused")
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{

		if (selected)
		{
			label.setBackground(Color.blue);
			label.setForeground(Color.blue);

		} else
		{
			label.setBackground(Color.WHITE);
			label.setForeground(Color.BLACK);
			// setBorderSelectionColor(null);
		}
		Object o = ((DefaultMutableTreeNode) value).getUserObject();
		/*
		 * DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)
		 * tree.getCellRenderer(); renderer.setTextSelectionColor(Color.white);
		 * renderer.setBackgroundSelectionColor(Color.blue);
		 * renderer.setBorderSelectionColor(Color.black);
		 */

		if (o instanceof ConceptModel)
		{
			ConceptModel myClass = (ConceptModel) o;
			ImageIcon leafIcon = createImageIcon("Concept.png");
			label.setIcon(new ImageIcon("Concept.png"));
			label.setText(myClass.getUri().toString().substring(myClass.getUri().toString().indexOf("#") + 1)/*
																											 * .
																											 * substring
																											 * *
																											 * )
																											 */);
		} else if (o instanceof PropertyModel)
		{
			PropertyModel MyProperty = (PropertyModel) o;

			label.setIcon(new ImageIcon("Property.png"));
			label.setText(MyProperty.getUri().toString().substring(MyProperty.getUri().toString().indexOf("#") + 1)/*
																													 * .
																													 * )
																													 */);
		}

		else if (o instanceof ActionModel)
		{
			ActionModel MyProperty = (ActionModel) o;

			label.setIcon(new ImageIcon("Action.png"));
			label.setText(MyProperty.getUri().toString().substring(MyProperty.getUri().toString().indexOf("#") + 1)/*
																													 * .
																													 * )
																													 */);
		} else
		{
			label.setIcon(null);
			label.setText("" + value);
		}
		return label;
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