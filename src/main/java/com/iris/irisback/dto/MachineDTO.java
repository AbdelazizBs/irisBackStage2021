package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MachineDTO {
  private String id;
  private String nomMachine;
  private String reference;
  private String libelle;
  private String nomEtapeProduction;
  private String nombreConducteur;
  private Date dateMaintenance;
  // private List<Personnel> personnel;
}
