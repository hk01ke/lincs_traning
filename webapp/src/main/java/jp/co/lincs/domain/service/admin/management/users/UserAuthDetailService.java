package jp.co.lincs.domain.service.admin.management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.repository.common.UserAuthRepository;

@Transactional
@Service
public class UserAuthDetailService {

	@Autowired
	private UserAuthRepository userAuthRepository;

	public User findByUserId(String userId) {
		return userAuthRepository.findByUserId(userId);
	}

}
