package org.dtelaroli.vpcms.domain.model.content;

import java.util.Arrays;

import org.dtelaroli.vpcms.domain.model.author.AuthorContent;
import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.dtelaroli.vpcms.domain.model.categorization.Tag;

public class ContentBuilder {

	private Content content;

	private ContentBuilder() {
		content = new Content();
	}

	public static ContentBuilder content() {
		return new ContentBuilder();
	}

	public Content build() {
		return content;
	}

	public ContentBuilder withTitle(String title) {
		content.setTitle(title);
		return this;
	}

	public ContentBuilder withContent(String content) {
		this.content.setContent(content);
		return this;
	}
	
	public ContentBuilder withExcerpt(String excerpt) {
		content.setExcerpt(excerpt);
		return this;
	}

	public ContentBuilder withTags(Tag... tags) {
		content.setTags(Arrays.asList(tags));
		return this;
	}

	public ContentBuilder withCategories(Category... categories) {
		content.setCategories(Arrays.asList(categories));
		return this;
	}

	public ContentBuilder withAuthors(AuthorContent... authors) {
		content.setAuthors(Arrays.asList(authors));
		return this;
	}
	
}