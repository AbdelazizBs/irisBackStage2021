package com.iris.irisback.controller;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
  final ClientService clientService;

  public ClientController(final ClientService clientService) {
    this.clientService = clientService;
  }



  @PostMapping("/addClient")
  public ClientDTO addClient(
          @RequestParam final String nom,
          @RequestParam final String company,
          @RequestParam final String address,
          @RequestParam final String phone,
          @RequestParam final String country,
          @RequestParam final String reference,
          @RequestParam final String email
          )
        {
    return clientService.addClient(nom,company,address,phone,country,reference,email);
    //     return  clientRepository.save(client);
  }

  @PutMapping("/updateClient/{idClient}")
  public ClientDTO updateClient(
      @RequestParam final String nom,
      @RequestParam final String company,
      @RequestParam final String address,
      @RequestParam final String phone,
      @RequestParam final String country,
      @RequestParam final String reference,
      @RequestParam final String email,
      @PathVariable(value = "idClient") final String idClient)
        {
    return clientService.updateClient(nom,company,address,phone,country,email,reference, idClient);
  }

//  @PostMapping("/login")
//  public ClientDTO login(
//      @Valid @RequestParam(value = "email") final String email,
//      @RequestParam(value = "password") final String password)
//      throws IOException {
//    return clientService.login(email, password);
//  }

  @GetMapping("/getClientById/{idClient}")
  public ClientDTO getClientbyid(@PathVariable(value = "idClient") final String idClient)
        {
    return clientService.getClientById(idClient);
  }
  @GetMapping("/getListClient")
  public List<ClientDTO> getListClient()   {
    return clientService.getListClient();
  }
  @GetMapping("/getClientByEmail")
  public ClientDTO getClientByEmail(@Valid @RequestParam(value = "email") final String email)
        {
    return clientService.getClientByEmail(email);
  }

  @PutMapping("/desactivateClient/{idClient}")
  public ClientDTO desactivateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.desactivateClient(idClient);
  }


  @DeleteMapping("/deleteClient/{idClient}")
  public ResponseEntity<Void> deleteClient(
          @PathVariable(value = "idClient") final String idClient) {
    clientService.deleteClient(idClient);
    return ResponseEntity.noContent().build();
  }
  @PutMapping("/activateClient/{idClient}")
  public ClientDTO activateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.activateClient(idClient);
  }

  @GetMapping("/getNomClients")
  public List<String> getNomClients() throws IOException {
    return clientService.getNomClients();
  }
}
