package com.iris.irisback.mapper;

import com.iris.irisback.dto.EtapeProductionDTO;
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
public abstract class EtapeProductionMapper {

  public static EtapeProductionMapper MAPPER = Mappers.getMapper(EtapeProductionMapper.class);

  @Mapping(target = "articlesId", ignore = true)
  public abstract EtapeProductionDTO toEtapeProductionDTO(EtapeProduction etapeProduction);

  @Mapping(target = "articles", ignore = true)
  public abstract EtapeProduction toEtapeProduction(EtapeProductionDTO etapeProductionDTO);

  @AfterMapping
  void updateEtapeProductionDTO(
      final EtapeProduction etapeProduction,
      @MappingTarget final EtapeProductionDTO etapeProductionDTO) {
    final List<String> list =
        etapeProduction.getArticles().stream().map(Article::getId).collect(toList());
    etapeProductionDTO.setArticlesId(list);
  }

  @AfterMapping
  void updateEtapeProduction(
      final EtapeProductionDTO etapeProductionDTO,
      @MappingTarget final EtapeProduction etapeProduction) {}
}
