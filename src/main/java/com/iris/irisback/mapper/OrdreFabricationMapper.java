package com.iris.irisback.mapper;

import com.iris.irisback.dto.OrdreFabricationDTO;
import com.iris.irisback.model.OrdreFabrication;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class OrdreFabricationMapper {

  public static OrdreFabricationMapper MAPPER = Mappers.getMapper(OrdreFabricationMapper.class);

  @Mapping(target = "codeArticles", ignore = true)
  public abstract OrdreFabricationDTO toOrdreFabricationDTO(OrdreFabrication ordreFabrication);

  @Mapping(target = "article", ignore = true)
  public abstract OrdreFabrication toOrdreFabrication(OrdreFabricationDTO ordreFabricationDTO);

  @AfterMapping
  void updateOrdreFabricationDTO(
      final OrdreFabrication ordreFabrication,
      @MappingTarget final OrdreFabricationDTO ordreFabricationDTO) {
    ordreFabricationDTO.setCodeArticles(ordreFabrication.getArticle().getRefIris());
  }

  @AfterMapping
  void updateOrdreFabrication(
      final OrdreFabricationDTO ordreFabricationDTO,
      @MappingTarget final OrdreFabrication ordreFabrication) {}
}
