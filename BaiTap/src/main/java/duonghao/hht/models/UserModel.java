package duonghao.hht.models;

import java.io.Serializable;

public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Username;
	private String Password;
	boolean isSeller;
	boolean isAdmin;
	String img;
	public UserModel(int iD, String username, String password, boolean isSeller, boolean isAdmin, String img) {
		super();
		ID = iD;
		Username = username;
		Password = password;
		this.isSeller = isSeller;
		this.isAdmin = isAdmin;
		this.img = img;
	}
	public UserModel() {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isSeller() {
		return isSeller;
	}
	public void setSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
