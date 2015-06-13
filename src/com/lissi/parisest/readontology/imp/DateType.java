package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MCType;

public class DateType extends TimeElementType{
	public DateType() {
	//	this.setMultiple(false);
		this.setName("Date");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType.getClass().equals(DateType.class) || childType.getClass().equals(TimeElementType.class);
	}

	@Override
	public boolean isMicroConcept() {
		return false;
	}

	@Override
	public void setMicroConcept(boolean microConcept) {
		// TODO Auto-generated method stub

	}

	@Override
	public  MCType copy() {
		DateType newType = new DateType();
	//	newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
