package com.lissi.parisest.readontology;

public interface MCReferencable {
	/**
	 * 
	 * @return the local name of the parameter
	 */
	String getName();

	void setName(String name);


	/**
	 * The base type of the parameter.
	 */
	MCType getType();

	void setType(MCType type);

	
	/**
	 * 
	 * @return the minimum number of values that this property must contains
	 */
	int getMinCardinality();

	/**
	 * 
	 * @return the maximum number of values that this property must contains
	 */
	int getMaxCardinality();

	void setMinCardinality(int min);

	void setMaxCardinality(int max);

	boolean isMultiple();

	void setMultiple(boolean multiple);

	void setOwningType(MCType type);
	
	MCType getOwningType();
}
