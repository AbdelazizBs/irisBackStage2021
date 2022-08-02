package com.iris.irisback.mapper;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ClientMapper {

  public static ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

  // @Mapping(target = "password", ignore = true)
//  @Mapping(target = "password", ignore = true)
  public abstract ClientDTO toClientDTO(Client client);

  public abstract Client toClient(ClientDTO clientDTO);

  /* @AfterMapping
  void updateClientDTO(final Client client, @MappingTarget final ClientDTO clientDTO) {
      clientDTO.setId(client.getLocation().getCity());
  }*/

}
