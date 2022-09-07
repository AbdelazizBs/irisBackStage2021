package com.iris.irisback.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "LigneCommand")
public class LigneCommand {
    @Id
    private String id;
    private Commande commande;
    private Article article;
    private String qte;
    private Date delai ;
}
