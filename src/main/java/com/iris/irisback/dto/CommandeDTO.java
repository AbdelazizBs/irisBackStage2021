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
  private List<String> codeArticles;
  private Boolean accepted = false;

  public CommandeDTO() {}
}
