package org.vplus.cms.domain.model.content;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.NotEmpty;
import org.vplus.cms.domain.model.author.AuthorContent;
import org.vplus.cms.domain.model.categorization.Category;
import org.vplus.cms.domain.model.categorization.Tag;
import org.vplus.core.model.ModelPlus;

@Entity
public class Content extends ModelPlus {

	private static final long serialVersionUID = 5226503447879244064L;

	@NotEmpty
	@Size(max = 150)
	private String title;

	@Lob
	@NotEmpty
	private String content;

	@ManyToMany(fetch = FetchType.LAZY)
	@BatchSize(size = 10)
	@Size(min = 1)
	private Collection<Tag> tags;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	@Size(min = 1)
	private Collection<Category> categories;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "content")
	@BatchSize(size = 5)
	@Size(min = 1)
	private Collection<AuthorContent> authors;

	public Content() {
	}

	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	protected Collection<Category> getCategories() {
		return categories;
	}

	protected void setCategories(Collection<Category> categories) {
		this.categories = categories;
	}

	protected void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	protected Collection<AuthorContent> getAuthors() {
		return authors;
	}

	protected void setAuthors(Collection<AuthorContent> authors) {
		this.authors = authors;
	}
	
}