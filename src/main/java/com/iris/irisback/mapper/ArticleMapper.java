package com.iris.irisback.mapper;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.EtapeProduction;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Mapper
public abstract class ArticleMapper {

  public static ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

  @Mapping(target = "nomEtapeProductions", ignore = true)
  @Mapping(target = "clientName", ignore = true)
  public abstract ArticleDTO toArticleDTO(Article article);

  @Mapping(target = "etapeProductions", ignore = true)
  @Mapping(target = "client", ignore = true)
  public abstract Article toArticle(ArticleDTO articleDTO);

  @AfterMapping
  void updateArticleDTO(final Article article, @MappingTarget final ArticleDTO articleDTO) {
    final List<String> list =
        article.getEtapeProductions().stream().map(EtapeProduction::getNomEtape).collect(toList());
    articleDTO.setNomEtapeProductions(list);
    articleDTO.setClientName(article.getClient().getNom());

  }

  @AfterMapping
  void updateArticle(final ArticleDTO articleDTO, @MappingTarget final Article article) {}
}
