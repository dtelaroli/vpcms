package org.vplus.cms.domain.model.author;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.vplus.cms.domain.model.content.Content;
import org.vplus.core.model.Model;

@Entity
public class AuthorContent extends Model {

	private static final long serialVersionUID = 7404943385179431017L;

	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Content content;
	
	private AuthorType type;

	protected Author getAuthor() {
		return author;
	}

	protected void setAuthor(Author author) {
		this.author = author;
	}

	protected Content getContent() {
		return content;
	}

	protected void setContent(Content content) {
		this.content = content;
	}

	protected AuthorType getType() {
		return type;
	}

	protected void setType(AuthorType type) {
		this.type = type;
	}
	
}