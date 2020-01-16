package jp.co.lincs.domain.service.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.lincs.common.encrypt.Encrypt;
import jp.co.lincs.common.exception.FailedLoginException;
import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.repository.common.UserAuthRepository;

@Transactional
@Service
public class LoginService {

	@Autowired
	private UserAuthRepository userAuthRepository;

	public User certify(User user) throws FailedLoginException {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", user.getUserId());
		map.put("password", Encrypt.getInstance().doEncrypt(user.getPassword()));

		User effectUser = userAuthRepository.findEffect(map);

		if (effectUser == null) {
			throw new FailedLoginException();
		}

		return effectUser;
	}


}
