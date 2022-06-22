package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.ClientDTO;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.mapper.ClientMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository ;
    public ClientDTO  addClient(Client client)  throws IOException {
        return ClientMapper.MAPPER.toClientDTO(clientRepository.save(client));
    }
}
