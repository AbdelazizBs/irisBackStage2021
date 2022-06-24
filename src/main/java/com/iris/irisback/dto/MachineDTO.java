package com.iris.irisback.dto;


import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.model.Personnel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

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
   // private List<Personnel> personnel;
}
