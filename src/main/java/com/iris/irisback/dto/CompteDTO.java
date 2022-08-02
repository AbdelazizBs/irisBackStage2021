package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompteDTO {
  private String id;
  private String email;
  private String password;

  public CompteDTO() {}
}
