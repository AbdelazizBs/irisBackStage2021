package com.iris.irisback.mapper;

import com.iris.irisback.dto.ArticleDTO;
import com.iris.irisback.dto.MachineDTO;
import com.iris.irisback.model.Article;
import com.iris.irisback.model.Machine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ArticleMapper {

    public static ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);

    //  @Mapping(target = "etapeProduction", ignore = true)
    public abstract ArticleDTO toArticleDTO(Article article );

    public abstract Article toArticle(ArticleDTO articleDTO);
}
