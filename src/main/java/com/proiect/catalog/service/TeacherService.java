package com.proiect.catalog.service;

import com.proiect.catalog.web.dto.SubjectDto;
import com.proiect.catalog.web.dto.SubjectScoringDto;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    public TeacherDto getTeacher() {
        TeacherDto dto = new TeacherDto();
        dto.setFirstName("Ion");
        dto.setLastName("Popescu");
        dto.setBirthDate(LocalDate.now());
        dto.setEmploymentDate(LocalDate.now());
        dto.setId(1L);
        dto.setSubjects(getSubjects());

        return dto;
    }

    private List<SubjectDto> getSubjects() {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(1L);
        subjectDto.setCreditPoints(2);
        subjectDto.setOptional(false);
        subjectDto.setName("Programare Orientata pe Obiecte");
        subjectDto.setSubjectScoring(new SubjectScoringDto(40, 60));

        List<SubjectDto> subjectDtos = new ArrayList<>();
        subjectDtos.add(subjectDto);

        return subjectDtos;
    }
}
