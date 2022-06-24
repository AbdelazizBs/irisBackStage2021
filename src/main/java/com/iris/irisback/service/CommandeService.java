package com.iris.irisback.service;

import com.iris.irisback.dto.CommandeDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.CommandeMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Commande;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CommandeService {
  private final CommandeRepository commandeRepository;
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

  public CommandeDTO addCommande(final CommandeDTO commandeDTO) throws IOException {
    final Commande commande1 = CommandeMapper.MAPPER.toCommande(commandeDTO);
    final List<Article> articles = new ArrayList<>();
    commandeDTO.getArticlesId().forEach(id -> articles.add(articleRepository.findArticleById(id)));
    commande1.setArticles(articles);
    return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande1));
  }

  public List<CommandeDTO> myCommandes(final String clientId) throws IOException {
    final List<Commande> commandeByClientId = commandeRepository.findCommandeByClientId(clientId);
    return commandeByClientId.stream()
        .map(commande -> CommandeMapper.MAPPER.toCommandeDTO(commande))
        .collect(Collectors.toList());
  }

  public void deleteCommande(final String id) throws IOException {
    commandeRepository.deleteById(id);
  }

  public CommandeDTO updateCommande(final CommandeDTO commandeDTO, final String commandeId) {
    return commandeRepository
        .findById(commandeId)
        .map(
            commande -> {
              commande.setTypeCmd(commandeDTO.getTypeCmd());
              commande.setNumCmd(commandeDTO.getNumCmd());
              commande.setDateCmd(commandeDTO.getDateCmd());
              final List<Article> list =
                  commandeDTO.getArticlesId().stream()
                      .map((articlesId) -> articleRepository.findArticleById(articlesId))
                      .collect(toList());
              commande.setArticles(list);
              return CommandeMapper.MAPPER.toCommandeDTO(commandeRepository.save(commande));
            })
        .orElseThrow(() -> new NotFoundException("Commande Id  " + commandeId + " not found"));
  }
}
