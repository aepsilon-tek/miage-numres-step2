package org.aepsilon.dto;

import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;
import org.aepsilon.orm.Question;
import org.aepsilon.web.client.TranslateResponse;

public class TranslationDto {



    public String language;
    public String value;


    public TranslationDto(){}

    public TranslationDto(Question q,String lg){
        language=lg;
        value = q.label;
    }

    public TranslationDto(Category c,String lg){
        language=lg;
        value = c.label;
    }

    public TranslationDto(Proposal p, String lg){
        language=lg;
        value = p.label;
    }

    public TranslationDto(TranslateResponse r, String lg){
        language=lg;
        value = r.getTranslatedText();
    }
}
