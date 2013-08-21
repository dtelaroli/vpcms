package org.vplus.cms.domain.model.categorization;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	Category cat;
	
	@Before
	public void setUp() throws Exception {
		cat = new Category();
	}

	@Test
	public void shouldInstanciateTag() {
		assertThat(cat, notNullValue());
	}
	
	@Test
	public void shouldCreateTag() {
		assertThat(cat.build(), instanceOf(Category.class));
	}

}