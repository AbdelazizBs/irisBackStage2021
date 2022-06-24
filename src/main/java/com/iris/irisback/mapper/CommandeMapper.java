package com.iris.irisback.mapper;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
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

  @Mapping(target = "articlesId", ignore = true)
  @Mapping(target = "clientId", ignore = true)
  public abstract CommandeDTO toCommandeDTO(Commande commande);

  @Mapping(target = "articles", ignore = true)
  @Mapping(target = "client", ignore = true)
  public abstract Commande toCommande(CommandeDTO commandeDTO);

  @AfterMapping
  void updateCommandeDTO(final Commande commande, @MappingTarget final CommandeDTO commandeDTO) {
    final List<String> list = commande.getArticles().stream().map(Article::getId).collect(toList());
    commandeDTO.setArticlesId(list);
    commandeDTO.setClientId(commande.getClient().getId());
  }

  @AfterMapping
  void updateCommande(final CommandeDTO commandeDTO, @MappingTarget final Commande commande) {
    final Client client = new Client();
    client.setId(commandeDTO.getClientId());
    commande.setClient(client);
  }
}
