package com.iris.irisback.service;

import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.PersonnelMapper;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PersonnelService {
  @Autowired PersonnelRepository personnelRepository;

  public PersonnelDTO addPersonnel(final PersonnelDTO personnelDTO) throws IOException {
    final Personnel personnel = PersonnelMapper.MAPPER.toPersonnel(personnelDTO);
    return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
  }

  public void deletePersonnel(final String idPersonnel) throws IOException {
    personnelRepository.deleteById(idPersonnel);
  }

  public PersonnelDTO updatePersonnel(final PersonnelDTO personnelDTO, final String idPersonnel)
      throws IOException {
    return personnelRepository
        .findById(idPersonnel)
        .map(
            personnel -> {
              personnel.setAddress(personnelDTO.getAddress());
              personnel.setCompany(personnelDTO.getCompany());
              personnel.setCountry(personnelDTO.getCountry());
              personnel.setFirstName(personnelDTO.getFirstName());
              personnel.setLastName(personnelDTO.getLastName());
              personnel.setDateNaissance(personnelDTO.getDateNaissance());
              personnel.setGenre(personnelDTO.getGenre());
              personnel.setCin(personnelDTO.getCin());
              personnel.setPhone(personnelDTO.getPhone());
              personnel.setIdMach(personnelDTO.getIdMach());
              personnel.setMachine(personnelDTO.getMachine());
              return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
            })
        .orElseThrow(() -> new NotFoundException(personnelDTO.getId() + " not found"));
  }
}
