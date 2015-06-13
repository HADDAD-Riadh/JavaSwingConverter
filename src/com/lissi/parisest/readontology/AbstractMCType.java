package com.lissi.parisest.readontology;

public abstract class AbstractMCType implements MCType {

	private String name;
	private boolean primitive;
//	private boolean multiple = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#getName()
	 */
	public String getName() {
		return name;
	}
	
	public String getRealName(){
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#setName(java.lang.String)
	 */
	public void setName(String name) {
		
		this.name = name;
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#isPrimitive()
	 */
	public boolean isPrimitive() {
		return this.primitive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#setPrimitive(boolean)
	 */
	public void setPrimitive(boolean primitive) {
		this.primitive = primitive;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#isMicroConcept()
	 */
	public abstract boolean isMicroConcept();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#setMicroConcept(boolean)
	 */
	public abstract void setMicroConcept(boolean microConcept);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lissi.parisest.readontology.MCType#instanceOf(com.lissi.parisest.
	 * readontology.MCType)
	 */
	public abstract boolean instanceOf(MCType childType);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#isMultiple()
	 */
//	public boolean isMultiple() {
//		return this.multiple;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lissi.parisest.readontology.MCType#setMutlipe(boolean)
	 */
//	public void setMultiple(boolean multiple) {
//		this.multiple = multiple;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (primitive ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractMCType other = (AbstractMCType) obj;
	
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primitive != other.primitive)
			return false;
		return true;
	}


	
}
