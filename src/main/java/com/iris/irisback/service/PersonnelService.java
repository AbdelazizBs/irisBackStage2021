package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.mapper.PersonnelMapper;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.Machine;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.repository.CommandeRepository;
import com.iris.irisback.repository.MachineRepository;
import com.iris.irisback.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
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
    final Machine machine = machineRepository.findMachineByNomMachine(personnelDTO.getNomMachine());
    personnel.setMachine(machine);
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
  }

  public PersonnelDTO login(final String login, final String password) throws IOException {
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository.findPersonnelByLoginAndPassword(login, password));
  }

  public void deletePersonnel(final String idPersonnel) throws IOException {
    personnelRepository.deleteById(idPersonnel);
  }

  public PersonnelDTO getPersonnelById(final String idPersonnel) throws IOException {
    return PersonnelMapper.MAPPER.toPersonnelDTO(
        personnelRepository.findPersonnelById(idPersonnel));
  }

  public PersonnelDTO getPersonnelByLogin(final String login) throws IOException {
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.findPersonnelByLogin(login));
  }

  public PersonnelDTO updatePersonnel(
      final String cin,
      final String firstName,
      final String lastName,
      final String company,
      final String address,
      final String phone,
      final String country,
      final String genre,
      final Date dateNaissance,
      final String nomMachine,
      final String login,
      final String password,
      final String idPersonnel)
      throws IOException {
    return personnelRepository
        .findById(idPersonnel)
        .map(
            personnel -> {
              personnel.setAddress(address);
              personnel.setCompany(company);
              personnel.setCountry(country);
              personnel.setFirstName(firstName);
              personnel.setLastName(lastName);
              personnel.setDateNaissance(dateNaissance);
              personnel.setGenre(genre);
              personnel.setCin(cin);
              personnel.setLogin(login);
              personnel.setPassword(password);
              personnel.setPhone(phone);
              final Machine machine = machineRepository.findMachineByNomMachine(nomMachine);
              personnel.setMachine(machine);
              return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
            })
        .orElseThrow(() -> new NotFoundException(idPersonnel + " not found"));
  }

  public CommandeDTO inverse(final String idCommande) throws IOException {
    final Commande commande = commandeRepository.findCommandeById(idCommande);
    if (commande.getAccepted() == false) {
      commande.setAccepted(true);
    } else {
      commande.setAccepted(false);
    }
    return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
  }
}
