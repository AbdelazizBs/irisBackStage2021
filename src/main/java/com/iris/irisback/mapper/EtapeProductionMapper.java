package com.iris.irisback.mapper;


import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.EtapeProduction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class EtapeProductionMapper {

    public static EtapeProductionMapper MAPPER = Mappers.getMapper(EtapeProductionMapper.class);


    public abstract EtapeProductionDTO toEtapeProductionDTO(EtapeProduction etapeProduction);


    public abstract EtapeProduction toEtapeProduction(EtapeProductionDTO etapeProductionDTO);

}
