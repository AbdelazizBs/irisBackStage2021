package com.iris.irisback.dto;

import com.iris.irisback.model.Machine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class PersonnelDTO {

    private String id ;
    private String  idMach ;
    private  String cin ;
    private String firstName ;
    private String lastName ;
    private String company ;
    private String address ;
    private String phone ;
    private String country ;
    private  String genre ;
    private Date dateNaissance ;
    private Machine machine ;
}
