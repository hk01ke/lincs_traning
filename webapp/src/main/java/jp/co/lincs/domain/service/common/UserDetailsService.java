package jp.co.lincs.domain.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.lincs.domain.model.common.User;
import jp.co.lincs.domain.model.common.UserDetails;
import jp.co.lincs.domain.model.common.UserProject;
import jp.co.lincs.domain.model.common.UserSkill;
import jp.co.lincs.domain.repository.common.UserDetailsRepository;

@Transactional
@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public UserDetails findByUserId(User user) {
		UserDetails userDetails = new UserDetails();
		UserSkill userSkill = userDetailsRepository.findUserSkillByUserId(user.getUserId());
		List<UserProject> userProjects = userDetailsRepository.findUserProjectsByUserId(user.getUserId());
		userDetails.setUserSkill(userSkill);
		userDetails.setUserProjects(userProjects);
		return userDetails;
	}



}
