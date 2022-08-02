package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "personnel")
public class Personnel {
  @Id private String id;
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
  //  private Role role;
}
