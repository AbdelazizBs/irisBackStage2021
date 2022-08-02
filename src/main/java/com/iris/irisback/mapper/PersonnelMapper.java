package com.iris.irisback.mapper;

import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.model.Personnel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class PersonnelMapper {
  public static PersonnelMapper MAPPER = Mappers.getMapper(PersonnelMapper.class);

  //  @Mapping(target = "email", ignore = true)
  //  @Mapping(target = "password", ignore = true)
  //  @Mapping(target = "etapeProduction", ignore = true)
  public abstract PersonnelDTO toPersonnelDTO(Personnel personnel);

  //  @Mapping(target = "compte", ignore = true)
  public abstract Personnel toPersonnel(PersonnelDTO personnelDTO);

  @AfterMapping
  void updatePersonnelDTO(
      final Personnel personnel, @MappingTarget final PersonnelDTO personnelDTO) {
    //    personnelDTO.setEmail(personnel.getCompte().getEmail());
    //    personnelDTO.setPassword(personnel.getCompte().getPassword());
  }

  @AfterMapping
  void updatePersonnel(final PersonnelDTO personnelDTO, @MappingTarget final Personnel personnel) {}
}
