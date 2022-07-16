package com.iris.irisback.service;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.ArticleMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

  final ArticleRepository articleRepository;

  final EtapeProductionRepository etapeProductionRepository;

  public ArticleService(
      final ArticleRepository articleRepository,
      final EtapeProductionRepository etapeProductionRepository) {
    this.articleRepository = articleRepository;
    this.etapeProductionRepository = etapeProductionRepository;
  }

  public List<ArticleDTO> articles() throws IOException {
    final List<Article> articles = articleRepository.findAll();
    return articles.stream()
        .map(article -> ArticleMapper.MAPPER.toArticleDTO(article))
        .collect(Collectors.toList());
  }

  public ArticleDTO getArticleById(final String idArticle) throws IOException {
    return ArticleMapper.MAPPER.toArticleDTO(articleRepository.findArticleById(idArticle));
  }

  public ArticleDTO getArticleByCodeArticle(final String codeArticle) throws IOException {
    return ArticleMapper.MAPPER.toArticleDTO(
        articleRepository.findArticleByCodeArticle(codeArticle));
  }

  public ArticleDTO addArticle(
      final String codeArticle, final String designation, final List<String> nomEtapeProductions)
      throws IOException {
    final ArticleDTO articleDTO = new ArticleDTO();
    articleDTO.setCodeArticle(codeArticle);
    articleDTO.setDesignation(designation);
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
      final String codeArticle,
      final String designation,
      final List<String> nomEtapeProductions,
      final String idArticle)
      throws IOException {
    return articleRepository
        .findById(idArticle)
        .map(
            article -> {
              article.setCodeArticle(codeArticle);
              article.setDesignation(designation);
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

  public void deleteArticle(final String idArticle) throws IOException {
    articleRepository.deleteById(idArticle);
  }
}
