package duonghao.hht.services;

import java.util.List;

import duonghao.hht.entity.Category;

public interface ICategoryService {
	void insert(Category category);

	void update(Category category);

	void delete(int categoryId) throws Exception;

	Category findById(int categoryId);

	int count();

	List<Category> findByCategoryname(String categoryname);

	List<Category> findAll(int page, int pagesize);

	List<Category> findALL();

}
