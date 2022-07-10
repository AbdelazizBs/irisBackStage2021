package com.iris.irisback.controller;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "*")
public class MachineController {
  @Autowired MachineService machineService;

  @PostMapping("/addMachine")
  public MachineDTO addMachine(
      @RequestParam final String nomMachine,
      @RequestParam final String reference,
      @RequestParam final String nomEtapeProduction,
      @RequestParam final String nombreConducteur,
      @RequestParam final Date dateMaintenance,
      @RequestParam final Date dateCreation,
      @RequestParam final String etat)
      throws IOException {
    return machineService.addMachine(
        nomMachine,
        reference,
        nomEtapeProduction,
        nombreConducteur,
        dateCreation,
        dateMaintenance,
        etat);
  }

  @GetMapping("/getMachineById/{idMachine}")
  public MachineDTO getPersonnelById(@PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    return machineService.getPersonnelById(idMachine);
  }

  @GetMapping("/getNomMachine")
  public List<String> getNomMachine() throws IOException {
    return machineService.getNomMachine();
  }

  @GetMapping("/getListMachine")
  public List<MachineDTO> getLisMachine() throws IOException {
    return machineService.getLisMachine();
  }

  @PutMapping("/updateMachine/{idMachine}")
  public MachineDTO updateMachine(
      @RequestParam final String nomMachine,
      @RequestParam final String reference,
      @RequestParam final String nomEtapeProduction,
      @RequestParam final String nombreConducteur,
      @RequestParam final Date dateMaintenance,
      @RequestParam final Date dateCreation,
      @RequestParam final String etat,
      @PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    return machineService.updateMachine(
        nomMachine,
        reference,
        nomEtapeProduction,
        nombreConducteur,
        dateCreation,
        dateMaintenance,
        etat,
        idMachine);
  }

  @DeleteMapping("/deleteMachine/{idMachine}")
  public ResponseEntity<Void> deleteMachine(
      @PathVariable(value = "idMachine") final String idMachine) throws IOException {
    machineService.deleteMachine(idMachine);
    return ResponseEntity.noContent().build();
  }
}
