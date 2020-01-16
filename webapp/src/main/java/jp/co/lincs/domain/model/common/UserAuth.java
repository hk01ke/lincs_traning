package jp.co.lincs.domain.model.common;

import java.io.Serializable;

public class UserAuth implements Serializable {

	private String password;
	private String modifideCount;
	private String authId;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getModifideCount() {
		return modifideCount;
	}

	public void setModifideCount(String modifideCount) {
		this.modifideCount = modifideCount;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

}
