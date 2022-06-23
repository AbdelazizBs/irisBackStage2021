package com.iris.irisback.service;

import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.mapper.PersonnelMapper;
import com.iris.irisback.model.Machine;
import com.iris.irisback.model.Personnel;
import com.iris.irisback.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PersonnelService {
    @Autowired
    PersonnelRepository personnelRepository ;

    public PersonnelDTO addPersonnel(PersonnelDTO personnelDTO)  throws IOException {
        final Personnel personnel = PersonnelMapper.MAPPER.toPersonnel(personnelDTO);
        return PersonnelMapper.MAPPER.toPersonnelDTO(personnelRepository.save(personnel));
    }

}
