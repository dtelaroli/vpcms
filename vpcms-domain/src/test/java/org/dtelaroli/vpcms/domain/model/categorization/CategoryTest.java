package org.dtelaroli.vpcms.domain.model.categorization;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category cat;
	
	@Before
	public void setUp() throws Exception {
		cat = new Category();
	}
	
	@Test
	public void shoudlInstanciateCategoryWithId() {
		cat = new Category(2L);
		assertThat(cat.getId(), equalTo(2L));
	}

	@Test
	public void shouldInstanciateCat() {
		assertThat(cat, notNullValue());
	}
	
	@Test
	public void shouldCreateCat() {
		assertThat(cat.build(), instanceOf(Category.class));
	}

	@Test
	public void shouldReturnIncludes() {
		assertThat(cat.includes(), equalTo(new String[]{"parent"}));
	}
}