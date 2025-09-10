package duonghao.hht.services.Impl;

import java.util.List;

import duonghao.hht.config.JPAConfig;
import duonghao.hht.entity.Category;
import duonghao.hht.services.ICategoryDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CategoryDAOImpl implements ICategoryDAO {

	@Override
	public int count() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Category c";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}

	@Override
	public List<Category> findByCategoryname(String categoryname) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT c FROM Category c WHERE c.categoryname like: categoryname";
		TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
		query.setParameter("categoryname", "%" + categoryname + "%");
		return query.getResultList();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		query.setFirstResult(page*pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public List<Category> findALL() {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	@Override
	public Category findById(int categoryId) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class, categoryId);
		return category;
	}

	@Override
	public void delete(int categoryid) throws Exception {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Category category = enma.find(Category.class, categoryid);
			if(category != null)
			{
				enma.remove(category);
			}else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		}catch (Exception e) {
			// TODO: handle 
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally
		{
			enma.close();
		}
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stu
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally
		{
			enma.close();
		}
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		}catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}

}
