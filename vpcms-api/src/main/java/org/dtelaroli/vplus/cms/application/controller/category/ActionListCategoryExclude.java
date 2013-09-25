package org.dtelaroli.vplus.cms.application.controller.category;

import org.dtelaroli.vpcms.domain.dao.DBListCategoryExclude;
import org.dtelaroli.vplus.core.controller.AbstractAction;
import org.dtelaroli.vplus.core.controller.ActionFacade;
import org.dtelaroli.vplus.core.exception.CrudException;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class ActionListCategoryExclude extends AbstractAction {

	public ActionListCategoryExclude(ActionFacade actionFacade) {
		super(actionFacade);
	}

	@Override
	protected Object operation() throws CrudException {
		return persistence().use(DBListCategoryExclude.class).find(model());
	}

}
