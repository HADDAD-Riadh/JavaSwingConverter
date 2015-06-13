package com.lissi.parisest.readontology;

public interface StaticInstance {
	/**
	 * 
	 * @return the local name of the instance
	 */
	String getName();
	void setName(String name);
	
	/**
	 * @return the type of the static instance
	 */
	MicroConcept getType();
	void setType(MicroConcept type);
	
}
