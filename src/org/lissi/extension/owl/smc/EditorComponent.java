package org.lissi.extension.owl.smc;

import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.ConceptRange;
import org.sembysem.modeldescription.ElementValue;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.PropertyModel;
import org.sembysem.semanticmodel.EActionType;
import org.sembysem.semanticmodel.ECollectionCategory;

import staticClass.actionStatic;

public class EditorComponent {

	TowOfEditor editor;


	public void afficher() throws OWLOntologyCreationException, PropertyVetoException
	{

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION)
		{

			File file = chooser.getSelectedFile();

			if (!(file.getPath().endsWith(".owl")))
			{
				JOptionPane.showMessageDialog(null, "please shoose owl file extension!!!!", "Only owl File is supported", JOptionPane.ERROR_MESSAGE);
				return;
			} else
			{
				Activator.ontology = "http://www.sembysem.org/" + file.getName().substring(0, file.getName().length() - 4) + "#";

				actionStatic.MyOntologie = actionStatic.manager.loadOntologyFromOntologyDocument(file);
				List<OWLObjectProperty> properties = new ArrayList<OWLObjectProperty>();
				ECollectionCategory Category = ECollectionCategory.Functional;

				for (OWLClass classe : actionStatic.MyOntologie.getClassesInSignature())
				{

					actionStatic._owlClassList.add(classe);

					ConceptModel concept = new ConceptModel(Activator.ontology + classe.getIRI().getFragment());

					if (classe.getSuperClasses(actionStatic.MyOntologie).size() != 0)
					{
						for (OWLClassExpression cl : classe.getSuperClasses(actionStatic.MyOntologie))
						{

							if (!cl.toString().contains("ObjectAllValuesFrom") && !cl.toString().contains("ObjectSomeValuesFrom")

							&& !cl.toString().contains("ObjectMinCardinality") && !cl.toString().contains("ObjectExactCardinality")

							&& !cl.toString().contains("ObjectMaxCardinality"))

								concept.addParentConcept(Activator.ontology + cl.toString().substring(cl.toString().indexOf("#") + 1, cl.toString().indexOf(">")));
						}
					}

					if (classe.getIndividuals(actionStatic.MyOntologie).size() != 0)
					{

						for (OWLIndividual ff : classe.getIndividuals(actionStatic.MyOntologie))
						{
							InstanceModel m = new InstanceModel(Activator.ontology + ff.toString().substring(ff.toString().indexOf("#") + 1, ff.toString().indexOf(">")), Activator.ontology + classe.toString().substring(classe.toString().indexOf("#") + 1, classe.toString().indexOf(">")));

							Map<OWLObjectPropertyExpression, Set<OWLIndividual>> jj = ff.getObjectPropertyValues(actionStatic.MyOntologie);

							for (int v = 0; v < jj.size(); v++)
							{
								System.out.println(ff.getSignature());
								System.out.println("000000000000000000000"); //
								System.out.println(jj.keySet()); //
								System.out.println(jj.entrySet()); //
								System.out.println(jj.entrySet());

								for (Entry<OWLObjectPropertyExpression, Set<OWLIndividual>> entry : jj.entrySet())
								{
									System.out.println("keeeeeeeeeey" + entry.getKey().toString().substring(entry.getKey().toString().indexOf("#") + 1, entry.getKey().toString().indexOf(">")));

									for (int k = 0; k < entry.getValue().toArray().length; k++)
									{
										System.out.println("Value Numenro :" + k + "" + entry.getValue().toArray()[k]);
										m.addPropertyValue(Activator.ontology + entry.getKey().toString().substring(entry.getKey().toString().indexOf("#") + 1, entry.getKey().toString().indexOf(">")), new ElementValue(Activator.ontology + entry.getValue().toArray()[k].toString().substring(entry
												.getValue().toString().indexOf("#") + 1, entry.getValue().toArray()[k].toString().indexOf(">"))));

									}

								}
								System.out.println("11111111111111111111111");
							}

							if (Activator.model.getElement(m.toString()) == null)
								Activator.model.addElement(m); //

						}
					}

					Activator.model.addElement(concept);

					actionStatic._owlMicroConceptList.add(concept);
				}

				for (OWLObjectProperty cls : actionStatic.MyOntologie.getObjectPropertiesInSignature())
				{
					actionStatic._owlPropertyList.add(cls); //

					PropertyModel property = new PropertyModel();

					if (cls.isFunctional(actionStatic.MyOntologie))
					{
						property.setPropertyType(Category);
					}

					property.setUri(Activator.ontology + cls.getIRI().getFragment());

					if (cls.getAnnotations(actionStatic.MyOntologie).size() != 0)
					{
						for (OWLAnnotation tt : cls.getAnnotations(actionStatic.MyOntologie))
						{
							if (tt.getProperty().toString().equals("rdfs:label"))
							{
								property.setLabel(tt.getValue().toString().substring(tt.getValue().toString().length() - 2), tt.getValue().toString().substring(1, tt.getValue().toString().length() - 4));
							}
							if (tt.getProperty().toString().equals("rdfs:comment"))
							{
								if (tt.getValue().toString().contains("@"))
								{

									property.setDescription("fr", tt.getValue().toString().substring(1, tt.getValue().toString().lastIndexOf("\"")));
								} else
								{

									property.setDescription("fr", tt.getValue().toString().substring(1, tt.getValue().toString().lastIndexOf("\"")));
								}
							}
						}
					}
					if (cls.getInverses(actionStatic.MyOntologie).size() != 0)
					{
						property.setInverseProperty(Activator.ontology + cls.getInverses(actionStatic.MyOntologie).toString().substring(cls.getInverses(actionStatic.MyOntologie).toString().indexOf("#") + 1, cls.getInverses(actionStatic.MyOntologie).toString().indexOf(">")));
					}
					properties.add(cls);

					for (OWLClassExpression _owlClassExpression : cls.getRanges(actionStatic.MyOntologie))
					{

						property.setRange(new ConceptRange(Activator.ontology + _owlClassExpression.toString().substring(_owlClassExpression.toString().indexOf("#") + 1, _owlClassExpression.toString().indexOf(">"))));

					}

					for (OWLClassExpression _owlClassExpression : cls.getDomains(actionStatic.MyOntologie))
					{

						property.addDomain(Activator.ontology + _owlClassExpression.toString().substring(_owlClassExpression.toString().indexOf("#") + 1, _owlClassExpression.toString().length() - 1));

					}
					if (Activator.model.getElement(property.getUri()) == null)
					{

						Activator.model.addElement(property); //

					}
				}

				afficher0();

			}
		}
	}


	@SuppressWarnings("static-access")
	public void afficher0() throws PropertyVetoException
	{

		editor = new TowOfEditor(actionStatic._owlClassList, actionStatic._owlPropertyList, actionStatic._owlactionList, actionStatic.MyOntologie);

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
					// System.exit(0);
					editor.dispose();
				}
			}
		});
	}


	public void afficher2() throws PropertyVetoException
	{

		editor._classes = actionStatic._owlClassList;
		editor._actions = actionStatic._owlactionList;
		editor._properties = actionStatic._owlPropertyList;
		editor._myOntology = actionStatic.MyOntologie;
		editor.jTree0 = null;
		editor.invalidate();

	}


	public void addAction(String ActionName, String Description, String result, String language, String type) throws PropertyVetoException, OWLOntologyCreationException
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

		Activator.model.addElement(action);
		LoadSemanticModel.Refresh();
		actionStatic._owlactionList.add(action);
		afficher0();

		System.out.println(actionStatic._owlactionList.size());

	}


	// /////////////////////////////////////
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

		Activator.model.addElement(action);
		LoadSemanticModel.Refresh();
		actionStatic._owlactionList.add(action);
		afficher0();

		System.out.println(actionStatic._owlactionList.size());

	}


	// /////////////////////////////////////////////////
	public void addConcept(String ConceptName, String parent, String Description, String language) throws PropertyVetoException, OWLOntologyCreationException
	{

		ConceptModel concept = new ConceptModel(Activator.ontology + ConceptName);
		if (!parent.equals("Super concept........"))
		{
			concept.addParentConcept(Activator.ontology + parent);

		}
		concept.setDescription(language, Description);
		if ((Activator.model.getElement(concept.getUri()) == null))
		{
			Activator.model.addElement(concept);

			actionStatic._owlMicroConceptList.add(concept);
			LoadSemanticModel.Refresh();
			afficher0();

			System.out.println(actionStatic._owlMicroConceptList.size());
		} else
		{
			JOptionPane.showMessageDialog(editor, "Conept alredy exist");
		}
	}// ////////////////////////////////////////////////


	public void ChangePropertyType(PropertyModel m, String Type)
	{

		PropertyModel property = (PropertyModel) Activator.model.getElement(m.getUri());

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
		LoadSemanticModel.Refresh();

	}

}
