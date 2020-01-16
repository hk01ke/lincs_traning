package jp.co.lincs.app.form.login;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class LoginForm implements Serializable {

	@NotNull
	private String userId;
	@NotNull
	private String userPassword;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
