package jp.co.lincs.domain.repository.common;

import java.util.Map;

import org.springframework.stereotype.Repository;

import jp.co.lincs.domain.model.common.User;

@Repository
public interface UserAuthRepository {

	public User findEffect(Map<String, Object> map);
	public User findByUserId(String userId);

	public int insertUser(User user);
	public int insertUserAuth(User user);
	public int insertUserPasswordHistory(User user);

}
