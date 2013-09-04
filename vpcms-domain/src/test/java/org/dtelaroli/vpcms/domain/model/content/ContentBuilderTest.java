package org.dtelaroli.vpcms.domain.model.content;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vpcms.domain.model.author.AuthorContent;
import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.dtelaroli.vpcms.domain.model.categorization.Tag;
import org.dtelaroli.vpcms.domain.model.content.Content;
import org.dtelaroli.vpcms.domain.model.content.ContentBuilder;
import org.junit.Before;
import org.junit.Test;

public class ContentBuilderTest {

	ContentBuilder builder;
	
	@Before
	public void setUp() throws Exception {
		builder = ContentBuilder.content();
	}

	@Test
	public void shouldCreateBuilder() {
		assertThat(builder, notNullValue());
	}
	
	@Test
	public void shouldReturnPostInstance() {
		assertThat(builder.build(), instanceOf(Content.class));
	}
	
	@Test
	public void shouldSetTitle() {
		Content post = builder.withTitle("title").build();
		assertThat(post.getTitle(), equalTo("title"));
	}
	
	@Test
	public void shouldSetContent() {
		Content post = builder.withContent("content").build();
		assertThat(post.getContent(), equalTo("content"));
	}
	
	@Test
	public void shouldAddTagsOnContent() {
		Content post = builder.withTags(new Tag(), new Tag()).build();
		assertThat(post.getTags().size(), equalTo(2));
	}
	
	@Test
	public void shouldAddCategoriesOnContent() {
		Content post = builder.withCategories(new Category(), new Category(), new Category()).build();
		assertThat(post.getCategories().size(), equalTo(3));
	}
	
	@Test
	public void shouldAddAuthorsOnContent() {
		Content post = builder.withAuthors(new AuthorContent(), new AuthorContent()).build();
		assertThat(post.getAuthors().size(), equalTo(2));
	}

}