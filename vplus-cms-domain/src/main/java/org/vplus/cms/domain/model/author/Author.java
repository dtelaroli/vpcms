package org.vplus.cms.domain.model.author;

import javax.persistence.Entity;

import org.vplus.core.model.ModelPlus;

@Entity
public class Author extends ModelPlus {

	private static final long serialVersionUID = -4631071659416596933L;

	private String name;
	
	public Author() {
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
	
}