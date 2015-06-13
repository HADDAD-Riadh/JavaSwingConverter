package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class BooleanType extends AbstractMCType {

	public BooleanType() {
		this.setName("Boolean");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType instanceof BooleanType;
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
	public MCType copy() {
		BooleanType newType = new BooleanType();
		newType.setMicroConcept(isMicroConcept());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}


}
