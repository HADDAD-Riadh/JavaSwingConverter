package com.lissi.parisest.readontology.imp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.lissi.extension.owl.smc.editor.ActivatorSmc;
import org.lissi.extension.owl.smc.editor.ModelDescriptionControllerSmc;
import org.lissi.extension.owl.smc.editor.TowOfEditorSmc;
import org.sembysem.modeldescription.ActionModel;
import org.sembysem.modeldescription.ConceptModel;
import org.sembysem.modeldescription.InstanceModel;
import org.sembysem.modeldescription.ModelDescription;
import org.sembysem.modeldescription.ParameterModel;
import org.sembysem.modeldescription.PropertyModel;
import org.sembysem.modeldescription.ValuesList;
import org.sembysem.persistence.ISemanticModelLoader;
import org.sembysem.persistence.SemanticModelLoaderFactory;

import staticClass.actionStatic;

import com.lissi.parisest.readontology.MicroConcept;

public class ImportSmcFile {
	TowOfEditorSmc editor;
	ModelDescription model = new ModelDescription();
	ModelDescriptionControllerSmc controller = new ModelDescriptionControllerSmc(ActivatorSmc.model);
	private static ArrayList<ConceptModel> concepts = null;
	private static ArrayList<ActionModel> actions = null;
	private static ArrayList<InstanceModel> instances = null;
	private static ArrayList<ParameterModel> parameters = null;
	private static ArrayList<PropertyModel> properties = null;
	private byte[] byteArray = "no ontology source available".getBytes();


	@SuppressWarnings({ "static-access" })
	public void afficher() throws Exception
	{

		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{

			File file = chooser.getSelectedFile();
			if (!(file.getPath().endsWith(".smc")))
			{
				JOptionPane.showMessageDialog(null, "please shoose smc file extension!!!!", "Only Smc File is supported", JOptionPane.ERROR_MESSAGE);
				return;
			} else
			{
				ActivatorSmc.ontology = "http://www.sembysem.org/" + file.getName().substring(0, file.getName().length() - 4) + "#";
				ReadOntologyImp ro = new ReadOntologyImp();
				ISemanticModelLoader modelLoader = SemanticModelLoaderFactory.createModelLoader();
				ro.loadOntology(file.getPath());

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath())));
				StringBuffer buffer = new StringBuffer();
				String line = reader.readLine();

				while (line != null)
				{
					buffer.append(line + "\n");
					line = reader.readLine();
				}
				byteArray = buffer.toString().getBytes();
				ModelDescriptionControllerSmc controller = new ModelDescriptionControllerSmc(modelLoader.loadMicroConceptModel(new ByteArrayInputStream(byteArray)));
				// ro.loadOntology(model);
				for (String s : ro.getMicroConceptMap().keySet())
				{ //
					MicroConcept mcImp = ro.getMicroConceptMap().get(s);
					staticClassSmc.actionStatic._SmcMicroConceptList.add(mcImp);

				}

				concepts = (ArrayList<ConceptModel>) controller.getConcepts();
				for (int i = 0; i < concepts.size(); i++)
				{
					staticClassSmc.actionStatic._SmcConcepts.add(concepts.get(i));
					if (ActivatorSmc.model.getElement(concepts.get(i).getUri()) == null)
					{
						ActivatorSmc.model.addElement(concepts.get(i));
					}
					//

				}
				properties = (ArrayList<PropertyModel>) controller.getProperties();
				for (int i = 0; i < properties.size(); i++)
				{
					if (ActivatorSmc.model.getElement(properties.get(i).getUri()) == null)
						ActivatorSmc.model.addElement(properties.get(i));
					staticClassSmc.actionStatic._SmcProperty.add(properties.get(i));

				}

				System.out.println("Innnnnnnnnnnnnnnnnnnnnnnnnnstance");
				instances = (ArrayList<InstanceModel>) controller.getInstances();
				for (int i = 0; i < instances.size(); i++)
				{

					staticClassSmc.actionStatic._SmcStaticInstance.add(instances.get(i));
					if (ActivatorSmc.model.getElement(instances.get(i).getUri()) == null)
						ActivatorSmc.model.addElement(instances.get(i)); //
					System.out.println("00000000000000000000000000000000000000000000000000000000000000000000" + instances.get(i).getUri());

					for (Entry<String, ValuesList> hh : instances.get(i).getPropertiesValues())
					{

						System.out.println("Key number \t " + i + " \t" + hh.getKey());
					}

				}
				System.out.println(staticClassSmc.actionStatic._SmcStaticInstance.size());

			}

			actions = (ArrayList<ActionModel>) controller.getActions();
			for (int i = 0; i < actions.size(); i++)
			{
				staticClassSmc.actionStatic._SmcActions.add(actions.get(i));
				if (ActivatorSmc.model.getElement(actions.get(i).getUri()) == null)
					ActivatorSmc.model.addElement(actions.get(i));

			}

			parameters = (ArrayList<ParameterModel>) controller.getParameters();
			for (int i = 0; i < parameters.size(); i++)
			{
				if (ActivatorSmc.model.getElement(parameters.get(i).getUri()) == null)
					ActivatorSmc.model.addElement(parameters.get(i));

			}

		}

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
					editor.dispose();
				}
			}
		});
	}
}
