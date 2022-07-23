package com.iris.irisback.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {
  private String username;
  private String password;
  // default constructor for JSON Parsing
  public JwtRequest() {}

  public JwtRequest(final String username, final String password) {
    this.setUsername(username);
    this.setPassword(password);
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }
}
