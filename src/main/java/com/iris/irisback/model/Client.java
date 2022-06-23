package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@ToString

@AllArgsConstructor
@Document(collection = "client")
public class Client {
    @Id
    private String id ;
    private String firstName ;
    private String lastName ;
    private String company ;
    private String address ;
    private String phone ;
    private String country ;
    private String email ;
    private String login ;
        private String password ;
  private List<Commande> commandes;


    public Client() {

    }
}
