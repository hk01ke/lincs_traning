package jp.co.lincs.app.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin/top")
	public String top(Model model) {
		return "thymeleaf/admin/top";
	}


}
