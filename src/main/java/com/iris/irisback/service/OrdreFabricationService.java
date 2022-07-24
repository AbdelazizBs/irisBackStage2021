package com.iris.irisback.service;

import com.iris.irisback.dto.OrdreFabricationDTO;
import com.iris.irisback.mapper.OrdreFabricationMapper;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.OrdreFabrication;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.OrdreFabricationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrdreFabricationService {

  final ArticleRepository articleRepository;
  final OrdreFabricationRepository ordreFabricationRepository;

  public OrdreFabricationService(
      final OrdreFabricationRepository ordreFabricationRepository,
      final ArticleRepository articleRepository) {
    this.ordreFabricationRepository = ordreFabricationRepository;
    this.articleRepository = articleRepository;
  }

  public OrdreFabricationDTO addOf(
      final Date dateLancement,
      final String debutHeure,
      final String finHeure,
      final String commentaire,
      final String qtePremierChoix,
      final String qteNonConforme,
      final String codeArticles) {
    final OrdreFabricationDTO ordreFabricationDTO = new OrdreFabricationDTO();
    ordreFabricationDTO.setCommentaire(commentaire);
    ordreFabricationDTO.setDateLancement(dateLancement);
    ordreFabricationDTO.setDebutHeure(debutHeure);
    ordreFabricationDTO.setFinHeure(finHeure);
    ordreFabricationDTO.setQteNonConforme(qteNonConforme);
    ordreFabricationDTO.setQtePremierChoix(qtePremierChoix);
    final OrdreFabrication ordreFabrication =
        OrdreFabricationMapper.MAPPER.toOrdreFabrication(ordreFabricationDTO);
    final Article article = articleRepository.findArticleByRefIris(codeArticles);
    ordreFabrication.setArticle(article);
    return OrdreFabricationMapper.MAPPER.toOrdreFabricationDTO(
        ordreFabricationRepository.save(ordreFabrication));
  }
}
