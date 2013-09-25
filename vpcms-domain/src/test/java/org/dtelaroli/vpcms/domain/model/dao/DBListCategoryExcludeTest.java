package org.dtelaroli.vpcms.domain.model.dao;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.dtelaroli.vpcms.domain.dao.DBListCategoryExclude;
import org.dtelaroli.vpcms.domain.model.categorization.Category;
import org.dtelaroli.vplus.core.exception.CrudException;
import org.dtelaroli.vplus.core.util.TestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBListCategoryExcludeTest {

	private TestUtil util;
	private DBListCategoryExclude dbListCategoryExclude;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		util = TestUtil.create();
		util.from(Category.class).init();
		dbListCategoryExclude = new DBListCategoryExclude(util.entityManager());
	}
	
	@After
	public void tearDown() throws Exception {
		util.cleanAndDestroy();
	}

	@Test
	public void shouldReturn2Items() throws CrudException {
		List<Category> list = dbListCategoryExclude.find(new Category(1L));
		assertThat(list.size(), equalTo(2));
		assertThat(list.get(0).getId(), equalTo(3L));
		assertThat(list.get(1).getId(), equalTo(2L));
	}

}
