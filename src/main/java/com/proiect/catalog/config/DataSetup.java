package com.proiect.catalog.config;

import com.proiect.catalog.model.Subject;
import com.proiect.catalog.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSetup implements ApplicationRunner {

    private final SubjectRepository subjectRepository;

    @Autowired
    public DataSetup(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveSubject("Matematica", 20, 80, 5, true);
        saveSubject("Fizica", 30, 70, 5, false);
        saveSubject("Informatica", 50, 50, 5, false);
        saveSubject("Chimie", 20, 80, 5, true);
        saveSubject("Biologie", 20, 80, 5, true);

    }

    private void saveSubject(String subjectName, Integer coursePercent, Integer seminaryPercent,
                                Integer creditPoints, Boolean isOptional) {
        Subject subject = new Subject();
        subject.setName(subjectName);
        subject.setCoursePercent(coursePercent);
        subject.setSeminaryPercent(seminaryPercent);
        subject.setCreditPoints(creditPoints);
        subject.setOptional(isOptional);

        subjectRepository.save(subject);
    }
}
