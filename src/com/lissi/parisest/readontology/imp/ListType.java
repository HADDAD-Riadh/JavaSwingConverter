package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCType;

public class ListType extends AbstractMCType implements MCType {

	private MCType innerType;

	@Override
	public boolean instanceOf(MCType childType) {
		if (childType instanceof ThingType) {
			return true;
		}
		return (childType instanceof ListType)
				&& innerType.instanceOf(((ListType) childType).getInnerType());
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
		ListType newType = new ListType();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		newType.setInnerType(getInnerType().copy());
		return newType;
	}

	public void setInnerType(MCType innerType) {
		this.innerType = innerType;
	}

	public MCType getInnerType() {
		return innerType;
	}
	@Override
	public String getName(){
		return innerType.getName();
	}

}
