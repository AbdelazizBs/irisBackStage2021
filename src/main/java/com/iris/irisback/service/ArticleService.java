package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Client;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.ClientRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

  final ArticleRepository articleRepository;
final ClientRepository clientRepository;
  final EtapeProductionRepository etapeProductionRepository;

  public ArticleService(
          final ArticleRepository articleRepository,
          final EtapeProductionRepository etapeProductionRepository,final ClientRepository clientRepository) {
    this.articleRepository = articleRepository;
    this.etapeProductionRepository = etapeProductionRepository;
    this.clientRepository = clientRepository;
  }


  public List <ArticleDTO> getArticleByIdClient(final String idClient) {
    final Client client = clientRepository.findClientById(idClient);
    return articleRepository.findArticleByClient(client).stream().map(article -> ArticleMapper.MAPPER.toArticleDTO(article)).collect(Collectors.toList());
  }

  public List <ArticleDTO> getArticleByNomClient(final String nomClient) {
    final Client client = clientRepository.findClientByNom(nomClient);
    return articleRepository.findArticleByClient(client).stream().map(article -> ArticleMapper.MAPPER.toArticleDTO(article)).collect(Collectors.toList());
  }
  public List<ArticleDTO> articles() {
    final List<Article> articles = articleRepository.findAll();
    return articles.stream()
        .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
        .collect(Collectors.toList());
  }

  public ArticleDTO getArticleById(final String idArticle) {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository
            .findArticleById(idArticle) .orElseThrow(() -> new NotFoundException(idArticle + " not found")));
  }

  public ArticleDTO getArticleByCodeArticle(final String codeArticle) {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.findArticleByRefIris(codeArticle)
                    .orElseThrow(() -> new NotFoundException(codeArticle + " not found")));
  }

  public ArticleDTO addArticle(
      final String refIris, final String refClient,final String clientName, final List<String> nomEtapeProductions) {
    final ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setRefIris(refIris);
    articleDTO.setRefClient(refClient);
    final Client noClientExist = clientRepository.findClientByNom("NoClient");
    if (noClientExist==null){
      final Client fakeClient = new Client();
     fakeClient.setNom("NoClient");
      clientRepository.save(fakeClient);
    }
    if (clientName.equals("")) {
      articleDTO.setClientName("NoClient");
    }else {
      articleDTO.setClientName(clientName);
    }
    articleDTO.setNomEtapeProductions(nomEtapeProductions);
    final Article article = ArticleMapper.MAPPER.toArticle(articleDTO);
    final List<EtapeProduction> etapeProductions = new ArrayList<>();
    articleDTO
        .getNomEtapeProductions()
        .forEach(
            nomEtape ->
                etapeProductions.add(
                    etapeProductionRepository.findEtapeProductionByNomEtape(nomEtape)));
    article.setEtapeProductions(etapeProductions);
    final Client client = clientRepository.findClientByNom(articleDTO.getClientName());
    article.setClient(client);
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
  }


  public ArticleDTO updateArticle(
      final String refIris,
      final String refClient,
      final String clientName,
      final List<String> nomEtapeProductions,
      final String idArticle) {
    return articleRepository
        .findById(idArticle)
        .map(
            article -> {
              article.setRefIris(refIris);
              article.setRefClient(refClient);
              final List<EtapeProduction> etapeProductions = new ArrayList<>();
              nomEtapeProductions.forEach(
                  nomEtape ->
                      etapeProductions.add(
                          etapeProductionRepository.findEtapeProductionByNomEtape(nomEtape)));
              article.setEtapeProductions(etapeProductions);
              final Client client =
                      clientRepository.findClientByNom(clientName);
              article.setClient(client);
              return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
            })
        .orElseThrow(() -> new NotFoundException(idArticle + " not found"));
  }

  public void deleteArticle(final String idArticle) {
    articleRepository.deleteById(idArticle);
  }

  public List<String> getRefIris() {
    return articleRepository.findAll().stream()
        .map(Article::getRefIris)
        .collect(Collectors.toList());
  }

  public List<ArticleDTO> getListArticlesNonLiée() {
    return articleRepository.findAll().stream()
        .filter(article -> article.getClient().getNom().equals("NoClient"))
            .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
        .collect(Collectors.toList());
  }
}
