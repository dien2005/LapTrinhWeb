package vn.duonghao.services;

import vn.duonghao.models.UserModel;

public interface UserDAO {
	UserModel get(String username);
}
