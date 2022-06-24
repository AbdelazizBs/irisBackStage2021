package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/personnel")
@CrossOrigin(origins = "*")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;
    @PostMapping("/addPersonnel")
    public PersonnelDTO addPersonnel(@RequestBody PersonnelDTO personnelDTO) throws IOException {
        return personnelService.addPersonnel(personnelDTO);
        //     return  clientRepository.save(client);
    }

    @PutMapping("/updatePersonnel/{idPersonnel}")
    public PersonnelDTO updatePersonnel(@RequestBody PersonnelDTO personnelDTO , @PathVariable(value = "idPersonnel") String  idPersonnel ) throws IOException {
        return personnelService.updatePersonnel(personnelDTO,idPersonnel);
    }


}