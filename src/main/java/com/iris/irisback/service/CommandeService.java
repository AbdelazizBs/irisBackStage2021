package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.mapper.MachineMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Commande;
import com.iris.irisback.model.Machine;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ArticleRepository articleRepository;

    public CommandeDTO addCommande(CommandeDTO commandeDTO) throws IOException {
        final Commande commande1 = CommandeMapper.MAPPER.toCommande(commandeDTO);
        return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande1));

    }



    public List<CommandeDTO> myCommandes(final String  clientId) throws IOException {
        return commandeRepository.findCommandeByClientId(clientId).stream().map(commande -> CommandeMapper.MAPPER.toCommandeDTO(commande)).collect(Collectors.toList());
    }

    public void deleteCommande(String  id) throws IOException{
        commandeRepository.deleteById(id);
    }



    public CommandeDTO updateCommande(CommandeDTO commandeDTO, String commandeId){
    return commandeRepository
        .findById(commandeId)
        .map(
            commande -> {
              commande.setTypeCmd(commandeDTO.getTypeCmd());
              commande.setNumCmd(commandeDTO.getNumCmd());
              commande.setDateCmd(commandeDTO.getDateCmd());
              commande.setArticles(commandeDTO.getArticles());
                commande.setClient(clientRepository.findClientById(commandeDTO.getClientId()));
             /* commande.setArticle(
                  new ArrayList<Article>(
                      Collections.singleton(
                          articleRepository.findArticleById(
                              String.valueOf(commandeDTO.getArticlesId().stream().toList())))));*/



              //
              // commande.setArticle(Collections.singletonList(articleRepository.findArticleById(String.valueOf(commandeDTO.getArticlesId()))));
              //
              // commande.setArticle(Collections.singletonList(articleRepository.findArticleById(String.valueOf(commandeDTO.getArticlesId()))));
            return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
           })
        .orElseThrow(() -> new NotFoundException("Commande Id  " + commandeId + " not found"));
    }






}
