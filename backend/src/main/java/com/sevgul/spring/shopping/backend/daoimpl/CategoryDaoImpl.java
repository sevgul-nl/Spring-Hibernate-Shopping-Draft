package com.sevgul.spring.shopping.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sevgul.spring.shopping.backend.dao.CategoryDao;
import com.sevgul.spring.shopping.backend.dto.Category;

@Repository("categoryDao")
@Transactional(readOnly = false)
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sf;
/*
	private static List<Category> categories = new ArrayList<Category>();
	static {
		Category cat = new Category();
		cat.setId(1);
		cat.setCategory("Category-1");
		cat.setDescription("Some description for category-1");
		cat.setImage("cat-1.png");
		categories.add(cat);
		cat = new Category();
		cat.setId(2);
		cat.setCategory("Category-2");
		cat.setDescription("Some description for category-2");
		cat.setImage("cat-2.png");
		categories.add(cat);
		cat = new Category();
		cat.setId(3);
		cat.setCategory("Category-3");
		cat.setDescription("Some description for category-3");
		cat.setImage("cat-3.png");
		categories.add(cat);
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		
		String hqlQuery = "From Category Where active = :active";
		Query<?> query = sf.getCurrentSession().createQuery(hqlQuery);
		query.setParameter("active", true );
		return (List<Category>) query.getResultList();
	}

	@Override
	public Category get(int id) {

		return sf.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	@Transactional
	public boolean add(Category cat) {
		try {

			sf.getCurrentSession().persist(cat);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Category cat) {

		try {
			sf.getCurrentSession().update(cat);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Category cat) {
		try {
			sf.getCurrentSession().delete(cat);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
