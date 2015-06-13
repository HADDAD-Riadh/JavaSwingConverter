package com.lissi.parisest.readontology.imp;

import java.util.List;

import com.lissi.parisest.readontology.MCProperty;
import com.lissi.parisest.readontology.MCType;

public class MCPropertyImp implements MCProperty {

	private int maxCardinality = 0;
	private int minCardinality = 0;
	private MCType microConceptType = null;
	private String name = null;
	private boolean isOrdred = false;
	private boolean isMultiple = false;
	private List<MCProperty> superProperties = null;
	private MCType owningType;
	

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
	public List<MCProperty> getSuperProperties() {
		return superProperties;
	}

	@Override
	public MCType getType() {
		return microConceptType;
	}

	@Override
	public boolean isMultiple() {
 		return isMultiple;
	}

	@Override
	public boolean isOrdered() {
		 
		return isOrdred;
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
	public void setMultiple(boolean multiple) {
		isMultiple = multiple;

	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setOrdered(boolean ordered) {
		isOrdred = ordered;
	}

	@Override
	public void setSuperProperty(MCProperty property) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setType(MCType type) {
		this.microConceptType = type;
	}

	@Override
	public void setOwningType(MCType type) {
		this.owningType = type;
	}
	
	public MCType getOwningType() {
		return owningType;
	}

}
