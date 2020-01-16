package jp.co.lincs.domain.repository.admin.management.users;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.lincs.domain.model.common.User;

@Repository
public interface UserListRepository {

	public List<User> findEffect();

}
