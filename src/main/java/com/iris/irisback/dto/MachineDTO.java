package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MachineDTO {
  private String id;
  private String designation;
  private String reference;
  private String nomEtapeProduction;
  private String nombreConducteur;
  private Date dateMaintenance;
  private Date dateCreation;
  private String etat;
  private List<String> nomPersonnel;

  public MachineDTO() {}

  // private List<Personnel> personnel;
}
