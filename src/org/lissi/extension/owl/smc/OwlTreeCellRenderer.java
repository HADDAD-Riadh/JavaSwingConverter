package org.lissi.extension.owl.smc;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.sembysem.modeldescription.ActionModel;

@SuppressWarnings("serial")
class OwlTreeCellRenderer extends JLabel implements TreeCellRenderer {
	private JLabel label;


	OwlTreeCellRenderer()
	{

		label = new JLabel();

	}


	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{

		ImageIcon ConceptIcon = new ImageIcon(getClass().getResource("/icons/Concept.png"));
		ImageIcon propertyIcon = new ImageIcon(getClass().getResource("/icons/Property.png"));
		ImageIcon ActionIcon = new ImageIcon(getClass().getResource("/icons/Action.png"));
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

		if (o instanceof OWLClass)
		{
			OWLClass myClass = (OWLClass) o;
			// ImageIcon leafIcon = createImageIcon("Concept.png");
			label.setIcon(ConceptIcon);
			label.setText(myClass.toString().substring(1 + myClass.toString().toString().lastIndexOf("#"), myClass.toString().toString().lastIndexOf(">")));
		} else if (o instanceof OWLObjectProperty)
		{
			OWLObjectProperty MyProperty = (OWLObjectProperty) o;

			label.setIcon(propertyIcon);
			label.setText(MyProperty.toString().substring(1 + MyProperty.toString().toString().lastIndexOf("#"), MyProperty.toString().toString().lastIndexOf(">")));
		} else if (o instanceof ActionModel)
		{
			ActionModel MyProperty = (ActionModel) o;

			label.setIcon(ActionIcon);
			label.setText(MyProperty.getUri().toString().substring(MyProperty.getUri().toString().indexOf("#") + 1));

		}

		else
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