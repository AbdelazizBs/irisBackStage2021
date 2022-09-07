package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "article")
public class Article {
  @Id private String id;
  private String refIris;
  private String refClient;
    private String designation;
    private List<EtapeProduction> etapeProductions;
  private Client client;
 private OrdreFabrication ordreFabrication ;


  public Article() {}
}
