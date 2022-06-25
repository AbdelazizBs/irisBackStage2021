package com.iris.irisback.controller;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "*")
public class MachineController {
  @Autowired MachineService machineService;

  @PostMapping("/addMachine")
  public MachineDTO addMachine(@RequestBody final MachineDTO machineDTO) throws IOException {
    return machineService.addMachine(machineDTO);
  }

  @PutMapping("/updateMachine/{idMachine}")
  public MachineDTO updateMachine(
          @RequestBody final MachineDTO machineDTO, @PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    return machineService.updateMachine(machineDTO, idMachine);
  }

  @DeleteMapping("/deleteMachine/{idMachine}")
  public ResponseEntity<Void> deleteMachine(@PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    machineService.deleteMachine(idMachine);
    return ResponseEntity.noContent().build();
  }
}
