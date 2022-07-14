package com.iris.irisback.service;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import com.iris.irisback.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineService {

  final MachineRepository machineRepository;
  final ClientRepository clientRepository;
  final EtapeProductionRepository etapeProductionRepository;

  public MachineService(
      final MachineRepository machineRepository,
      final EtapeProductionRepository etapeProductionRepository,
      final ClientRepository clientRepository) {
    this.machineRepository = machineRepository;
    this.etapeProductionRepository = etapeProductionRepository;
    this.clientRepository = clientRepository;
  }

  public MachineDTO addMachine(
      final String nomMachine,
      final String reference,
      final String nomEtapeProduction,
      final String nombreConducteur,
      final Date dateCreation,
      final Date dateMaintenance,
      final String etat)
      throws IOException {
    final MachineDTO machineDTO = new MachineDTO();
    machineDTO.setNomMachine(nomMachine);
    machineDTO.setReference(reference);
    machineDTO.setEtat(etat);
    machineDTO.setNomEtapeProduction(nomEtapeProduction);
    machineDTO.setDateCreation(dateCreation);
    machineDTO.setDateMaintenance(dateMaintenance);
    machineDTO.setNombreConducteur(nombreConducteur);
    final Machine machine = MachineMapper.MAPPER.toMachine(machineDTO);
    final EtapeProduction etapeProduction =
        etapeProductionRepository.findEtapeProductionByNomEtape(nomEtapeProduction);
    machine.setEtapeProduction(etapeProduction);
    machine.setEtapeProduction(etapeProduction);
    return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
  }

  public MachineDTO getMachineById(final String idMachine) throws IOException {
    return MachineMapper.MAPPER.toMachineDTO(machineRepository.findMachineById(idMachine));
  }

  public List<String> getNomMachine() throws IOException {
    return machineRepository.findAll().stream()
        .map(Machine::getNomMachine)
        .collect(Collectors.toList());
  }

  public List<MachineDTO> getLisMachine() throws IOException {
    return machineRepository.findAll().stream()
        .map(machine -> MachineMapper.MAPPER.toMachineDTO(machine))
        .collect(Collectors.toList());
  }

  public MachineDTO updateMachine(
      final String nomMachine,
      final String reference,
      final String nomEtapeProduction,
      final String nombreConducteur,
      final Date dateCreation,
      final Date dateMaintenance,
      final String etat,
      final String idMachine)
      throws IOException {
    return machineRepository
        .findById(idMachine)
        .map(
            machine -> {
              machine.setNomMachine(nomMachine);
              final EtapeProduction etapeProduction =
                  etapeProductionRepository.findEtapeProductionByNomEtape(nomEtapeProduction);
              machine.setEtapeProduction(etapeProduction);
              machine.setDateMaintenance(dateMaintenance);
              machine.setReference(reference);
              machine.setDateCreation(dateCreation);
              machine.setEtat(etat);
              machine.setNombreConducteur(nombreConducteur);
              return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
            })
        .orElseThrow(() -> new NotFoundException(idMachine + " not found"));
  }

  public void deleteMachine(final String id) throws IOException {
    machineRepository.deleteById(id);
  }
}
