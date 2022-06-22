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
    public MachineDTO addMachine(@RequestBody Machine machine)  throws IOException {
        return machineService.addMachine(machine);
    }

    @PutMapping("/updateMachine/{id}")
    public  MachineDTO updateMachine(@RequestBody Machine machine ,@PathVariable String  id ){
        return machineService.updateMachine(machine,id);
    }

    @DeleteMapping("/deleteMachine/{id}")
    public  void deleteMachine(@PathVariable String  id ){
         machineService.deleteMachine(id);
    }

   }

