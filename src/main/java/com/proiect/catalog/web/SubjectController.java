package com.proiect.catalog.web;

import com.proiect.catalog.converter.SubjectConverter;
import com.proiect.catalog.model.Subject;
import com.proiect.catalog.service.SubjectService;
import com.proiect.catalog.web.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final SubjectConverter subjectConverter;

    @Autowired
    public SubjectController(SubjectService subjectService, SubjectConverter subjectConverter) {
        this.subjectService = subjectService;
        this.subjectConverter = subjectConverter;
    }

    @GetMapping(value = "")
    public List<SubjectDto> getSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();

        return subjectConverter.fromEntitiesToDtos(subjects);
    }

    @GetMapping(value = "/{id}")
    public SubjectDto getSubject(@PathVariable Long id) {  //in order to take variables from URL we can use @PathVariable
        Subject subject = subjectService.getSubject(id); //subjectService.getSubject(id)  Alt + Enter ==> Subject subject = subjectService.getSubject(id)

        return subjectConverter.fromEntityToDto(subject);
    }


}
