package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO {

  private String id;
  private String nom;
  private String company;
  private String address;
  private String phone;
  private String country;
  private String email;
  private String reference;

//  private String password;
  private Boolean active;

  public ClientDTO() {

  }
  // private List<String> commandesId;
}
