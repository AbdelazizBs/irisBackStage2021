package com.iris.irisback.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@ToString

@AllArgsConstructor
@Document(collection = "commande")
public class Commande {
    @Id
    private String id ;
    private Date dateCmd ;
    private  String numCmd ;
    private  String typeCmd ;
    private  Client client;

}