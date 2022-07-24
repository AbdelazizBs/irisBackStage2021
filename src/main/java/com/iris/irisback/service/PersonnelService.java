package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.mapper.PersonnelMapper;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.repository.CommandeRepository;
import com.iris.irisback.repository.MachineRepository;
import com.iris.irisback.repository.PersonnelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonnelService {
  final PersonnelRepository personnelRepository;
  final MachineRepository machineRepository;

  final CommandeRepository commandeRepository;

  public PersonnelService(
      final PersonnelRepository personnelRepository,
      final MachineRepository machineRepository,
      final CommandeRepository commandeRepository) {
    this.personnelRepository = personnelRepository;
    this.machineRepository = machineRepository;
    this.commandeRepository = commandeRepository;
  }

  public PersonnelDTO addPersonnel(final PersonnelDTO personnelDTO) throws IOException {
    final Personnel personnel = PersonnelMapper.MAPPER.toPersonnel(personnelDTO);
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
  }

  public List<String> getNomPersonnel() throws IOException {
    return personnelRepository.findAll().stream()
        .map(Personnel::getName)
        .collect(Collectors.toList());
  }

  public PersonnelDTO login(final String login, final String password) {
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository
            .findPersonnelByLoginAndPassword(login, password)
            .orElseThrow(
                () -> {
                  log.error("cannot found user with username '{}'", login);
                  return new NotFoundException("Resource not Found");
                }));
  }

  public void deletePersonnel(final String idPersonnel) {
    personnelRepository.deleteById(idPersonnel);
  }

  public PersonnelDTO getPersonnelById(final String idPersonnel) {
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository.findPersonnelById(idPersonnel));
  }

  public PersonnelDTO getPersonnelByLogin(final String login) {
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.findPersonnelByLogin(login));
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
      final String login,
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
              personnel.setLogin(login);
              personnel.setPassword(password);
              personnel.setPhone(phone);
              return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
            })
        .orElseThrow(() -> new NotFoundException(idPersonnel + " not found"));
  }

  public CommandeDTO inverse(final String idCommande) {
    final Commande commande = commandeRepository.findCommandeById(idCommande);
    commande.setAccepted(!commande.getAccepted());
    return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
  }
}
