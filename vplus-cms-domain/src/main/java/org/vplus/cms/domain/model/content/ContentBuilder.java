package org.vplus.cms.domain.model.content;

import java.util.Arrays;

import org.vplus.cms.domain.model.author.AuthorContent;
import org.vplus.cms.domain.model.categorization.Category;
import org.vplus.cms.domain.model.categorization.Tag;

public class ContentBuilder {

	private Content post;

	private ContentBuilder() {
		post = new Content();
	}

	public static ContentBuilder content() {
		return new ContentBuilder();
	}

	public Content build() {
		return post;
	}

	public ContentBuilder withTitle(String title) {
		post.setTitle(title);
		return this;
	}

	public ContentBuilder withContent(String content) {
		post.setContent(content);
		return this;
	}

	public ContentBuilder withTags(Tag... tags) {
		post.setTags(Arrays.asList(tags));
		return this;
	}

	public ContentBuilder withCategories(Category... categories) {
		post.setCategories(Arrays.asList(categories));
		return this;
	}

	public ContentBuilder withAuthors(AuthorContent... authors) {
		post.setAuthors(Arrays.asList(authors));
		return this;
	}
	
}