package com.iris.irisback.mapper;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class MachineMapper {

@Autowired
    EtapeProductionRepository etapeProductionRepository ;
    public static MachineMapper MAPPER = Mappers.getMapper(MachineMapper.class);

   //  @Mapping(target = "etapeProduction", ignore = true)
    public abstract MachineDTO toMachineDTO(Machine machine);

    public abstract Machine toMachine(MachineDTO machineDTO);

/*    @AfterMapping
        void updateMaachineDTO(final Machine machine, @MappingTarget final MachineDTO machineDTO) {
            machineDTO.setEtapeProduction(machine.getEtapeProduction().getNomEtape());
        }

 @AfterMapping
    void updateMachine(final MachineDTO machineDTO, @MappingTarget final Machine machine) {
        final EtapeProduction etapeProduction = new EtapeProduction();
        machine.setEtapeProduction(etapeProductionRepository.findEtapeProductionByNomEtape(machineDTO.getEtapeProduction()));
        machine.setEtapeProduction(etapeProduction);
    }
*/

}
