package com.iris.irisback.dto;

import com.iris.irisback.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class CommandeDTO {
    private String id ;
    private Date dateCmd ;
    private  String numCmd ;
    private  String typeCmd ;
    private Client client;
}
