package org.aepsilon.dto;

import org.aepsilon.orm.Category;
import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

public class CategoryDto {
    public List<TranslationDto> translations;


    public CategoryDto(){}

    public CategoryDto(Category c,String lg){
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(c,lg));
    }
}
