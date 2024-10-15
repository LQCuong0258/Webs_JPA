package vn.Syaoran.services;

import java.util.List;
import java.util.Locale.Category;

public interface ICategoryService {
	
	int count();

	List<Category> findAll(int page, int pagesize);

	List<Category> findByCategoryName(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);
}
