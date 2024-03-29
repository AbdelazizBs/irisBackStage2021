package com.iris.irisback.service;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.model.Machine;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import com.iris.irisback.repository.MachineRepository;
import com.iris.irisback.repository.PersonnelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MachineService {

  final MachineRepository machineRepository;
  final ClientRepository clientRepository;
  final EtapeProductionRepository etapeProductionRepository;
  final PersonnelRepository personnelRepository;

  public MachineService(
      final MachineRepository machineRepository,
      final EtapeProductionRepository etapeProductionRepository,
      final ClientRepository clientRepository,
      final PersonnelRepository personnelRepository) {
    this.machineRepository = machineRepository;
    this.etapeProductionRepository = etapeProductionRepository;
    this.clientRepository = clientRepository;
    this.personnelRepository = personnelRepository;
  }

  public MachineDTO addMachine(
      final String designation,
      final String reference,
      final String nomEtapeProduction,
      final String nombreConducteur,
      final Date dateCreation,
      final Date dateMaintenance,
      final List<String> nomPersonnel,
      final String etat)
        {
    final MachineDTO machineDTO = new MachineDTO();
    machineDTO.setDesignation(designation);
    machineDTO.setReference(reference);
    machineDTO.setEtat(etat);
    machineDTO.setDateCreation(dateCreation);
    machineDTO.setDateMaintenance(dateMaintenance);
    machineDTO.setNombreConducteur(nombreConducteur);
            final EtapeProduction nomEtapeExiste = etapeProductionRepository.findEtapeProductionByNomEtape("NoEtape");
            if (nomEtapeExiste==null){
                final EtapeProduction fakeEtape = new EtapeProduction();
                fakeEtape.setNomEtape("NoEtape");
                etapeProductionRepository.save(fakeEtape);
            }
            if (nomEtapeProduction.equals("")) {
                machineDTO.setNomEtapeProduction("NoEtape");
            }else {
                machineDTO.setNomEtapeProduction(nomEtapeProduction);
            }

            final Machine machine = MachineMapper.MAPPER.toMachine(machineDTO);
    final EtapeProduction etapeProduction =
        etapeProductionRepository.findEtapeProductionByNomEtape(machineDTO.getNomEtapeProduction());
    final List<Personnel> personnelList = new ArrayList<>();
    nomPersonnel.forEach(
        pesonnel -> personnelList.add(personnelRepository.findPersonnelByName(pesonnel)));
    machine.setPersonnel(personnelList);
    machine.setEtapeProduction(etapeProduction);
    return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
  }

  public MachineDTO getMachineById(final String idMachine)   {
    return MachineMapper.MAPPER.toMachineDTO(machineRepository.findMachineById(idMachine));
  }

  public List<String> getNomMachine()   {
    return machineRepository.findAll().stream()
        .map(Machine::getDesignation)
        .collect(Collectors.toList());
  }

  public List<MachineDTO> getLisMachine()   {
    return machineRepository.findAll().stream()
        .map(machine -> MachineMapper.MAPPER.toMachineDTO(machine))
        .collect(Collectors.toList());
  }

  public MachineDTO updateMachine(
      final String designation,
      final String reference,
      final String nomEtapeProduction,
      final String nombreConducteur,
      final Date dateCreation,
      final Date dateMaintenance,
      final List<String> nomPersonnel,
      final String etat,
      final String idMachine)
        {
    return machineRepository
        .findById(idMachine)
        .map(
            machine -> {
              machine.setDesignation(designation);
              final EtapeProduction etapeProduction =
                  etapeProductionRepository.findEtapeProductionByNomEtape(nomEtapeProduction);
              machine.setEtapeProduction(etapeProduction);
              machine.setDateMaintenance(dateMaintenance);
              machine.setReference(reference);
              machine.setDateCreation(dateCreation);
              machine.setEtat(etat);
              machine.setNombreConducteur(nombreConducteur);
              final List<Personnel> personnelList = new ArrayList<>();
              nomPersonnel.forEach(
                  pesonnel -> personnelList.add(personnelRepository.findPersonnelByName(pesonnel)));
              machine.setPersonnel(personnelList);
              return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
            })
        .orElseThrow(() -> new NotFoundException(idMachine + " not found"));
  }

  public void deleteMachine(final String id)   {
    machineRepository.deleteById(id);
  }


    public MachineDTO setEtatEnRepos(final String idMachine) {
        final Machine machine = machineRepository.findMachineById(idMachine);
machine.setEtat("En repos");
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
    }
    public MachineDTO setEtatEnMaintenance(final String idMachine) {
        final Machine machine = machineRepository.findMachineById(idMachine);
        machine.setEtat("En Maintenance");
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
    }
    public MachineDTO setEtatEnPanne(final String idMachine) {
        final Machine machine = machineRepository.findMachineById(idMachine);
        machine.setEtat("En panne");
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
    }
    public MachineDTO setEtatEnmarche(final String idMachine) {
        final Machine machine = machineRepository.findMachineById(idMachine);
machine.setEtat("En marche");
        return MachineMapper.MAPPER.toMachineDTO(machineRepository.save(machine));
}


}
