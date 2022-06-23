package com.iris.irisback.service;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MachineService {

    @Autowired
    MachineRepository machineRepository ;


    public MachineDTO addMachine(MachineDTO machineDTO)  throws IOException {
        final Machine machine = MachineMapper.MAPPER.toMachine(machineDTO);
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
    }


    public  MachineDTO updateMachine(MachineDTO machineDTO, String idMachine)throws IOException{
        return  machineRepository
                .findById(idMachine)
                .map(

                        machine -> {
                            machine.setNomMachine(machineDTO.getNomMachine());
                            machine.setEtapeProduction(machineDTO.getEtapeProduction());
                            machine.setDateMaintenance(machineDTO.getDateMaintenance());
                            machine.setLibelle(machineDTO.getLibelle());
                            machine.setReference(machineDTO.getReference());
                            machine.setNombreConducteur(machineDTO.getNombreConducteur());
                            return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
                        })
                .orElseThrow(() -> new NotFoundException(machineDTO.getId() + " not found"));

    }

    public void deleteMachine(String  id) throws IOException{
       machineRepository.deleteById(id);
    }



}
