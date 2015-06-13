package com.lissi.parisest.readontology;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MicroConcept extends MCType {

	/**
	 * 
	 * @return the local name of the Concept
	 */
	String getName();


	void setName(String name);


	/**
	 * the super concept of this concept, <code>null</code> if there is no super
	 * concept
	 * 
	 * @return
	 */
	List<MicroConcept> superConcept();


	void setSuperConcept(List<MicroConcept> microConcept);


	List<MicroConcept> getChildrenConcept();


	/**
	 * The complete list of properties available from this concept That include
	 * it own properties, inverse properties that have this concept as range,
	 * properties from super concepts and inverse properties that have super
	 * concept as range indexed on their local name
	 * 
	 * @return
	 */
	Map<String, MCProperty> getPropertyMap();


	void setPropertyMap(Map<String, MCProperty> propertyMap);


	Map<String, MCProperty> getDeclaredPropertyMap();


	void setDeclaredPropertyMap(Map<String, MCProperty> propertyMap);


	String getOntologyClassName();


	void setOntologyClassName(String ontologyClassName);


	Set<MCAction> getActions();
}
