package vn.duonghao.services;

import vn.duonghao.models.UserModel;

public interface UserService {
	UserModel login(String username, String password);
	UserModel get(String username);
}
