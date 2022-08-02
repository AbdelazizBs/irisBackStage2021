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
final ClientRepository clientRepository;
  final EtapeProductionRepository etapeProductionRepository;

  public ArticleService(
          final ArticleRepository articleRepository,
          final EtapeProductionRepository etapeProductionRepository,final ClientRepository clientRepository) {
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
  final String refArticle =  clientRepository.findClientById(idClient).getRefArticle();
    final List<Article> articles = articleRepository.findArticleByRefArticle(refArticle);
    return articles.stream()
            .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
            .collect(Collectors.toList());
  }

  public ArticleDTO getArticleByCodeArticle(final String codeArticle) {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.findArticleByRefIris(codeArticle)
                    .orElseThrow(() -> new NotFoundException(codeArticle + " not found")));
  }

  public ArticleDTO addArticle(
      final String refIris, final String refClient,final String refArticle, final List<String> nomEtapeProductions) {
    final ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setRefIris(refIris);
    articleDTO.setRefClient(refClient);
    articleDTO.setRefArticle(refArticle);
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
  public ArticleDTO addToClient(
    final String refIris,
    final String refClient,
    final String nomClient,
    final List<String> nomEtapeProductions) {
    final String refA = clientRepository.findClientByNom(nomClient).getRefArticle();
      return articleRepository
              .findArticleByRefIris(refIris)
              .map(
                      article -> {
                        article.setRefIris(refIris);
                        article.setRefClient(refClient);
                        article.setRefArticle(refA);
                        final List<EtapeProduction> etapeProductions = new ArrayList<>();
                        nomEtapeProductions.forEach(
                                nomEtape ->
                                        etapeProductions.add(
                                                etapeProductionRepository.findEtapeProductionByNomEtape(nomEtape)));
                        article.setEtapeProductions(etapeProductions);
                        return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
                      })
              .orElseThrow(() -> new NotFoundException(refIris + " not found"));
    }
  public ArticleDTO updateArticle(
      final String refIris,
      final String refClient,
      final String refArticle,
      final List<String> nomEtapeProductions,
      final String idArticle) {
    return articleRepository
        .findById(idArticle)
        .map(
            article -> {
              article.setRefIris(refIris);
              article.setRefClient(refClient);
              article.setRefArticle(refArticle);
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
