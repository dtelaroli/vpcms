package org.vplus.cms.domain.model.author;

import org.vplus.cms.domain.model.content.Content;

public class AuthorBuilder {

	private AuthorContent authorContent;

	private AuthorBuilder() {
		authorContent = new AuthorContent();
	}
	
	public static AuthorBuilder authorContent() {
		return new AuthorBuilder();
	}

	public AuthorContent build() {
		return authorContent;
	}

	public AuthorBuilder withAuthor(Author author) {
		authorContent.setAuthor(author);
		return this;
	}

	public AuthorBuilder withContent(Content content) {
		authorContent.setContent(content);
		return this;
	}

	public AuthorBuilder of(AuthorType type) {
		authorContent.setType(type);
		return this;
	}

}
