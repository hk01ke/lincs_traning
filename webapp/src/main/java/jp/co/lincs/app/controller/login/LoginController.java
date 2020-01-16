package jp.co.lincs.app.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.lincs.app.form.login.LoginForm;
import jp.co.lincs.common.exception.FailedLoginException;
import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.model.session.SessionData;
import jp.co.lincs.domain.service.login.LoginService;

@Controller
public class LoginController {

    private static final Logger logger =
            LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	@Autowired
	private SessionData sessionData;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated LoginForm form, BindingResult result, Model model) throws FailedLoginException {
		User user = new User();
		user.setUserId(form.getUserId());
		user.setPassword(form.getUserPassword());
		User loginUser = null;
		try {
			loginUser = loginService.certify(user);
			// セッションにログインユーザー情報を格納
			sessionData.setLoginUser(loginUser);
			// 初回パスワードであれば
			if ("0".equals(loginUser.getModifideCount())) {
				// パスワード変更画面を表示
				// TODO 2次フェーズにて開発
			}
		} catch (FailedLoginException ex) {
			logger.info("ログインエラー", ex);
			// ログインエラー時　ログイン画面を表示
			return "thymeleaf/login/login";
		}
		// ログイン成功時
		// 管理者ユーザーであれば
		// TODO 権限を増やす場合の共通実装を考える必要がある。3次フェーズに実装
		if ("admin".equals(loginUser.getAuthId())) {
			return "forward:admin/top";
		}
		// 一般ユーザーの場合
		return "forward:user/top";
	}

}
