package com.lissi.parisest.readontology;

import java.util.HashMap;

public class MCAction extends AbstractMCType {

	private HashMap<String, MCParameter> paramMap = new HashMap<String, MCParameter>();
	private String ontologyActionName;

	public MCAction(){
		
	}
	
	public HashMap<String, MCParameter> getParamMap() {
		return paramMap;
	}

	public void setParamMap(HashMap<String, MCParameter> paramMap) {
		this.paramMap = paramMap;
	}

	public String getOntologyActionName() {
		return ontologyActionName;
	}

	public void setOntologyActionName(String ontologyActionName) {
		this.ontologyActionName = ontologyActionName;
	}

	@Override
	public boolean instanceOf(MCType childType) {
		return getName().equals(childType.getName());
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

		MCAction newType = new MCAction();
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		newType.paramMap = new HashMap<String, MCParameter>(paramMap);
		newType.ontologyActionName = ontologyActionName;
		return newType;
	}

}
