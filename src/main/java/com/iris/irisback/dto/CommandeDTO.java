package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CommandeDTO {
  private String id;
  private Date dateCmd;
  private String numCmd;
  private String typeCmd;
  private String nomClient;

  // private  List<Article> articles ;
  private List<String> articlesId;
  private Boolean accepted = false;

  public CommandeDTO() {}
}
