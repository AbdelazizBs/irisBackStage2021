package com.iris.irisback.controller;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientController {
  @Autowired ClientService clientService;

  @PostMapping("/addClient")
  public ClientDTO addClient(
      @RequestBody final ClientDTO clientDTO, final BindingResult bindingResult)
      throws IOException {
    return clientService.addClient(clientDTO, bindingResult);
    //     return  clientRepository.save(client);
  }

  @PutMapping("/updateClient/{idClient}")
  public ClientDTO updateClient(
      @RequestBody final ClientDTO clientDTO,
      @PathVariable(value = "idClient") final String idClient)
      throws IOException {
    return clientService.updateClient(clientDTO, idClient);
  }

  @PostMapping("/login")
  public ClientDTO login(
      @Valid @RequestParam(value = "email") final String email,
      @RequestParam(value = "password") final String password) {
    return clientService.login(email, password);
  }

  @PutMapping("/desactivateClient/{idClient}")
  public ClientDTO desactivateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.desactivateClient(idClient);
  }

  @PutMapping("/activateClient/{idClient}")
  public ClientDTO activateClient(@PathVariable(value = "idClient") final String idClient) {
    return clientService.activateClient(idClient);
  }
}
