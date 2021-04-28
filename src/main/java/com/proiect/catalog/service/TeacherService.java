package com.proiect.catalog.service;

import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service            //this annotation means that this class is a Bean
public class TeacherService {
    //service classes contain most of the business logic;

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }





}
