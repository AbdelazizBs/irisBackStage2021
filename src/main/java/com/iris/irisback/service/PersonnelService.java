package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.CompteDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.mapper.CompteMapper;
import com.iris.irisback.mapper.PersonnelMapper;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.Compte;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.model.Role;
import com.iris.irisback.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonnelService {
  final PersonnelRepository personnelRepository;
  final MachineRepository machineRepository;
  final CommandeRepository commandeRepository;
  @Autowired
    CompteRepository compteRepository;
  @Autowired BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired RoleRepository roleRepository;

  public PersonnelService(
      final PersonnelRepository personnelRepository,
      final MachineRepository machineRepository,
      final CommandeRepository commandeRepository) {
    this.personnelRepository = personnelRepository;
    this.machineRepository = machineRepository;
    this.commandeRepository = commandeRepository;
  }

  public PersonnelDTO addPersonnel(
      final String cin,
      final String name,
      final String company,
      final String address,
      final String phone,
      final String country,
      final String genre,
      final Date dateNaissance,
      final String email,
      final String password) {
    //    final Compte compteExist =
    //        compteRepository
    //            .findCompteByEmail(email)
    //            .orElseThrow(() -> new NotFoundException(email + " not found"));
    //    if (compteExist != null) {
    //      throw new NotFoundException(
    //          "There is already a personnel registered with this email " + email);
    //    }
    final Role userRole = roleRepository.findByRole("USER");
    final PersonnelDTO personnelDTO = new PersonnelDTO();
    personnelDTO.setCin(cin);
    personnelDTO.setName(name);
    personnelDTO.setCompany(company);
    personnelDTO.setAddress(address);
    personnelDTO.setPhone(phone);
    personnelDTO.setCountry(country);
    personnelDTO.setGenre(genre);
    personnelDTO.setDateNaissance(dateNaissance);
    personnelDTO.setPersonnelRoles(new HashSet<Role>(Arrays.asList(userRole)));
    final CompteDTO compteDTO = new CompteDTO();
    compteDTO.setEmail(email);
    compteDTO.setPassword(bCryptPasswordEncoder.encode(password));
    final Compte compte = CompteMapper.MAPPER.toCompte(compteDTO);
    CompteMapper.MAPPER.toCompteDTO(compteRepository.save(compte));
    personnelDTO.setCompte(compte);
    final Personnel personnel = PersonnelMapper.MAPPER.toPersonnel(personnelDTO);
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
  }

  public List<String> getNomPersonnel() throws IOException {
    return personnelRepository.findAll().stream()
        .map(Personnel::getName)
        .collect(Collectors.toList());
  }

  public PersonnelDTO login(final String email, final String password) {
      final Compte compte =
        compteRepository
            .findCompteByEmail(email )
                .orElseThrow(
                        () -> {
                            log.error("cannot found personnel with email '{}'", email);
                            return new NotFoundException("Resource not Found");
                        });
      if (bCryptPasswordEncoder.matches(password,compte.getPassword())) {
          return PersonnelMapper.MAPPER.toPersonnelDTO(
              personnelRepository
                  .findPersonnelByCompte(compte)
                  .orElseThrow(
                      () -> {
                        log.error("cannot found user with email '{}'", email);
                        return new NotFoundException("Resource not Found");
                      }));
      }
return null ;
  }



  public void deletePersonnel(final String idPersonnel) {
    personnelRepository.deleteById(idPersonnel);
  }

  public PersonnelDTO getPersonnelById(final String idPersonnel) {
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository.findPersonnelById(idPersonnel));
  }

  public PersonnelDTO getPersonnelByEmail(final String email) {
    final Compte compte = compteRepository.findCompteByEmail(email).orElseThrow(
            () -> {
                log.error("cannot found personnel with email '{}'", email);
                return new NotFoundException("Resource not Found");
            });
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository
            .findPersonnelByCompte(compte)
            .orElseThrow(
                () -> {
                  log.error("cannot found user with username '{}'", compte);
                  return new NotFoundException("Resource not Found");
                }));
  }

  public PersonnelDTO updatePersonnel(
      final String cin,
      final String name,
      final String company,
      final String address,
      final String phone,
      final String country,
      final String genre,
      final Date dateNaissance,
      final String email,
      final String password,
      final String idPersonnel) {
    return personnelRepository
        .findById(idPersonnel)
        .map(
            personnel -> {
              personnel.setAddress(address);
              personnel.setCompany(company);
              personnel.setCountry(country);
              personnel.setName(name);
              personnel.setDateNaissance(dateNaissance);
              personnel.setGenre(genre);
              personnel.setCin(cin);
              personnel.setPhone(phone);
              final Compte compte =
                  compteRepository.findCompteByEmail(personnel.getCompte().getEmail()).orElseThrow(
                          () -> {
                              log.error("cannot found personnel with email '{}'", email);
                              return new NotFoundException("Resource not Found");
                          });;
              compte.setEmail(email);
              compte.setPassword(bCryptPasswordEncoder.encode(password));
              compteRepository.save(compte);
                personnel.setCompte(compte);
              return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
            })
        .orElseThrow(() -> new NotFoundException(idPersonnel + " not found"));
  }

  public CommandeDTO inverse(final String idCommande) {
    final Commande commande = commandeRepository.findCommandeById(idCommande)
            .orElseThrow(() -> new NotFoundException("Commande Id  " + idCommande + " not found"));
      ;
    commande.setAccepted(!commande.getAccepted());
    return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
  }
}
