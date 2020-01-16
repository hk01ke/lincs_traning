package jp.co.lincs.domain.model.common;

import java.io.Serializable;
import java.util.List;

public class UserDetails implements Serializable {

	private UserSkill userSkill;
	private List<UserProject> userProjects;


	public UserSkill getUserSkill() {
		return userSkill;
	}
	public void setUserSkill(UserSkill userSkill) {
		this.userSkill = userSkill;
	}
	public List<UserProject> getUserProjects() {
		return userProjects;
	}
	public void setUserProjects(List<UserProject> userProjects) {
		this.userProjects = userProjects;
	}

}
