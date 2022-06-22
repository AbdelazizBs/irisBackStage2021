package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import com.iris.irisback.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {

    @Autowired
    CommandeService commandeService ;

    @PostMapping("/addCommande/{clientId}/{articleId}")
    public CommandeDTO addCommande(@RequestBody Commande commande,@PathVariable("clientId") String clientId,@PathVariable("articleId") String articleId){
      return   commandeService.addCommande(commande,clientId,articleId);


    }

}
