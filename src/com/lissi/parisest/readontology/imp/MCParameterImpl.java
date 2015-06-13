package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MCParameter;
import com.lissi.parisest.readontology.MCType;

public class MCParameterImpl implements MCParameter {

	private int maxCardinality = 0;
	private int minCardinality = 0;
	private MCType type = null;
	private String name = null;
	private MCType owningType;
	private boolean isOrdred = false;
	private boolean isMultiple = false;
	

	@Override
	public int getMaxCardinality() {
		return maxCardinality;
	}

	@Override
	public int getMinCardinality() {
		return minCardinality;
	}

	@Override
	public String getName() {
		return name;
	}




	@Override
	public void setMaxCardinality(int max) {
		this.maxCardinality = max;

	}

	@Override
	public void setMinCardinality(int min) {
		this.minCardinality = min;

	}


	@Override
	public void setName(String name) {
		this.name = name;

	}



	@Override
	public void setOwningType(MCType type) {
		this.owningType = type;
	}
	
	@Override
	public MCType getOwningType() {
		return owningType;
	}

	@Override
	public MCType getType() {
		return type;
	}
	
	@Override
	public void setType(MCType type) {
		this.type = type;
	}

	public void setOrdred(boolean isOrdred) {
		this.isOrdred = isOrdred;
	}

	public boolean isOrdred() {
		return isOrdred;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	
}
