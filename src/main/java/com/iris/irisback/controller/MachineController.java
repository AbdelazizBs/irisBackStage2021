package com.iris.irisback.controller;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "*")
public class MachineController {
  @Autowired MachineService machineService;

  @PostMapping("/addMachine")
  public MachineDTO addMachine(
      @RequestParam final String designation,
      @RequestParam final String reference,
      @RequestParam final String nomEtapeProduction,
      @RequestParam final String nombreConducteur,
      @RequestParam final Date dateMaintenance,
      @RequestParam final Date dateCreation,
      @RequestParam final List<String> nomPersonnel,
      @RequestParam final String etat)
        {
    return machineService.addMachine(
        designation,
        reference,
        nomEtapeProduction,
        nombreConducteur,
        dateCreation,
        dateMaintenance,
        nomPersonnel,
        etat);
  }

  @GetMapping("/getMachineById/{idMachine}")
  public MachineDTO getMachineById(@PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    return machineService.getMachineById(idMachine);
  }

  @GetMapping("/getNomMachine")
  public List<String> getNomMachine() throws IOException {
    return machineService.getNomMachine();
  }

  @GetMapping("/getEtat")
  public List<String> getEtat() {
    final List<String> etats = new ArrayList<>();
    etats.add("En repos");
    etats.add("En marche");
    etats.add("En panne");
    etats.add("En Maintenance");
    return etats;
  }

  @GetMapping("/getListMachine")
  public List<MachineDTO> getLisMachine() throws IOException {
    return machineService.getLisMachine();
  }

  @PutMapping("/updateMachine/{idMachine}")
  public MachineDTO updateMachine(
      @RequestParam final String designation,
      @RequestParam final String reference,
      @RequestParam final String nomEtapeProduction,
      @RequestParam final String nombreConducteur,
      @RequestParam final Date dateMaintenance,
      @RequestParam final Date dateCreation,
      @RequestParam final String etat,
      @RequestParam final List<String> nomPersonnel,
      @PathVariable(value = "idMachine") final String idMachine)
      throws IOException {
    return machineService.updateMachine(
        designation,
        reference,
        nomEtapeProduction,
        nombreConducteur,
        dateCreation,
        dateMaintenance,
        nomPersonnel,
        etat,
        idMachine);
  }

  @DeleteMapping("/deleteMachine/{idMachine}")
  public ResponseEntity<Void> deleteMachine(
      @PathVariable(value = "idMachine") final String idMachine) throws IOException {
    machineService.deleteMachine(idMachine);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/setEtatEnRepos/{idMachine}")
  public MachineDTO setEtatEnRepos(@PathVariable(value = "idMachine") final String idMachine) {
    return machineService.setEtatEnRepos(idMachine);
  }
  @PutMapping("/setEtatEnMaintenance/{idMachine}")
  public MachineDTO setEtatEnMaintenance(@PathVariable(value = "idMachine") final String idMachine) {
    return machineService.setEtatEnMaintenance(idMachine);
  }
  @PutMapping("/setEtatEnPanne/{idMachine}")
  public MachineDTO setEtatEnPanne(@PathVariable(value = "idMachine") final String idMachine) {
    return machineService.setEtatEnPanne(idMachine);
  }
  @PutMapping("/setEtatEnmarche/{idMachine}")
  public MachineDTO setEtatEnmarche(@PathVariable(value = "idMachine") final String idMachine) {
    return machineService.setEtatEnmarche(idMachine);
  }
}
