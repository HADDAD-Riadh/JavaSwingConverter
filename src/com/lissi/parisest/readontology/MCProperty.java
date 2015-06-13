package com.lissi.parisest.readontology;

import java.util.List;

public interface MCProperty extends MCReferencable {
	/**
	 * 
	 * @return the local name of the property
	 */
	String getName();

	void setName(String name);

	/**
	 * the super property of this property, <code>null</code> if there is no
	 * super property
	 * 
	 * @return
	 */
	List<MCProperty> getSuperProperties();

	void setSuperProperty(MCProperty property);

	/**
	 * The base type of the property. For instance if the property is a set of
	 * ConceptX, the type will refer to ConceptX (not set of ConceptX)
	 * 
	 * @return
	 */
	MCType getType();



	/**
	 * <code>true</code> if the property is can have multiple values
	 * <code>false</code> otherwise
	 * 
	 * @return
	 */
	boolean isMultiple();

	void setMultiple(boolean multiple);

	
	/**
	 * <code>true</code> if the property is ordered
	 * <code>false</code> otherwise
	 * 
	 * @return
	 */
	boolean isOrdered();

	void setOrdered(boolean ordered);

	
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

	void setType(MCType type);

	void setOwningType(MCType type);
	MCType getOwningType();
}
