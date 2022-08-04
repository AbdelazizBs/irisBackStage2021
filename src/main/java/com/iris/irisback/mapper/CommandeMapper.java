package com.iris.irisback.mapper;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Commande;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper
public abstract class CommandeMapper {

  public static CommandeMapper MAPPER = Mappers.getMapper(CommandeMapper.class);

  @Mapping(target = "articles", ignore = true)
  @Mapping(target = "nomClient", ignore = true)
  public abstract CommandeDTO toCommandeDTO(Commande commande);

  @Mapping(target = "articles", ignore = true)
  @Mapping(target = "client", ignore = true)
  public abstract Commande toCommande(CommandeDTO commandeDTO);

  @AfterMapping
  void updateCommandeDTO(final Commande commande, @MappingTarget final CommandeDTO commandeDTO) {
    final List<String> list =
        commande.getArticles().stream().map(Article::getRefIris).collect(toList());
    commandeDTO.setArticles(list);
    commandeDTO.setNomClient(commande.getClient().getNom());
  }

  @AfterMapping
  void updateCommande(final CommandeDTO commandeDTO, @MappingTarget final Commande commande) {}
}
