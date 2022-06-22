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


    public MachineDTO addMachine(Machine machine)  throws IOException {
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
    }


    public  MachineDTO updateMachine(Machine machine, String id){
        return  machineRepository
                .findById(id)
                .map(

                        machine1 -> {
                            machine1.setNomMachine(machine.getNomMachine());
                            machine1.setEtapeProduction(machine.getEtapeProduction());
                            machine1.setDateMaintenance(machine.getDateMaintenance());
                            machine1.setLibelle(machine.getLibelle());
                            machine1.setReference(machine.getReference());
                            machine1.setNombreConducteur(machine.getNombreConducteur());
                            return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine1));
                        })
                .orElseThrow(() -> new NotFoundException(machine.getId() + " not found"));

    }

    public void deleteMachine(String  id){
       machineRepository.deleteById(id);
    }



}
