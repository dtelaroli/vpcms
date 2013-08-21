package org.vplus.cms.domain.model.author;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.vplus.cms.domain.model.content.Content;

public class AuthorBuilderTest {

	AuthorBuilder builder;
	
	@Before
	public void setUp() throws Exception {
		builder = AuthorBuilder.authorContent();
	}

	@Test
	public void shouldCreateInstance() {
		assertThat(builder, notNullValue());
	}
	
	@Test
	public void shouldCreateAuthor() {
		assertThat(builder.build(), instanceOf(AuthorContent.class));
	}
	
	@Test
	public void shouldSetAuthor() {
		AuthorContent a = builder.withAuthor(new Author()).build();
		assertThat(a.getAuthor(), instanceOf(Author.class));
	}
	
	@Test
	public void shouldSetContent() {
		AuthorContent a = builder.withContent(new Content()).build();
		assertThat(a.getContent(), instanceOf(Content.class));
	}
	
	@Test
	public void shouldSetType() {
		AuthorContent a = builder.of(AuthorType.PRINCIPAL).build();
		assertThat(a.getType(), equalTo(AuthorType.PRINCIPAL));
	}

}
