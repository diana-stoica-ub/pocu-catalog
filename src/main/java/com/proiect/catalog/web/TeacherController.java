package com.proiect.catalog.web;

import com.proiect.catalog.service.TeacherService;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Value("${test.value}")
    private String testValue;

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return testValue;
    }

    @GetMapping(value = "/")
    public TeacherDto getTeacher() {
        return teacherService.getTeacher();
    }
}
