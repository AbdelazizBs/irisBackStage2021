package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "ordreFabrication")
public class OrdreFabrication {
  @Id private String id;
  private Date dateLancement;
  private Date debutHeure;
  private Date finHeure;
  private String commentaire;
  private String qtePremierChoix;
  private String qteNonConforme;
  private Article article;
}
