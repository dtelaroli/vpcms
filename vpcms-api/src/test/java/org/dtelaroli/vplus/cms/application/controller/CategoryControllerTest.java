package org.dtelaroli.vplus.cms.application.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.dtelaroli.vplus.cms.application.controller.category.ActionListCategoryExclude;
import org.dtelaroli.vplus.core.controller.ActionFacade;
import org.dtelaroli.vplus.core.mock.CrudMock;
import org.junit.Before;
import org.junit.Test;

public class CategoryControllerTest {

	CategoryController controller;

	@Before
	public void setUp() throws Exception {
		CrudMock mock = new CrudMock();
		ActionFacade em = null;
		when(mock.use(ActionListCategoryExclude.class)).thenReturn(new ActionListCategoryExclude(em));
		controller = new CategoryController(mock);
	}

	@Test
	public void shouldCreateController() {
		assertThat(controller, notNullValue());
	}
	
	@Test
	public void shouldReturnListExceptCategory() {
		//controller.findExclude(1L);
	}

}