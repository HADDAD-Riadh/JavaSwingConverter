package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MCType;

public class DateTimeType extends TimeElementType {
	public DateTimeType() {

	//	this.setMultiple(false);
		this.setName("DateTime");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType.getClass().equals(DateTimeType.class) || childType.getClass().equals(TimeElementType.class);
	}

	@Override
	public boolean isMicroConcept() {
		return false;
	}

	@Override
	public void setMicroConcept(boolean microConcept) {

	}

	@Override
	public  MCType copy() {
		DateTimeType newType = new DateTimeType();
	//	newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}
	
	
}
