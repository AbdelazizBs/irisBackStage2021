package com.iris.irisback.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
  private final String jwttoken;

  public JwtResponse(final String jwttoken) {
    this.jwttoken = jwttoken;
  }

  public String getToken() {
    return this.jwttoken;
  }
}
