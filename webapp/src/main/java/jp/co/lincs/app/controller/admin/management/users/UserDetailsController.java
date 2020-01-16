package jp.co.lincs.app.controller.admin.management.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lincs.app.form.admin.management.users.UserDetailForm;

@Controller
public class UserDetailsController {
	
	
	
	@RequestMapping(value = "/admin/management/users/userDetail")
	public String add(UserDetailForm form,Model model) {

		return "thymeleaf/admin/management/users/userDetail";
	}


}
