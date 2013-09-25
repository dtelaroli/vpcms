package org.dtelaroli.vpcms.domain.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.dtelaroli.vplus.core.exception.CrudException;
import org.dtelaroli.vplus.core.model.Model;
import org.dtelaroli.vplus.core.persistence.Dao;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class DBListCategoryExclude implements Dao {

	private final EntityManager em;

	@Inject
	public DBListCategoryExclude(EntityManager em) {
		this.em = em;
	}

	public List<Category> find(Model model) throws CrudException {
		CriteriaBuilder b = em.getCriteriaBuilder();
		CriteriaQuery<Category> q = (CriteriaQuery<Category>) b
				.createQuery(Category.class);

		Root<Category> root = (Root<Category>) q.from(Category.class);
		q.select(root).orderBy(b.asc(root.get("name")))
		.where(b.notEqual(root.get("id"), model.getId()));
		
		return em.createQuery(q).getResultList();
	}
}
