package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.Commande;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {
  private final CommandeRepository  commandeRepository;
  private final ClientRepository clientRepository;
  private final ArticleRepository articleRepository;

  public CommandeService(
      final CommandeRepository commandeRepository,
      final ClientRepository clientRepository,
      final ArticleRepository articleRepository) {
    this.commandeRepository = commandeRepository;
    this.clientRepository = clientRepository;
    this.articleRepository = articleRepository;
  }

  public CommandeDTO addCommande(
      final Date dateCmd,
      final String numCmd,
      final String typeCmd,
      final String nomClient,
      final List<String> articles)
        {
    final CommandeDTO commandeDTO = new CommandeDTO();
    commandeDTO.setDateCmd(dateCmd);
    commandeDTO.setArticles(articles);
    commandeDTO.setNomClient(nomClient);
    commandeDTO.setTypeCmd(typeCmd);
    commandeDTO.setNumCmd(numCmd);
    final Commande commande1 = CommandeMapper.MAPPER.toCommande(commandeDTO);
    final List<Article> articles1 = new ArrayList<>();
    commandeDTO
        .getArticles()
        .forEach(codeArticle -> articles1.add(articleRepository.findArticleByRefIris(codeArticle)
                .orElseThrow(() -> new NotFoundException(codeArticle + " not found"))));
    commande1.setArticles(articles1);
    final Client client = clientRepository.findClientByNom(commandeDTO.getNomClient());
    commande1.setClient(client);
    return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande1));
  }

  public List<CommandeDTO> myCommandes(final String clientId) {
    final List<Commande> commandeByClientId = commandeRepository.findCommandeByClientId(clientId);
    return commandeByClientId.stream()
        .map(commande -> CommandeMapper.MAPPER.toCommandeDTO(commande))
        .collect(Collectors.toList());
  }

  public CommandeDTO getCmdById(final String idCmd)   {
    final Commande commande = commandeRepository.findCommandeById(idCmd)
            .orElseThrow(() -> new NotFoundException("Commande Id  " + idCmd + " not found"));
    ;
    return CommandeMapper.MAPPER.toCommandeDTO(commande);
  }

  public List<Commande> Commandes()   {
    final List<Commande> commandes = commandeRepository.findAll();
    return  commandes ;
//    return commandes.stream()
//        .map(commande -> CommandeMapper.MAPPER.toCommandeDTO(commande))
//        .collect(Collectors.toList());
  }
    public CommandeDTO  addToCommand(final String idArticle, final String idCmd) {
        final Article article = articleRepository.findArticleById(idArticle).orElseThrow(() -> new NotFoundException(idArticle + " not found"));
        return commandeRepository
                .findCommandeById(idCmd)
                .map(
                        commande -> {
                            commande.setArticles(Collections.singletonList(article));
                            return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
                        })
                .orElseThrow(() -> new NotFoundException(idCmd + " not found"));
    }

  public void deleteCommande(final String id)   {
    commandeRepository.deleteById(id);
  }

  public CommandeDTO updateCommande(  final Date dateCmd,
                                      final String numCmd,
                                      final String typeCmd,
                                      final String nomClient,
                                      final List<String> articles,
                                      final String commandeId) {
    return commandeRepository
        .findById(commandeId)
        .map(
            commande -> {
              commande.setTypeCmd(typeCmd);
              commande.setNumCmd(numCmd);
              commande.setDateCmd(dateCmd);
              final Client client = clientRepository.findClientByNom(nomClient);
              commande.setClient(client);
              final List<Article> articles1 = new ArrayList<>();
              articles
                      .forEach(article -> articles1.add(articleRepository.findArticleByRefIris(article)
                              .orElseThrow(() -> new NotFoundException(article + " not found"))));
              commande.setArticles(articles1);
              return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
            })
        .orElseThrow(() -> new NotFoundException("Commande Id  " + commandeId + " not found"));
  }

    public CommandeDTO ajouterAcmd(  final String idArticle,
                                        final String idCommande) {
        return commandeRepository
                .findById(idCommande)
                .map(
                        commande -> {
                            final Article article = articleRepository.findArticleById(idArticle)
                                    .orElseThrow(() -> new NotFoundException(idArticle + " not found"));
                            final List<Article> articles1 = new ArrayList<>();
                            articles1.add(article);
                            commande.getArticles()
                                    .forEach(a -> articles1.add(articleRepository.findArticleByRefIris(a.getRefIris())
                                            .orElseThrow(() -> new NotFoundException(a + " not found"))));
                            commande.setArticles(articles1);
                            return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
                        })
                .orElseThrow(() -> new NotFoundException("Commande Id  " + idCommande + " not found"));
    }
}
