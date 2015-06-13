package com.lissi.parisest.readontology.imp;

import com.lissi.parisest.readontology.MicroConcept;
import com.lissi.parisest.readontology.StaticInstance;

public class StaticInstanceImp implements StaticInstance {
    private String name;
    private MicroConcept type; 
      
	@Override
	public String getName() { 
		return name;
	}

	@Override
	public MicroConcept getType() { 
		return type;
	}

	@Override
	public void setName(String name) {
		this.name=name; 
	}

	@Override
	public void setType(MicroConcept type) {
		this.type=type; 
	}

}
