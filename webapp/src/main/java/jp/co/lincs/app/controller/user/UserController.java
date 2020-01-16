package jp.co.lincs.app.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.model.common.UserDetails;
import jp.co.lincs.domain.model.session.SessionData;
import jp.co.lincs.domain.service.common.UserDetailsService;

@Controller
public class UserController {

	@Autowired
	private SessionData sessionData;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping(value = "/user/top")
	public String top(Model model) {
		User loginUser = sessionData.getLoginUser();
		UserDetails userDetails = userDetailsService.findByUserId(loginUser);
		System.out.println("os");
		System.out.println(userDetails.getUserSkill().getOs());
		model.addAttribute("userDetails", userDetails);
		return "thymeleaf/user/top";
	}


}
