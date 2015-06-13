package com.lissi.parisest.readontology;

import java.io.InputStream;
import java.util.Map;

import org.sembysem.modeldescription.ModelDescription;

public interface ReadOntology {
	/**
	 * Read the ontology file and build the inner structure
	 * 
	 * @param filePath
	 * @throws Exception 
	 * @throws Exception      SPECIFIC Exceptions to define ! 
	 */
	void loadOntology(String filePath) throws Exception;

	
	void loadOntology(ModelDescription model) throws Exception;

	
	/**
	 * 
	 * @return the map of loaded micro concepts indexed on their local name
	 */
	Map<String,MicroConcept> getMicroConceptMap();
	
	
	/**
	 * 
	 * @return the map of loaded static instances indexed on their local name
	 */
	Map<String,StaticInstance> getStaticInstanceMap();
	
	
	String getOntologyText();

	void loadOntology(InputStream input, OntologyType ontologyType) throws Exception;


	void setMcActionMap(Map<String, MCAction> mcActionMap);


	Map<String, MCAction> getMcActionMap();
}
