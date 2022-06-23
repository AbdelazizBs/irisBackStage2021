package com.iris.irisback.mapper;


import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.PersonnelDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Personnel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class PersonnelMapper {
    public static PersonnelMapper MAPPER = Mappers.getMapper(PersonnelMapper.class);

    //  @Mapping(target = "etapeProduction", ignore = true)
    public abstract PersonnelDTO toPersonnelDTO(Personnel personnel );

    public abstract Personnel toPersonnel(PersonnelDTO personnelDTO);
}
