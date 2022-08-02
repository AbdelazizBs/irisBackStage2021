package com.iris.irisback.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "compte")
public class Compte {
  @Id private String id;

  private String email;

  private String password;
}
