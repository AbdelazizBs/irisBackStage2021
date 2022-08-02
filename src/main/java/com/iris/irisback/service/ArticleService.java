package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.model.Article;
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

  final EtapeProductionRepository etapeProductionRepository;
  final
  ClientRepository clientRepository ;

  public ArticleService(
          final ArticleRepository articleRepository,
          final EtapeProductionRepository etapeProductionRepository, final ClientRepository clientRepository) {
    this.articleRepository = articleRepository;
    this.etapeProductionRepository = etapeProductionRepository;
    this.clientRepository = clientRepository;
  }

  public List<ArticleDTO> articles() {
    final List<Article> articles = articleRepository.findAll();
    return articles.stream()
        .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
        .collect(Collectors.toList());
  }

  public ArticleDTO getArticleById(final String idArticle) {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.findArticleById(idArticle));
  }
  public List <ArticleDTO> getArticle(final String idClient) {
  final String refArticle =  clientRepository.findClientById(idClient).getReference();
    final List<Article> articles = articleRepository.findArticleByRefClient(refArticle);
    return articles.stream()
            .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
            .collect(Collectors.toList());
  }

  public ArticleDTO getArticleByCodeArticle(final String codeArticle) {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.findArticleByRefIris(codeArticle));
  }

  public ArticleDTO addArticle(
      final String refIris, final String refClient, final List<String> nomEtapeProductions) {
    final ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setRefIris(refIris);
    articleDTO.setRefClient(refClient);
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

    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
  }

  public ArticleDTO updateArticle(
      final String refIris,
      final String refClient,
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
}
