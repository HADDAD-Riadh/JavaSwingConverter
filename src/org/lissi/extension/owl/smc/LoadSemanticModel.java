/*    */package org.lissi.extension.owl.smc;

/*    */
/*    */import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.sembysem.persistence.ISemanticModelWriter;
import org.sembysem.persistence.SemanticModelLoaderFactory;

/*    */
/*    */public class LoadSemanticModel
/*    */{
	/*    */public static String afficherFichier(String chemin)
	/*    */
	{

		/* 27 */String chaine = "";
		/*    */try
		/*    */{
			/* 30 */FileReader fReader = new FileReader(chemin);
			/* 31 */BufferedReader bReader = new BufferedReader(fReader);
			/*    */
			/* 33 */String ligne = null;
			/* 34 */while ((ligne = bReader.readLine()) != null)
			/*    */
			{
				/* 36 */chaine = chaine + ligne + "\n";
				/*    */}
			/*    */
			/* 39 */bReader.close();
			/*    */} catch (FileNotFoundException localFileNotFoundException)
		{
			/* 41 */System.out.println("Erreur ouverture fichier en lecture. Arrêt du programme.");
			/* 42 */System.exit(-1);
			/*    */} catch (IOException localIOException)
		{
			/* 44 */System.out.println("IOException pour cause indéterminée. Arrêt du programme.");
			/* 45 */System.exit(-1);
			/*    */}
		/* 47 */return chaine;
		/*    */}


	/*    */
	/*    */public static String Refresh()
	/*    */
	{

		/* 52 */ISemanticModelWriter modelWriter = SemanticModelLoaderFactory.createModelWriter();
		/* 53 */System.out.println("This is the generated smc ontologie");
		/*    */try
		{
			/* 55 */SemanticModel.styledText = modelWriter.saveMicroConceptModel(Activator.model).toString();
			// System.out.println("" +
			// modelWriter.saveMicroConceptModel(Activator.model) +
			// modelWriter.saveMicroConceptModel(Activator.model1));

			return SemanticModel.styledText;
		}
		/*    */catch (IOException e)
		{
			/* 58 */
			/* 63 */
			return e.getMessage();
			/*    */}
		/*    */}
	/*    */
}

/*
 * Location: C:\Users\Riadh\Desktop\com.sembysem.editor.microconcepts_1.0.0.jar
 * Qualified Name: org.sembysem.editor.microconcept.model.LoadSemanticModel
 * JD-Core Version: 0.6.2
 */