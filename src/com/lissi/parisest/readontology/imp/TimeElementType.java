package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class TimeElementType extends AbstractMCType {
	
	public TimeElementType() {
		this.setName("TimeElement");
		this.setPrimitive(false);

	}

	@Override
	public boolean instanceOf(MCType childType) {
		if (childType instanceof ThingType) {
			return true;
		}
		return childType instanceof TimeElementType;
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
		TimeElementType newType = new TimeElementType();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		return newType;
	}

}
