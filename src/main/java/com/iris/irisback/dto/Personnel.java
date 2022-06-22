package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class Personnel {

    private String id ;
    private String  idMachine ;
    private  String cin ;
    private String firstName ;
    private String lastName ;
    private String company ;
    private String address ;
    private String phone ;
    private String country ;
    private  String genre ;
    private Date dateNaissance ;
}
