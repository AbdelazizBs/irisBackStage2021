package com.iris.irisback.mapper;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.model.Machine;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MachineMapper {

  public static MachineMapper MAPPER = Mappers.getMapper(MachineMapper.class);

  //  @Mapping(target = "etapeProduction", ignore = true)
  @Mapping(target = "nomEtapeProduction", ignore = true)
  public abstract MachineDTO toMachineDTO(Machine machine);

  @Mapping(target = "etapeProduction", ignore = true)
  public abstract Machine toMachine(MachineDTO machineDTO);

  @AfterMapping
  void updateMaachineDTO(final Machine machine, @MappingTarget final MachineDTO machineDTO) {
    machineDTO.setNomEtapeProduction(machine.getEtapeProduction().getNomEtape());
  }

  @AfterMapping
  void updateMachine(final MachineDTO machineDTO, @MappingTarget final Machine machine) {}
}
