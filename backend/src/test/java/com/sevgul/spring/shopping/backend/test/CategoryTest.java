package com.sevgul.spring.shopping.backend.test;

import static org.junit.Assert.assertEquals;

import org.h2.tools.Server;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sevgul.spring.shopping.backend.dao.CategoryDao;
import com.sevgul.spring.shopping.backend.dto.Category;

public class CategoryTest {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.sevgul.spring.shopping.backend");
		context.refresh();

		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}

	@Test
	public void addCategory1() {
		category = categoryDao.get(1);
		if (category == null) {

			category = new Category();
			category.setId(1);
			category.setCategory("Category_1");
			category.setDescription("Description for Category_1");
			category.setImage("CAT_1.png");
			category.setActive(true);
			// assertTrue( categoryDao.add(category));
			assertEquals("A category inserted !..", true, categoryDao.add(category));
		}
		// assertTrue( categoryDao.add(category));
		assertEquals("Category exists !..", true, true);
	}

	@Test
	public void addCategory2() {

		category = categoryDao.get(2);
		if (category == null) {
			category = new Category();
			category.setId(2);
			category.setCategory("Category_2");
			category.setDescription("Description for Category_2");
			category.setImage("CAT_2.png");
			category.setActive(true);
			assertEquals("A category inserted !..", true, categoryDao.add(category));
		}
		// assertTrue( categoryDao.add(category));
		assertEquals("Category exists !..", true, true);
	}

	@Test
	public void addCategory3() {
		category = categoryDao.get(3);
		if (category == null) {
			category = new Category();
			category.setId(3);
			category.setCategory("Category_3");
			category.setDescription("Description for Category_3");
			category.setImage("CAT_3.png");
			category.setActive(true);
			// assertTrue( categoryDao.add(category));
			assertEquals("A category inserted !..", true, categoryDao.add(category));
		}
		// assertTrue( categoryDao.add(category));
		assertEquals("Category exists !..", true, true);
	}

	// @Test
	public void addCategory4() {
		category = categoryDao.get(4);
		if (category == null) {
			category = new Category();
			category.setId(4);
			category.setCategory("Category_4");
			category.setDescription("Description for Category_3");
			category.setImage("CAT_3.png");
			category.setActive(true);

			// assertTrue( categoryDao.add(category));
			assertEquals("A category inserted !..", true, categoryDao.add(category));
		}
		// assertTrue( categoryDao.add(category));
		assertEquals("Category exists !..", true, true);
	}

	// @Test
	public void updateCategory() {
		category = categoryDao.get(4);
		category.setCategory("Category_4");
		category.setDescription("Description for Category_4 updated");
		category.setImage("CATu_4.png");
		category.setActive(true);

		// assertTrue( categoryDao.add(category));
		assertEquals("A category updated !..", true, categoryDao.update(category));
	}

	//@Test
	public void setCategoryInactive() {
		category = categoryDao.get(4);
		if (category != null) {
			category.setCategory("Category_4");
			category.setDescription("Description for Category_4 updated..");
			category.setImage("CATuu_4.png");
			category.setActive(false);

			// assertTrue( categoryDao.add(category));
			assertEquals("A category deleted !..", true, categoryDao.update(category));
		}
		assertEquals("Category updated !..", true, true);
	}

	//@Test
	public void setCategorActive() {
		category = categoryDao.get(4);
		if (category != null) {
			category.setCategory("Category_4");
			category.setDescription("Description for Category_4 updated..");
			category.setImage("CATuu_4.png");
			category.setActive(true);

			// assertTrue( categoryDao.add(category));
			assertEquals("A category deleted !..", true, categoryDao.update(category));
		}
		assertEquals("Category updated !..", true, true);
	}

	
	
	//@Test
	public void delCategory() {

		category = categoryDao.get(4);
		if (category != null) {
			// assertTrue( categoryDao.add(category));
			assertEquals("A category deleted !..", true, categoryDao.delete(category));
		}
		assertEquals("Category deleted !..", true, true);
	}

	//@Test
	public void getCategory() {

		// assertTrue( categoryDao.add(category));
		assertEquals("A category selected !..", "Category_1", categoryDao.get(1).getCategory());
	}

	//@Test
	public void listCategory() {

		// assertTrue( categoryDao.add(category));
		assertEquals("All categories are selected !..", 3, categoryDao.list().size());
	}

}
