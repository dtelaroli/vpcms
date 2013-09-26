package org.dtelaroli.vpcms.domain.model.content;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vpcms.domain.model.content.Content;
import org.junit.Before;
import org.junit.Test;

public class ContentTest {

	Content cont;
	
	@Before
	public void setUp() throws Exception {
		cont = new Content();
	}

	@Test
	public void shouldCreatePost() {
		assertThat(cont, notNullValue());
	}

	@Test
	public void shouldReturnIncludesCategories() {
		assertThat(cont.includes(), equalTo(new String[] {"categories"}));
	}
}
