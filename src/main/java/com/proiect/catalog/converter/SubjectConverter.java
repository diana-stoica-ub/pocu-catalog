package com.proiect.catalog.converter;

import com.proiect.catalog.model.Subject;
import com.proiect.catalog.web.dto.SubjectDto;
import com.proiect.catalog.web.dto.SubjectScoringDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubjectConverter {

    public List<SubjectDto> fromEntitiesToDtos(List<Subject> entities) {
        return entities
                .stream()
                .map(this::fromEntityToDto)
                .collect(Collectors.toList());
    }

    public SubjectDto fromEntityToDto(Subject entity) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(entity.getId());
        subjectDto.setName(entity.getName());
        subjectDto.setOptional(entity.getOptional());
        subjectDto.setCreditPoints(entity.getCreditPoints());
        subjectDto.setSubjectScoring(new SubjectScoringDto(entity.getCoursePercent(),
                entity.getSeminaryPercent()));

        return subjectDto;
    }
}
