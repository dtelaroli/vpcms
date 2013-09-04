package org.dtelaroli.vpcms.domain.model.categorization;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vpcms.domain.model.categorization.Tag;
import org.junit.Before;
import org.junit.Test;

public class TagTest {

	Tag tag;
	
	@Before
	public void setUp() throws Exception {
		tag = new Tag();
	}

	@Test
	public void shouldInstanciateTag() {
		assertThat(tag, notNullValue());
	}
	
	@Test
	public void shouldCreateTag() {
		assertThat(tag.build(), instanceOf(Tag.class));
	}

}