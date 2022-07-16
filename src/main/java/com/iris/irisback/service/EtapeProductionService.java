package com.iris.irisback.service;

import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.exception.NotFoundException;
import com.iris.irisback.mapper.EtapeProductionMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.repository.ArticleRepository;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

  public List<String> getNomEtapes() throws IOException {
    return etapeProductionRepository.findAll().stream()
        .map(EtapeProduction::getNomEtape)
        .collect(Collectors.toList());
  }

  public List<EtapeProductionDTO> etapes() throws IOException {
    final List<EtapeProduction> etapeProductions = etapeProductionRepository.findAll();
    return etapeProductions.stream()
        .map(etapeProduction -> EtapeProductionMapper.MAPPER.toEtapeProductionDTO(etapeProduction))
        .collect(Collectors.toList());
  }

  public EtapeProductionDTO getEtapeById(final String idEtape) throws IOException {
    return EtapeProductionMapper.MAPPER.toEtapeProductionDTO(
        etapeProductionRepository.findEtapeProductionById(idEtape));
  }

  public EtapeProductionDTO processEtapeProduction(final String nomEtape, final String typeEtape)
      throws IOException {
    final EtapeProductionDTO etapeProductionDTO = new EtapeProductionDTO();
    etapeProductionDTO.setNomEtape(nomEtape);
    etapeProductionDTO.setTypeEtape(typeEtape);
    final EtapeProduction etapeProduction =
        EtapeProductionMapper.MAPPER.toEtapeProduction(etapeProductionDTO);
    return EtapeProductionMapper.MAPPER.toEtapeProductionDTO(
        etapeProductionRepository.save(etapeProduction));
  }

  public EtapeProductionDTO updateEtape(
      final String nomEtape, final String typeEtape, final String idEtape) throws IOException {
    return etapeProductionRepository
        .findById(idEtape)
        .map(
            etapeProduction -> {
              etapeProduction.setNomEtape(nomEtape);
              etapeProduction.setTypeEtape(typeEtape);
              return EtapeProductionMapper.MAPPER.toEtapeProductionDTO(
                  etapeProductionRepository.save(etapeProduction));
            })
        .orElseThrow(() -> new NotFoundException(idEtape + " not found"));
  }

  public void deleteEtape(final String id) throws IOException {
    etapeProductionRepository.deleteById(id);
  }
}
