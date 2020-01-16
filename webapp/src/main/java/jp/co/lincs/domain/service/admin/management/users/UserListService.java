package jp.co.lincs.domain.service.admin.management.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.repository.admin.management.users.UserListRepository;

@Transactional
@Service
public class UserListService {

	@Autowired
	private UserListRepository userListRepository;

	public List<User> findEffect() {
		List<User> effectUserList = userListRepository.findEffect();
		return effectUserList;
	}


}
