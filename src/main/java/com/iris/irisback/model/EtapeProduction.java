package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "etapeProduction")
public class EtapeProduction {
  @Id private String id;
  private String nomEtape;
  private String typeEtape;
  // private List<Article> articles;
  //   private  Machine machine ;

  public EtapeProduction() {}
}
