package com.iris.irisback.service;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.EtapeProductionRepository;
import com.iris.irisback.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MachineService {

  final MachineRepository machineRepository;

  final EtapeProductionRepository etapeProductionRepository;

  public MachineService(
      final MachineRepository machineRepository,
      final EtapeProductionRepository etapeProductionRepository) {
    this.machineRepository = machineRepository;
    this.etapeProductionRepository = etapeProductionRepository;
  }

  public MachineDTO addMachine(final MachineDTO machineDTO) throws IOException {
    final Machine machine = MachineMapper.MAPPER.toMachine(machineDTO);
    final EtapeProduction etapeProduction =
        etapeProductionRepository.findEtapeProductionByNomEtape(machineDTO.getNomEtapeProduction());
    machine.setEtapeProduction(etapeProduction);
    return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
  }

  public MachineDTO updateMachine(final MachineDTO machineDTO, final String idMachine)
      throws IOException {
    return machineRepository
        .findById(idMachine)
        .map(
            machine -> {
              machine.setNomMachine(machineDTO.getNomMachine());
              final EtapeProduction etapeProduction =
                  etapeProductionRepository.findEtapeProductionByNomEtape(
                      machineDTO.getNomEtapeProduction());
              machine.setEtapeProduction(etapeProduction);
              machine.setDateMaintenance(machineDTO.getDateMaintenance());
              machine.setLibelle(machineDTO.getLibelle());
              machine.setReference(machineDTO.getReference());
              machine.setNombreConducteur(machineDTO.getNombreConducteur());
              return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
            })
        .orElseThrow(() -> new NotFoundException(machineDTO.getId() + " not found"));
  }

  public void deleteMachine(final String id) throws IOException {
    machineRepository.deleteById(id);
  }
}
