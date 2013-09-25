package org.dtelaroli.vpcms.domain.model.categorization;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.dtelaroli.vplus.core.model.ModelPlus;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Category extends ModelPlus {

	private static final long serialVersionUID = 1633937075212740447L;
	
	@NotEmpty
	@Size(max = 40)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	private Category parent;
	
	public Category() {}

	public Category(long id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Category build() {
		return new Category();
	}
	
	@Override
	public String[] includes() {
		return new String[]{ "parent" };
	}

}