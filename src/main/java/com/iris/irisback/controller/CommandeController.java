package com.iris.irisback.controller;


import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import com.iris.irisback.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*")
public class CommandeController {

    @Autowired
    CommandeService commandeService ;

    @PostMapping("/addCommande")
    public CommandeDTO addCommande(@RequestBody CommandeDTO commandeDTO ) throws IOException {
      return   commandeService.addCommande(commandeDTO);


    }

    @GetMapping("/{clientId}/myCommandes")
    List<CommandeDTO> myCommandes(@PathVariable(value = "clientId") final String clientId) throws IOException{
            return commandeService.myCommandes(clientId);
    }


    @DeleteMapping("/deleteCommande/{idCommande}")
    public  void deleteCommande(@PathVariable(value = "idCommande") String  idCommande ) throws IOException {
        commandeService.deleteCommande(idCommande);
    }





    @PutMapping("/updateCommande/{commandeId}")
    public CommandeDTO updateCommande(@RequestBody CommandeDTO commandeDTO ,@PathVariable("commandeId") String commandeId ){
        return commandeService.updateCommande(commandeDTO,commandeId);
    }





}
