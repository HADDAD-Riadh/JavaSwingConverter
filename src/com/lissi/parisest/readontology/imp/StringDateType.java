package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MCType;

public class StringDateType extends TimeElementType {


	private String dateString;

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getDateString() {
		return dateString;
	}

	
	
	public StringDateType() {
		setName("StringDateType");
		setPrimitive(true);
	}

	@Override
	public boolean instanceOf(MCType childType) {
		if (childType instanceof ThingType) {
			return true;
		}
		return childType.getClass().equals(StringDateType.class) || childType.getClass().equals(TimeElementType.class);
	}

	@Override
	public boolean isMicroConcept() {
		return false;
	}

	@Override
	public void setMicroConcept(boolean microConcept) {

	}

	@Override
	public MCType copy() {
		StringDateType newType = new StringDateType();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
