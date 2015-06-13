package com.lissi.parisest.readontology;

public interface MCType {

	/**
	 * 
	 * @return the local name of the type
	 */
	public abstract String getName();
	
	public abstract String getRealName();

	public abstract void setName(String name);

	/**
	 * <code>true</code> if the type is a primitive type
	 * (int,long,float,double,char,bytes,boolean,short) <code>false</code>
	 * otherwise
	 * 
	 * @return
	 */
	public abstract boolean isPrimitive();

	public abstract void setPrimitive(boolean primitive);

	/**
	 * <code>true</code> if the type is a micro concept <code>false</code>
	 * otherwise (primitive or Date or String) *
	 * 
	 * @return
	 */
	public abstract boolean isMicroConcept();

	public abstract void setMicroConcept(boolean microConcept);

	public abstract boolean instanceOf(MCType childType);


	public MCType copy();

}