package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Commande;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ArticleRepository articleRepository;

    public CommandeDTO addCommande(Commande commande, String clientId, String articleId){
         /*  CommandeDTO commandeDTO = new CommandeDTO();
   commandeDTO.setClient(clientRepository.findClientById(clientId));
        commandeDTO.setDateCmd(commande.getDateCmd());
    commandeDTO.setId(commande.getId());
commandeDTO.setNumCmd(commande.getNumCmd());
commandeDTO.setTypeCmd(commande.getTypeCmd());
final Commande  commande1 = CommandeMapper.MAPPER.toCommande(commandeDTO);*/
        commande.setClient(clientRepository.findClientById(clientId));
        commande.setArticle(articleRepository.findArticleById(articleId));
        return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
    }

}
