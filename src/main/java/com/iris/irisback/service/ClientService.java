package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository ;
    public ClientDTO  addClient(ClientDTO clientDTO)  throws IOException {
        final Client client = ClientMapper.MAPPER.toClient(clientDTO);
        client.setActive(true);
        return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
    }

    public ClientDTO updateClient(ClientDTO clientDTO, String idClient)throws IOException{
        return  clientRepository
                .findById(idClient)
                .map(

                        client -> {
                            client.setAddress(clientDTO.getAddress());
                            client.setCommandes(clientDTO.getCommandes());
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


    public ClientDTO desactivateClient(String idClient){
        return  clientRepository
                .findById(idClient)
                .map(
                        client -> {
                            client.setActive(false);
                            return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
                        })
                .orElseThrow(() -> new NotFoundException(idClient + " not found"));
    }


    public ClientDTO activateClient(String idClient){
        return  clientRepository
                .findById(idClient)
                .map(
                        client -> {
                            client.setActive(true);
                            return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
                        })
                .orElseThrow(() -> new NotFoundException(idClient + " not found"));
    }

}
