package com.iris.irisback.mapper;

import com.iris.irisback.dto.CompteDTO;
import com.iris.irisback.model.Compte;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CompteMapper {
  public static CompteMapper MAPPER = Mappers.getMapper(CompteMapper.class);

  public abstract CompteDTO toCompteDTO(Compte compte);

  public abstract Compte toCompte(CompteDTO compteDTO);

  @AfterMapping
  void updateCompteDTO(final Compte compte, @MappingTarget final CompteDTO compteDTO) {}

  @AfterMapping
  void updateCompte(final CompteDTO compteDTO, @MappingTarget final Compte compte) {}
}
