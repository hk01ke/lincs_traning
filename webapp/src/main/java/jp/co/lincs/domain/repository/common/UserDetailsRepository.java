package jp.co.lincs.domain.repository.common;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.lincs.domain.model.common.UserDetails;
import jp.co.lincs.domain.model.common.UserProject;
import jp.co.lincs.domain.model.common.UserSkill;

@Repository
public interface UserDetailsRepository {

	public UserDetails findByUserId(String userId);

	public UserSkill findUserSkillByUserId(String userId);

	public List<UserProject> findUserProjectsByUserId(String userId);


}
