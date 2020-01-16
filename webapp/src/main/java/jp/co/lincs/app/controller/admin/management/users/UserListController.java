package jp.co.lincs.app.controller.admin.management.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.service.admin.management.users.UserListService;

@Controller
public class UserListController {

	@Autowired
	private UserListService userListService;

	@RequestMapping(value = "/admin/management/users/userList")
	public String top(Model model) {
		List<User> users =userListService.findEffect();
		System.out.println(users.size());
		model.addAttribute("users", users);
		return "thymeleaf/admin/management/users/userList";
	}



}
