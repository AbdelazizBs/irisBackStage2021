package com.iris.irisback.controller;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/personnel")
@CrossOrigin(origins = "*")
public class PersonnelController {
  @Autowired PersonnelService personnelService;

  @PostMapping("/addPersonnel")
  public PersonnelDTO addPersonnel(
      @RequestParam final String cin,
      @RequestParam final String name,
      @RequestParam final String company,
      @RequestParam final String address,
      @RequestParam final String phone,
      @RequestParam final String country,
      @RequestParam final String genre,
      @RequestParam final Date dateNaissance,
      @RequestParam final String email,
      @RequestParam final String password)
      throws IOException {
    return personnelService.addPersonnel(
        cin, name, company, address, phone, country, genre, dateNaissance, email, password);
    //     return  clientRepository.save(client);
  }

  @GetMapping("/getNomPersonnel")
  public List<String> getNomPersonnel() throws IOException {
    return personnelService.getNomPersonnel();
  }

  @GetMapping("/getPersonnelById/{idPersonnel}")
  public PersonnelDTO getPersonnelById(
      @PathVariable(value = "idPersonnel") final String idPersonnel) throws IOException {
    return personnelService.getPersonnelById(idPersonnel);
  }

  @GetMapping("/getPersonnelByEmail")
  public PersonnelDTO getPersonnelByEmail(@RequestParam(value = "email") final String login)
      throws IOException {
    return personnelService.getPersonnelByEmail(login);
  }

  @PostMapping("/login")
  public PersonnelDTO login(
      @Valid @RequestParam(value = "email") final String email,
      @RequestParam(value = "password") final String password) {
    return personnelService.login(email, password);
  }

  //  @PutMapping("/updatePersonnel/{idPersonnel}")
  //  public PersonnelDTO updatePersonnel(
  //      @RequestParam final PersonnelDTO personnelDTO,
  //      @PathVariable(value = "idPersonnel") final String idPersonnel)
  //      throws IOException {
  //    return personnelService.updatePersonnel(personnelDTO, idPersonnel);
  //  }

  @PutMapping("/updatePersonnel/{idPersonnel}")
  public PersonnelDTO updatePersonnel(
      @RequestParam final String cin,
      @RequestParam final String name,
      @RequestParam final String company,
      @RequestParam final String address,
      @RequestParam final String phone,
      @RequestParam final String country,
      @RequestParam final String genre,
      @RequestParam final Date dateNaissance,
      @RequestParam final String email,
      @RequestParam final String password,
      @PathVariable(value = "idPersonnel") final String idPersonnel)
      throws IOException {
    return personnelService.updatePersonnel(
        cin,
        name,
        company,
        address,
        phone,
        country,
        genre,
        dateNaissance,
        email,
        password,
        idPersonnel);
  }

  @DeleteMapping("/deletePersonnel/{idPersonnel}")
  public ResponseEntity<Void> deletePersonnel(
      @PathVariable(value = "idPersonnel") final String idPersonnel) throws IOException {
    personnelService.deletePersonnel(idPersonnel);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/inverse/{idCommande}")
  public CommandeDTO acceptCmd(@PathVariable(value = "idCommande") final String idCommande)
      throws IOException {
    return personnelService.inverse(idCommande);
  }
}
