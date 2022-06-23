package com.iris.irisback.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString

@AllArgsConstructor
@Document(collection = "machine")
public class Machine {
    @Id
    private String id ;
    private  String nomMachine ;
    private  String reference ;
    private  String libelle ;
    private EtapeProduction etapeProduction ;
    private String nombreConducteur ;
    private Date dateMaintenance ;
    private List<Personnel> personnel;

}
