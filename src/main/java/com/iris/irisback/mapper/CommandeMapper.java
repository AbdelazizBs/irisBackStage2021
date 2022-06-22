package com.iris.irisback.mapper;


import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.Date;
@Mapper
public abstract class CommandeMapper {


    public static CommandeMapper MAPPER = Mappers.getMapper(CommandeMapper.class);

   // @Mapping(target = "articleId", ignore = true)
    public abstract CommandeDTO toCommandeDTO(Commande commande);


     //@Mapping(target = "article", ignore = true)
    public abstract Commande toCommande(CommandeDTO commandeDTO);

/*

    @AfterMapping
    void updateArticleDTO(final Commande commande , @MappingTarget final CommandeDTO commandeDTO  ) {
        commandeDTO.setArticleId(commande.getArticle().getId());
    }


    @AfterMapping
    void updateCommande(final CommandeDTO commandeDTO, @MappingTarget final Commande commande) {


    }*/

}
