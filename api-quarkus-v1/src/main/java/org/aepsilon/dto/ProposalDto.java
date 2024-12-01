package org.aepsilon.dto;

import org.aepsilon.orm.Category;
import org.aepsilon.orm.Proposal;

import java.util.ArrayList;
import java.util.List;

public class ProposalDto {
    public Long id;
    public List<TranslationDto> translations;

    public QuestionDto question;

    public ProposalDto(){}

    public ProposalDto(Proposal p, String lg){
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(p,lg));
    }
}
