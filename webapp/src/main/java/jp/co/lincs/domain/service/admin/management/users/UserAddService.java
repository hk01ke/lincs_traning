package jp.co.lincs.domain.service.admin.management.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.repository.common.UserAuthRepository;

@Transactional
@Service
public class UserAddService {

	@Autowired
	private UserAuthRepository userAuthRepository;
	@Autowired
	private PlatformTransactionManager transactionManager;

	public boolean existUserId(String userId) {

		User user = userAuthRepository.findByUserId(userId);
		return (user != null);
	}

	public void insert(User user) {
		TransactionStatus txStatus =
			    transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			userAuthRepository.insertUser(user);
			userAuthRepository.insertUserAuth(user);
			userAuthRepository.insertUserPasswordHistory(user);

			System.out.println(user.getUserName());
			System.out.println(user.getPassword());
			System.out.println(user.getAuthId());

			transactionManager.commit(txStatus);
		} catch(Exception e) {
			transactionManager.rollback(txStatus);
			throw e;
		}
	}

}
