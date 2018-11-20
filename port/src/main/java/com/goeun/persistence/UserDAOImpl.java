package com.goeun.persistence;

import com.goeun.domain.UserVO;
import com.goeun.dto.LoginDTO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO
{
  private String namespace = "com.goeun.mapper.UserMapper";
  
  @Inject
  private SqlSession session;
  
  public void register(UserVO vo) throws Exception
  {
    session.insert(namespace + ".register", vo);
  }
  
  public int duplicationCheck(String email) throws Exception
  {
    return session.selectOne(namespace + ".duplicationCheck", email);
  }
  
  public UserVO login(LoginDTO dto) throws Exception
  {
    return session.selectOne(namespace + ".login", dto);
  }

@Override
public void keepLogin(String email, String sessionId, Date next) throws Exception {
	Map<String, Object> paramMap = new HashMap<String, Object>();
	paramMap.put("email", email);
	paramMap.put("sessionId", sessionId);
	paramMap.put("next", next);
	session.update(namespace+".keepLogin", paramMap);
}

@Override
public UserVO checkUserWithSessionKey(String value) throws Exception {
	return session.selectOne(namespace+".checkUserWithSessionKey", value);
}
}
