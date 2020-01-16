package jp.co.lincs.domain.model.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jp.co.lincs.app.form.admin.management.users.UserAddForm;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AdminSession {

	private UserAddForm userAddForm;

	public UserAddForm getUserAddForm() {
		return userAddForm;
	}

	public void setUserAddForm(UserAddForm userAddForm) {
		this.userAddForm = userAddForm;
	}



}
