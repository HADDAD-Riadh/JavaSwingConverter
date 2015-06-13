package org.lissi.extension.owl.smc.editor;

import java.beans.PropertyVetoException;

import javax.swing.JOptionPane;

import org.lissi.extension.owl.smc.Activator;
import org.lissi.extension.owl.smc.LoadSemanticModel;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.PropertyModel;
import org.sembysem.semanticmodel.EActionType;
import org.sembysem.semanticmodel.ECollectionCategory;

import staticClass.actionStatic;

public class EditorComponentSmc {

	TowOfEditorSmc editor;


	@SuppressWarnings("static-access")
	public void afficher0() throws PropertyVetoException
	{

		editor = new TowOfEditorSmc(staticClassSmc.actionStatic._SmcConcepts, staticClassSmc.actionStatic._SmcActions, staticClassSmc.actionStatic._SmcProperty, staticClassSmc.actionStatic._SmcMicroConceptList, actionStatic.MyOntologie);
		editor.setVisible(true);
		editor.setSize(1200, 750);
		editor.setLocationRelativeTo(null);
		editor.setDefaultCloseOperation(editor.DO_NOTHING_ON_CLOSE);

		editor.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent)
			{

				if (JOptionPane.showConfirmDialog(editor, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
	}


	public void addAction(String ActionName, String Description, String result, String language, String type) throws PropertyVetoException, OWLOntologyCreationException
	{

		ActionModel action = new ActionModel(ActivatorSmc.ontology + ActionName);

		action.addDomain(ActivatorSmc.ontology + result);

		action.setDescription(language, Description);
		if (type.equals("Logical"))
			action.setActionType(EActionType.Logical);
		else
		{
			action.setActionType(EActionType.Physical);
		}

		ActivatorSmc.model.addElement(action);
		LoadSemanticModelSmc.Refresh();
		staticClassSmc.actionStatic._SmcActions.add(action);
		afficher0();
		System.out.println(staticClassSmc.actionStatic._SmcActions.size());

	}


	public void ChangePropertyType(PropertyModel m, String Type)
	{

		PropertyModel property = (PropertyModel) ActivatorSmc.model.getElement(m.getUri());

		if (Type.equals("Functional"))
		{

			property.setPropertyType(ECollectionCategory.Functional);
		} else if (Type.equals("Set"))
		{
			property.setPropertyType(ECollectionCategory.Set);

		} else if (Type.equals("List"))
		{
			property.setPropertyType(ECollectionCategory.List);

		}
		LoadSemanticModelSmc.Refresh();

	}


	public void addProperty(String ActionName, String Description, String result, String language, String type) throws PropertyVetoException, OWLOntologyCreationException
	{

		ActionModel action = new ActionModel(Activator.ontology + ActionName);

		action.addDomain(Activator.ontology + result);

		action.setDescription(language, Description);
		if (type.equals("Logical"))
			action.setActionType(EActionType.Logical);
		else
		{
			action.setActionType(EActionType.Physical);
		}

		ActivatorSmc.model.addElement(action);
		LoadSemanticModel.Refresh();
		actionStatic._owlactionList.add(action);
		afficher0();

		System.out.println(actionStatic._owlactionList.size());

	}


	// /////////////////////////////////////////////////
	public void addConcept(String ConceptName, String parent, String Description, String language) throws PropertyVetoException, OWLOntologyCreationException
	{

		ConceptModel concept = new ConceptModel(ActivatorSmc.ontology + ConceptName);

		if (!parent.equals("Super concept........"))
		{
			concept.addParentConcept(ActivatorSmc.ontology + parent);

		}
		concept.setDescription(language, Description);
		if ((ActivatorSmc.model.getElement(concept.getUri()) == null))
		{
			ActivatorSmc.model.addElement(concept);

			staticClassSmc.actionStatic._SmcConcepts.add(concept);
			LoadSemanticModel.Refresh();
			afficher0();

			System.out.println(actionStatic._owlMicroConceptList.size());
		} else
		{
			JOptionPane.showMessageDialog(editor, "Conept alredy exist");
		}
	}

}
