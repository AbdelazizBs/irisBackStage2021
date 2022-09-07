package com.iris.irisback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class LigneCommandDTO {
    private String id;
    private String numCmd;
    private String refIris;
    private String qte;
    private Date delai ;


    public LigneCommandDTO() {

    }
}
