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

  public ArticleDTO addArticle(final ArticleDTO articleDTO) throws IOException {
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

  public ArticleDTO updateArticle(final ArticleDTO articleDTO, final String idArticle)
      throws IOException {
    return articleRepository
        .findById(idArticle)
        .map(
            article -> {
              article.setCodeArticle(articleDTO.getCodeArticle());
              article.setDesignation(articleDTO.getDesignation());
              final List<EtapeProduction> etapeProductions = new ArrayList<>();
              articleDTO
                  .getNomEtapeProductions()
                  .forEach(
                      nomEtape ->
                          etapeProductions.add(
                              etapeProductionRepository.findEtapeProductionByNomEtape(nomEtape)));
              article.setEtapeProductions(etapeProductions);
              return ArticleMapper.MAPPER.toArticleDTO(articleRepository.save(article));
            })
        .orElseThrow(() -> new NotFoundException(articleDTO.getId() + " not found"));
  }

  public void deleteArticle(final String idArticle) throws IOException {
    articleRepository.deleteById(idArticle);
  }
}
