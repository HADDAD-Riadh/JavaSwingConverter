package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MCType;

public class DurationType extends TimeElementType {
	public DurationType() {
	//	this.setMultiple(false);
		this.setName("Duration");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType.getClass().equals(DurationType.class) || childType.getClass().equals(TimeElementType.class);
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
		DurationType newType = new DurationType();
		//newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
