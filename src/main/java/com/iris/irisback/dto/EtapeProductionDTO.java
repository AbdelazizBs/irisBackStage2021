package com.iris.irisback.dto;

import com.iris.irisback.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class EtapeProductionDTO {
    private String id ;
    private  String nomEtape ;
    private String typeEtape  ;
    private List<Article> articles;
}
