package com.iris.irisback.mapper;

import com.iris.irisback.dto.LigneCommandDTO;
import com.iris.irisback.model.LigneCommand;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper

public abstract class LignCommandMapper {
    public static LignCommandMapper MAPPER = Mappers.getMapper(LignCommandMapper.class);


    public abstract LigneCommandDTO toLigneCommandDTO(LigneCommand ligneCommand);


    public abstract LigneCommand toLigneCommand(LigneCommandDTO ligneCommandDTO);

    @AfterMapping
    void updateLigneCommandDTO(final LigneCommand ligneCommand, @MappingTarget final LigneCommandDTO ligneCommandDTO) {


    }

    @AfterMapping
    void updateLigneCommand(final LigneCommandDTO ligneCommandDTO, @MappingTarget final LigneCommand ligneCommand) {}
}
