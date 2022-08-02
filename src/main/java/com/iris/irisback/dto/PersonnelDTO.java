package com.iris.irisback.dto;

import com.iris.irisback.model.Compte;
import com.iris.irisback.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PersonnelDTO{

  private String id;
  private String cin;
  private String name;

  private String company;
  private String address;
  private String phone;
  private String country;
  private String genre;
  private Date dateNaissance;
  private Set<Role> personnelRoles;
private Compte compte;

  public PersonnelDTO() {

  }
}
