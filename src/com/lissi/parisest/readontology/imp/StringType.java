package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class StringType extends AbstractMCType {
	public StringType() {
		this.setName("String");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType instanceof StringType;
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
		StringType newType = new StringType();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
