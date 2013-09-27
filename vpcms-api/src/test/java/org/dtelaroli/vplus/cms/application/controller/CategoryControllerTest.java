package org.dtelaroli.vplus.cms.application.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.dtelaroli.vplus.cms.application.controller.category.ActionListCategoryExclude;
import org.dtelaroli.vplus.core.controller.ActionFacade;
import org.dtelaroli.vplus.core.mock.ActionFacadeMock;
import org.dtelaroli.vplus.core.mock.CrudMock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryControllerTest {

	CategoryController controller;
	@Mock private CrudMock mock;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ActionFacade em = new ActionFacadeMock();
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