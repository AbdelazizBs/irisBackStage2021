package com.iris.irisback.mapper;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;
@Mapper
public abstract class CommandeMapper {


    public static CommandeMapper MAPPER = Mappers.getMapper(CommandeMapper.class);

    // @Mapping(target = "password", ignore = true)
   // @Mapping(target = "password", ignore = true)
    public abstract CommandeDTO toCommandeDTO(Commande commande);

    public abstract Commande toCommande(CommandeDTO commandeDTO);

}
