package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    ClientRepository clientRepository ;

@PostMapping("/addClient")
    public ClientDTO addClient(@RequestBody  Client client){
  /* ClientDTO clientDTO = new ClientDTO();
    clientDTO.setAddress(client.getAddress());
    clientDTO.setCompany(client.getCompany());
    clientDTO.setCountry(client.getCountry());
    clientDTO.setEmail(client.getEmail());
    clientDTO.setFirstName(client.getFirstName());
    clientDTO.setId(client.getId());
    clientDTO.setLastName(client.getLastName());
    clientDTO.setLogin(client.getLogin());
    clientDTO.setPassword(client.getPassword());
    clientDTO.setPhone(client.getPhone());
    Client cl = ClientMapper.MAPPER.toClient(clientDTO);*/
    return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
   //     return  clientRepository.save(client);
    }
}
