package com.iris.irisback.service;

import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.mapper.EtapeProductionMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EtapeProductionService {
  final EtapeProductionRepository etapeProductionRepository;
  final ArticleRepository articleRepository;

  public EtapeProductionService(
      final EtapeProductionRepository etapeProductionRepository,
      final ArticleRepository articleRepository) {
    this.etapeProductionRepository = etapeProductionRepository;
    this.articleRepository = articleRepository;
  }

  public EtapeProductionDTO processEtapeProduction(final EtapeProductionDTO etapeProductionDTO)
      throws IOException {
    final EtapeProduction etapeProduction =
        EtapeProductionMapper.MAPPER.toEtapeProduction(etapeProductionDTO);
    return EtapeProductionMapper.MAPPER.toEtapeProductionDTO(
        etapeProductionRepository.save(etapeProduction));
  }
}
