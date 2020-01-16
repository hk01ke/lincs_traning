package jp.co.lincs.app.controller.admin.management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.lincs.app.form.admin.management.users.UserAddForm;
import jp.co.lincs.common.encrypt.Encrypt;
import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.model.session.AdminSession;
import jp.co.lincs.domain.service.admin.management.users.UserAddService;

@Controller
public class UserAddController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

	@Autowired
	private AdminSession adminSession;

	@Autowired
	private UserAddService userAddService;

	@RequestMapping(value = "/admin/management/users/userAdd")
	public String add(UserAddForm form,Model model) {
		return "thymeleaf/admin/management/users/userAdd";
	}

	@RequestMapping(value = "/admin/management/users/userAddConfirm", method = RequestMethod.POST,
			produces="text/plain;charset=UTF-8")
	public String confirm(@Validated UserAddForm form, BindingResult result, Model model) {
	   if (result.hasErrors()) {
			model.addAttribute("validationError", "不正な値が入力されました。");
			return add(form, model);
	   }
		adminSession.setUserAddForm(form);
		return "thymeleaf/admin/management/users/userAddConfirm";
	}

	@RequestMapping(value = "/admin/management/users/userAddExecute", method = RequestMethod.POST)
	public String execute(Model model) {
		UserAddForm userAddForm = adminSession.getUserAddForm();
		if (userAddService.existUserId(userAddForm.getUserId())) {
			model.addAttribute("validationError", "ユーザーIDが存在する。");
			return add(userAddForm, model);
		}
		User user = new User();
		user.setUserId(userAddForm.getUserId());
		user.setUserName(userAddForm.getUserName());
		user.setAuthId(userAddForm.getUserAuth());
		user.setPassword(Encrypt.getInstance().doEncrypt(userAddForm.getUserPassword_1()));
		try {
			userAddService.insert(user);
		} catch(Exception e) {
			model.addAttribute("validationError", "ユーザーIDが存在する。");
			model.addAttribute("userAddForm", userAddForm);
			return add(userAddForm, model);
		}
		return "thymeleaf/admin/management/users/userAddExecute";
	}



}
