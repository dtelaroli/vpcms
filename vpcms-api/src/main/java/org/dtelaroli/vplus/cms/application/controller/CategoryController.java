package org.dtelaroli.vplus.cms.application.controller;

import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.dtelaroli.vplus.cms.application.controller.category.ActionListCategoryExclude;
import org.dtelaroli.vplus.core.controller.Crud;
import org.dtelaroli.vplus.core.controller.Scaffold;
import org.dtelaroli.vplus.core.exception.CrudException;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class CategoryController extends Scaffold<Category> {

	public CategoryController(Crud crud) {
		super(crud);
	}
	
	@Get("/{model.id}/list-exclude.json")
	public void findExclude(Category model) throws CrudException {
		ActionListCategoryExclude action = (ActionListCategoryExclude) crud().use(ActionListCategoryExclude.class);
		action.withModel(model).render();	
	}

}