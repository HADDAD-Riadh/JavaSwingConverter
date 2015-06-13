package org.lissi.extension.owl.smc.editor;

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

import com.lissi.parisest.readontology.MCProperty;
import com.lissi.parisest.readontology.MicroConcept;

@SuppressWarnings("serial")
class OwlTreeCellRendererSmc extends JLabel implements TreeCellRenderer {
	private JLabel label;


	OwlTreeCellRendererSmc()
	{

		label = new JLabel();

	}


	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{

		ImageIcon ConceptIcon = new ImageIcon(getClass().getResource("/icons/Concept.png"));
		ImageIcon defaultnode = new ImageIcon(getClass().getResource("/icons/default.png"));
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

		if (o instanceof ConceptModel)
		{
			ConceptModel myClass = (ConceptModel) o;
			// ImageIcon leafIcon = createImageIcon("Concept.png");
			label.setIcon(ConceptIcon);
			label.setText(myClass.getUri().substring(myClass.getUri().indexOf("#") + 1, myClass.getUri().length()));
			// System.out.println(myClass.getUri() + "----------");

			// .substring(myClass.getUri().indexOf(myClass.getUri().indexOf("#"),
			// myClass.getUri().length())));
			// System.out.println("5555----55555 -----" +
			// myClass.getUri().substring(myClass.getUri().indexOf(myClass.getUri().indexOf("#"),
			// myClass.getUri().length())));

		} else if (o instanceof MicroConcept)
		{
			MicroConcept myClass = (MicroConcept) o;
			// ImageIcon leafIcon = createImageIcon("Concept.png");
			label.setIcon(ConceptIcon);
			label.setText(myClass.getName());
			// System.out.println(myClass.getUri() + "----------");
		}

		else if (o instanceof PropertyModel)
		{
			PropertyModel MyProperty = (PropertyModel) o;

			label.setIcon(propertyIcon);
			label.setText(MyProperty.getUri().substring(MyProperty.getUri().indexOf("#") + 1, MyProperty.getUri().length()));
		} else if (o instanceof MCProperty)
		{
			MCProperty MyProperty = (MCProperty) o;

			label.setIcon(propertyIcon);
			label.setText(MyProperty.getName());
		} else if (o instanceof ActionModel)
		{
			ActionModel MyAction = (ActionModel) o;

			label.setIcon(ActionIcon);
			label.setText(MyAction.getUri().substring(MyAction.getUri().indexOf("#") + 1, MyAction.getUri().length()));

		}

		else
		{
			label.setIcon(defaultnode);
			label.setText("" + value.toString().substring(value.toString().indexOf("#") + 1, value.toString().length()));
		}
		return label;
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