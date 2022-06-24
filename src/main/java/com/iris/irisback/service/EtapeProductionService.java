package com.iris.irisback.service;

import com.iris.irisback.dto.EtapeProductionDTO;
import com.iris.irisback.mapper.EtapeProductionMapper;
import com.iris.irisback.model.EtapeProduction;
import com.iris.irisback.repository.EtapeProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EtapeProductionService {
    @Autowired
    EtapeProductionRepository etapeProductionRepository;

    public  EtapeProductionDTO addEtapeProduction(EtapeProductionDTO etapeProductionDTO) throws IOException {
     final EtapeProduction etapeProduction= EtapeProductionMapper.MAPPER.toEtapeProduction(etapeProductionDTO);
     return EtapeProductionMapper.MAPPER.toEtapeProductionDTO(etapeProductionRepository.save(etapeProduction));
    }


}
