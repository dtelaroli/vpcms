package org.dtelaroli.vpcms.domain.model.content;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vpcms.domain.model.content.Content;
import org.junit.Before;
import org.junit.Test;

public class ContentTest {

	Content post;
	
	@Before
	public void setUp() throws Exception {
		post = new Content();
	}

	@Test
	public void shouldCreatePost() {
		assertThat(post, notNullValue());
	}

}
