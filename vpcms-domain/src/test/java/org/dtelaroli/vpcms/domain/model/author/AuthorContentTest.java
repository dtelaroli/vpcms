package org.dtelaroli.vpcms.domain.model.author;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.dtelaroli.vpcms.domain.model.author.AuthorContent;
import org.junit.Before;
import org.junit.Test;

public class AuthorContentTest {

	AuthorContent ac;
	
	@Before
	public void setUp() throws Exception {
		ac = new AuthorContent();
	}

	@Test
	public void shouldCreateAuthorContent() {
		assertThat(ac, notNullValue());
	}

}
