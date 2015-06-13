package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class ThingType extends AbstractMCType implements MCType {

	public  ThingType() {
		this.setName("thing");
		this.setPrimitive(false);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		return childType instanceof ThingType;
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
		ThingType newType = new ThingType();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
