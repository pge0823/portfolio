package com.goeun.domain;

public class UserVO
  extends Email
{
  private String name;
  private String password;
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String toString()
  {
    return "UserVO [name=" + this.name + ", email=" + this.email + ", password=" + this.password + "]";
  }
}