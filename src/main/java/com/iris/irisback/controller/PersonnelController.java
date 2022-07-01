package com.iris.irisback.controller;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/personnel")
@CrossOrigin(origins = "*")
public class PersonnelController {
  @Autowired PersonnelService personnelService;

  @PostMapping("/addPersonnel")
  public PersonnelDTO addPersonnel(@RequestBody final PersonnelDTO personnelDTO)
      throws IOException {
    return personnelService.addPersonnel(personnelDTO);
    //     return  clientRepository.save(client);
  }

  @PutMapping("/updatePersonnel/{idPersonnel}")
  public PersonnelDTO updatePersonnel(
      @RequestBody final PersonnelDTO personnelDTO,
      @PathVariable(value = "idPersonnel") final String idPersonnel)
      throws IOException {
    return personnelService.updatePersonnel(personnelDTO, idPersonnel);
  }

  @DeleteMapping("/deletePersonnel/{idPersonnel}")
  public ResponseEntity<Void> deletePersonnel(
      @PathVariable(value = "idPersonnel") final String idPersonnel) throws IOException {
    personnelService.deletePersonnel(idPersonnel);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/acceptCmd")
  public CommandeDTO acceptCmd(@RequestBody final CommandeDTO commandeDTO) throws IOException {
    return personnelService.acceptCmd(commandeDTO);
  }
}
