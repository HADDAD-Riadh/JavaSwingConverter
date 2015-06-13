package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class DecimalType extends AbstractMCType {
	public DecimalType() {
	//	this.setMultiple(false);
		this.setName("Decimal");
		this.setPrimitive(true);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if(childType instanceof ThingType){
			return true;
		}
		return childType instanceof DecimalType;
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
		DecimalType newType = new DecimalType();
		//newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}
}
