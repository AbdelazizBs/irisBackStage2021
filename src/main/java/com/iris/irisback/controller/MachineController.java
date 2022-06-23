package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.MachineRepository;
import com.iris.irisback.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "*")
public class MachineController {
    @Autowired
    MachineService machineService ;
    @PostMapping("/addMachine")
    public MachineDTO addMachine(@RequestBody MachineDTO machineDTO )  throws IOException {
        return machineService.addMachine(machineDTO);
    }

    @PutMapping("/updateMachine/{idMachine}")
    public  MachineDTO updateMachine(@RequestBody MachineDTO machineDTO ,@PathVariable(value = "idMachine") String  idMachine ) throws IOException {
        return machineService.updateMachine(machineDTO,idMachine);
    }

    @DeleteMapping("/deleteMachine/{idMachine}")
    public  void deleteMachine(@PathVariable(value = "idMachine") String  idMachine ) throws IOException {
         machineService.deleteMachine(idMachine);
    }

   }

