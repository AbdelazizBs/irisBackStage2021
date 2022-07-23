package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PersonnelDTO {

  private String id;
  private String cin;
  private String name;

  private String company;
  private String address;
  private String phone;
  private String country;
  private String genre;

  private Date dateNaissance;

  private String login;
  private String password;
}
