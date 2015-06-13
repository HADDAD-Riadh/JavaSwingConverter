package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class IntegerType extends AbstractMCType {
	public IntegerType() {
	//	this.setMultiple(false);
		this.setName("Integer");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType instanceof IntegerType;
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
		IntegerType newType = new IntegerType();
	//	newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}
}
