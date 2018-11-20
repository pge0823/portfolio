package com.goeun.persistence;

import java.util.Date;

import com.goeun.domain.UserVO;
import com.goeun.dto.LoginDTO;

public interface UserDAO
{
  public void register(UserVO paramUserVO) throws Exception;
  
  public int duplicationCheck(String paramString) throws Exception;
  
  public UserVO login(LoginDTO paramLoginDTO) throws Exception;
  
  public void keepLogin(String email, String sessionId, Date next) throws Exception;
  
  public UserVO checkUserWithSessionKey(String value) throws Exception;
}