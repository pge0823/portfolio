package com.goeun.service;

import com.goeun.domain.UserVO;
import com.goeun.dto.LoginDTO;
import com.goeun.persistence.BlogDAO;
import com.goeun.persistence.UserDAO;

import java.util.Date;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
  @Inject
  private UserDAO dao;
  @Inject
  private BlogDAO blogDAO;
  
  public void register(UserVO vo)
    throws Exception
  {
    dao.register(vo);
    
    blogDAO.setDefaultInformation(vo.getEmail());
  }
  
  public int duplicationCheck(String email)
    throws Exception
  {
    return dao.duplicationCheck(email);
  }
  
  public UserVO login(LoginDTO dto)
    throws Exception
  {
    return dao.login(dto);
  }

@Override
public void keepLogin(String email, String sessionId, Date next) throws Exception {
	dao.keepLogin(email, sessionId, next);
}

@Override
public UserVO checkLoginBefore(String value) throws Exception {
	return dao.checkUserWithSessionKey(value);
}
}
