package vn.duonghao.services.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.duonghao.config.SQLConnection;
import vn.duonghao.models.UserModel;
import vn.duonghao.services.UserDAO;

public class UserDAOImpl implements UserDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public UserModel get(String username) {
		String sql = "SELECT * FROM [Users] WHERE username = ? ";
		UserModel user = null;
		try {
			conn = new SQLConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUserName(rs.getString("username"));
				user.setFullName(rs.getString("fullname"));
				user.setPassWord(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return user;
		}
		return user;
	}
    @Override
    public void insert(UserModel user) {
        String sql = "INSERT INTO Users(userName, fullName, email, phone, passWord, roleid) VALUES(?,?,?,?,?,?)";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getPassWord());
            ps.setInt(6, user.getRoleid());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(UserModel user) {
        String sql = "UPDATE Users SET userName=?, fullName=?, email=?, phone=?, roleid=? WHERE id=?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setInt(5, user.getRoleid());
            ps.setInt(6, user.getId());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 // READ all
    @Override
    public List <UserModel> getAll() {
        List <UserModel> list = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setPassWord(rs.getString("password"));
                user.setRoleid(rs.getInt("roleid"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public boolean register(String email, String password, String username, String fullname, String phone) {
        if (checkExistEmail(email) || checkExistUsername(username) || checkExistPhone(phone)) {
            return false; // đã tồn tại
        }
        UserModel user = new UserModel();
        user.setEmail(email);
        user.setPassWord(password);
        user.setUserName(username);
        user.setFullName(fullname);
        user.setPhone(phone);
        user.setRoleid(3); // mặc định role 3 = user thường
        insert(user);
        return true;
    }
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Users WHERE id=?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT 1 FROM Users WHERE email = ?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT 1 FROM Users WHERE username = ?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT 1 FROM Users WHERE phone = ?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, phone);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean updatePasswordByEmail(String email, String newPassword) {
        String sql = "UPDATE Users SET passWord=? WHERE email=?";
        try (Connection conn = new SQLConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
