package com.iris.irisback.mapper;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.model.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ClientMapper {

  public static ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

//  @Mapping(target = "articlesRefIris", ignore = true)
  public abstract ClientDTO toClientDTO(Client client);
//  @Mapping(target = "articles", ignore = true)

  public abstract Client toClient(ClientDTO clientDTO);

   @AfterMapping
  void updateClientDTO(final Client client, @MappingTarget final ClientDTO clientDTO) {
//     final List<String> list =
//             client.getArticles().stream().map(Article::getRefIris).collect(toList());
//     clientDTO.setArticlesRefIris(list);
  }

}
