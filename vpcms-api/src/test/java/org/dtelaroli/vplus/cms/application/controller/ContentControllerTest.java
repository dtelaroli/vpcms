package org.dtelaroli.vplus.cms.application.controller;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.dtelaroli.vplus.core.mock.CrudMock;
import org.junit.Before;
import org.junit.Test;

public class ContentControllerTest {

	ContentController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new ContentController(new CrudMock());
	}

	@Test
	public void shouldCreateController() {
		assertThat(controller, notNullValue());
	}
}