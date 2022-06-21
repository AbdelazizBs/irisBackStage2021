package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {
    @Autowired   CommandeRepository commandeRepository;
    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/addCommande/{clientId}")
    public CommandeDTO addCommande(@RequestBody Commande commande,@PathVariable("clientId") String clientId){
        commande.setClient(clientRepository.findClientById(clientId));
        return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
    }

}
