package duonghao.hht.services;

import java.util.List;

import duonghao.hht.entity.Category;

public interface ICategoryDAO {
	int count();

	List<Category> findByCategoryname(String categoryname);

	List<Category> findAll(int page, int pagesize);

	List<Category> findALL();

	Category findById(int categoryId);

	void delete(int categoryid) throws Exception;

	void update(Category category);

	void insert(Category category);
	
}
