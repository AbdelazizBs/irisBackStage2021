package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    ClientService clientService ;

    @PostMapping("/addClient")
        public ClientDTO addClient(@RequestBody  ClientDTO clientDTO) throws IOException {
            return clientService.addClient(clientDTO);
        //     return  clientRepository.save(client);
        }

    @PutMapping("/updateClient/{idClient}")
    public ClientDTO updateClient(@RequestBody ClientDTO clientDTO , @PathVariable(value = "idClient") String  idClient ) throws IOException {
        return clientService.updateClient(clientDTO,idClient);
    }


    @PutMapping("/desactivateClient/{idClient}")
public  ClientDTO desactivateClient(@PathVariable(value = "idClient") String idClient){
    return     clientService.desactivateClient(idClient);
    }

        @PutMapping("/activateClient/{idClient}")
    public  ClientDTO activateClient(@PathVariable(value = "idClient") String idClient){
        return     clientService.activateClient(idClient);
    }

}
