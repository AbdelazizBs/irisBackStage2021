package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EtapeProductionDTO {
  private String id;
  private String nomEtape;
  private String typeEtape;

  public EtapeProductionDTO() {}
}
