package vn.duonghao.services;

import java.util.List;

import vn.duonghao.models.UserModel;

public interface UserDAO {
	UserModel get(String username);
	void insert(UserModel user);

	void update(UserModel user);
	
	void delete(int id);
	
	List <UserModel> getAll();
	
    boolean register(String email, String password, String username, String fullname, String phone);

    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);

    boolean checkExistPhone(String phone);
    
    boolean updatePasswordByEmail(String email, String newPassword);
}
