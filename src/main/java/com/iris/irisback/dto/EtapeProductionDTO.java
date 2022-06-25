package com.iris.irisback.dto;

import com.iris.irisback.model.enums.ProductionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EtapeProductionDTO {
  private String id;
  private String nomEtape;
  private String typeEtape;
  private List<String> articlesId;
  private ProductionStatus status;
}
