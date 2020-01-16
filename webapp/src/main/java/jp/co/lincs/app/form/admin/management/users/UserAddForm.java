package jp.co.lincs.app.form.admin.management.users;

import javax.validation.constraints.NotNull;

public class UserAddForm {

	@NotNull
	private String userId;
	@NotNull
	private String userName;
	@NotNull
	private String userPassword_1;
	@NotNull
	private String userPassword_2;
	@NotNull
	private String userAuth;



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword_1() {
		return userPassword_1;
	}
	public void setUserPassword_1(String userPassword_1) {
		this.userPassword_1 = userPassword_1;
	}
	public String getUserPassword_2() {
		return userPassword_2;
	}
	public void setUserPassword_2(String userPassword_2) {
		this.userPassword_2 = userPassword_2;
	}
	public String getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}





}
