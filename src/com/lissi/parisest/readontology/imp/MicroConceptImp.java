package com.lissi.parisest.readontology.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lissi.parisest.readontology.AbstractMCType;
import com.lissi.parisest.readontology.MCAction;
import com.lissi.parisest.readontology.MCProperty;
import com.lissi.parisest.readontology.MCType;
import com.lissi.parisest.readontology.MicroConcept;

public class MicroConceptImp extends AbstractMCType implements MicroConcept {

	private List<MicroConcept> superMicroConcept = null;
	private Map<String, MCProperty> propertyMap = null;
	private Map<String, MCProperty> declaredPropertyMap;
	private List<MicroConcept> childrenList;
	private String ontologyClassName="";
	private Set<MCAction> actions;

	public MicroConceptImp() {
		superMicroConcept = new LinkedList<MicroConcept>();
		propertyMap = new HashMap<String, MCProperty>();
		declaredPropertyMap = new HashMap<String, MCProperty>();
		childrenList = new ArrayList<MicroConcept>();
		actions = new HashSet<MCAction>();
	}

	@Override
	public Map<String, MCProperty> getPropertyMap() {
		return propertyMap;
	}

	@Override
	public void setPropertyMap(Map<String, MCProperty> propertyMap) {
		this.propertyMap = propertyMap;

	}

	@Override
	public void setSuperConcept(List<MicroConcept> microConcept) {
		if(this.getName().equals("Desk")){
			System.out.println("");
			}
			this.superMicroConcept = microConcept;

	}

	@Override
	public List<MicroConcept> superConcept() {
		if(this.getName().equals("Desk")){
			System.out.println("");
		}
		return superMicroConcept;
	}

	public void addMicroConcept(MicroConcept microConcept) {
		if(this.getName().equals("Desk")){
			System.out.println("");
		}
		
		superMicroConcept.add(microConcept);
	}

	@Override
	public boolean instanceOf(MCType childType) {
		if (childType instanceof ThingType) {
			return true;
		}

		if (childType instanceof MicroConcept) {
			MicroConcept childConcept = (MicroConcept) childType;

			if (this.getName().equals(childConcept.getName())
			// && (this.isMultiple() == childConcept.isMultiple())
			) {
				return true;
			}

			if (this.superConcept() != null) {

				for (MicroConcept concept : this.superConcept()) {
					if (concept.instanceOf(childType)) {
						return true;
					}
				}
			}
		}
		return false;

	}

	@Override
	public boolean isMicroConcept() {
		return true;
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public void setMicroConcept(boolean microConcept) {
		// TODO Auto-generated method stub

	}

	@Override
	public MCType copy() {

		
		
		MicroConceptImp newType = new MicroConceptImp();
		// newType.setMultiple(isMultiple());
		newType.setName(getName());
		newType.setPrimitive(isPrimitive());
		newType.superMicroConcept = new ArrayList<MicroConcept>(
				superMicroConcept);
		newType.propertyMap = new HashMap<String, MCProperty>(propertyMap);
		newType.ontologyClassName =ontologyClassName;
		return newType;
	}

	@Override
	public Map<String, MCProperty> getDeclaredPropertyMap() {
		return declaredPropertyMap;
	}

	@Override
	public void setDeclaredPropertyMap(Map<String, MCProperty> propertyMap) {
		declaredPropertyMap = propertyMap;
	}

	@Override
	public List<MicroConcept> getChildrenConcept() {
		return childrenList;
	}

	@Override
	public void setOntologyClassName(String ontologyClassName) {
		this.ontologyClassName = ontologyClassName;
	}

	
	public String getOntologyClassName() {
		return ontologyClassName;
	}

	@Override
	public Set<MCAction> getActions() {
		return actions;
	}


}
