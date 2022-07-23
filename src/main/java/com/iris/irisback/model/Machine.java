package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "machine")
public class Machine {
  @Id private String id;

  @Pattern(regexp = "^[a-zA-Z]*$")
  private String designation;

  private String reference;
  private EtapeProduction etapeProduction;
  private String nombreConducteur;
  private Date dateMaintenance;
  private Date dateCreation;
  private String etat;
  private List<Personnel> personnel;

  public Machine() {}
}
