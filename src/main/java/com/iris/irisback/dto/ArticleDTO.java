package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {

  private String id;
  private String refIris;
  private String refClient;
  private String designation;
  private List<String> nomEtapeProductions;
  private String clientName;
  private String idOf;


  public ArticleDTO() {}
}
