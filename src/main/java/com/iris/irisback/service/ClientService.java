package com.iris.irisback.service;

import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientService {
  final ClientRepository clientRepository;

  public ClientService(final ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public ClientDTO addClient(final ClientDTO clientDTO) throws IOException {
    final Client client = ClientMapper.MAPPER.toClient(clientDTO);
    client.setActive(true);
    return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
  }

  public ClientDTO updateClient(final ClientDTO clientDTO, final String idClient)
      throws IOException {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setAddress(clientDTO.getAddress());
              client.setCompany(clientDTO.getCompany());
              client.setCountry(clientDTO.getCountry());
              client.setEmail(clientDTO.getEmail());
              client.setFirstName(clientDTO.getFirstName());
              client.setLastName(clientDTO.getLastName());
              client.setLogin(clientDTO.getLogin());
              client.setPassword(clientDTO.getPassword());
              client.setPhone(clientDTO.getPhone());
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(clientDTO.getId() + " not found"));
  }

  public ClientDTO desactivateClient(final String idClient) {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setActive(false);
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(idClient + " not found"));
  }

  public ClientDTO activateClient(final String idClient) {
    return clientRepository
        .findById(idClient)
        .map(
            client -> {
              client.setActive(true);
              return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
            })
        .orElseThrow(() -> new NotFoundException(idClient + " not found"));
  }
}
