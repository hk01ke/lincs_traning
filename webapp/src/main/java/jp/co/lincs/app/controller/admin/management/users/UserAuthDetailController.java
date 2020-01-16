package jp.co.lincs.app.controller.admin.management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lincs.app.form.admin.management.users.UserDetailForm;
import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.model.session.AdminSession;
import jp.co.lincs.domain.service.admin.management.users.UserAuthDetailService;

@Controller
public class UserAuthDetailController {

	@Autowired
	private UserAuthDetailService userAuthDetailService;
	
	@Autowired
	private AdminSession adminSession;
	
	@RequestMapping(value = "/admin/management/users/userAuthDetail")
	public String detail(UserDetailForm form,Model model) {
		User user = userAuthDetailService.findByUserId(form.getUserId());
		model.addAttribute("user", user);
		return "thymeleaf/admin/management/users/userAuthDetail";
	}
	
	@RequestMapping(value = "/admin/management/users/userAuthEdit")
	public String edit(UserDetailForm form,Model model) {
//		User user = userAuthDetailService.findByUserId(form.getUserId());
//		model.addAttribute("user", user);
		return "thymeleaf/admin/management/users/userAuthEdit";
	}
	
	@RequestMapping(value = "/admin/management/users/userAuthEditExecute")
	public String editExecute(UserDetailForm form,Model model) {
//		User user = userAuthDetailService.findByUserId(form.getUserId());
//		model.addAttribute("user", user);
		return "thymeleaf/admin/management/users/userAuthEditExecute";
	}



}
