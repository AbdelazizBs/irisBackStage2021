package com.iris.irisback.dto;


import com.iris.irisback.model.EtapeProduction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MachineDTO {
    private String id ;
    private  String nomMachine ;
    private  String reference ;
    private  String libelle ;
    private EtapeProduction  etapeProduction ;
    private String nombreConducteur ;
    private Date dateMaintenance ;
}
