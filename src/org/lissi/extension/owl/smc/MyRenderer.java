package org.lissi.extension.owl.smc;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLProperty;

@SuppressWarnings("serial")
class MyRenderer extends DefaultTreeCellRenderer {
    Icon ConceptIcon;
    Icon PropertyIcon;

    public MyRenderer(Icon icon, Icon property) {
	ConceptIcon = icon;
	PropertyIcon = property;
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value,
	    boolean sel, boolean expanded, boolean leaf, int row,
	    boolean hasFocus) {

	super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
		row, hasFocus);
	if (IconChange(value).equals("classe")) {
	    setIcon(ConceptIcon);
	    setToolTipText("This book is in the Tutorial series.");
	} else if (IconChange(value).equals("property")) {
	    setIcon(PropertyIcon);
	    setToolTipText("This book is in the Tutorial series.");
	} else {
	    setToolTipText(null); // no tool tip
	}

	return this;
    }

    protected String IconChange(Object value) {
	DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;

	if (node instanceof OWLClass) {
	    return "classe";
	} else if (node instanceof OWLProperty) {
	    return "property";
	}

	return "No";
    }
}
