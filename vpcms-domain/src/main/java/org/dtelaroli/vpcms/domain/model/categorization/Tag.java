package org.dtelaroli.vpcms.domain.model.categorization;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.dtelaroli.vplus.core.model.ModelPlus;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Tag extends ModelPlus {

	private static final long serialVersionUID = 4587362447269070207L;
	
	@NotEmpty
	@Size(max = 40)
	private String name;
	
	public Tag() {}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Object build() {
		return new Tag();
	}

}