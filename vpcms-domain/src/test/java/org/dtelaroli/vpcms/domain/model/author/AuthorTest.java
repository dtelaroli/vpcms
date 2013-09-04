package org.dtelaroli.vpcms.domain.model.author;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.dtelaroli.vpcms.domain.model.author.Author;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

	Author author;
	
	@Before
	public void setUp() throws Exception {
		author = new Author();
	}

	@Test
	public void shouldCreateInstance() {
		assertThat(author, notNullValue());
	}

}
