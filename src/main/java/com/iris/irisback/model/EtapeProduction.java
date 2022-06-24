package com.iris.irisback.model;

import com.iris.irisback.model.enums.ProductionStatus;
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
@Document(collection = "etapeProduction")
public class EtapeProduction {
  @Id private String id;
  private String nomEtape;
  private String typeEtape;
  private List<Article> articles;
  private ProductionStatus status;
  //   private  Machine machine ;

  public EtapeProduction() {}
}
