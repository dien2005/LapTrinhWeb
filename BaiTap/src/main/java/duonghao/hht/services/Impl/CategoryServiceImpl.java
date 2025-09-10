package duonghao.hht.services.Impl;

import java.util.List;

import duonghao.hht.entity.Category;
import duonghao.hht.services.ICategoryDAO;
import duonghao.hht.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	ICategoryDAO categoryDao = new CategoryDAOImpl();
	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		categoryDao.insert(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}

	@Override
	public void delete(int categoryId) throws Exception {
		// TODO Auto-generated method stub
		categoryDao.delete(categoryId);
	}

	@Override
	public Category findById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.findById(categoryId);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return categoryDao.count();
	}

	@Override
	public List<Category> findByCategoryname(String categoryname) {
		// TODO Auto-generated method stub
		return categoryDao.findByCategoryname(categoryname);
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return categoryDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> findALL() {
		// TODO Auto-generated method stub
		return categoryDao.findALL();
	}

}
