package com.goeun.dto;

public class LoginDTO
{
  private String email;
  private String password;
  private boolean useCookie;
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public boolean isUseCookie()
  {
    return this.useCookie;
  }
  
  public void setUseCookie(boolean useCookie)
  {
    this.useCookie = useCookie;
  }
  
  public String toString()
  {
    return "LoginDTO [email=" + this.email + ", password=" + this.password + ", useCookie=" + this.useCookie + "]";
  }
}
