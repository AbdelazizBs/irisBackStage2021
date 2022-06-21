package com.iris.irisback.dto;



import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ClientDTO  {

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

}
