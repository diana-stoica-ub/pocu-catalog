package com.proiect.catalog.web;

import com.proiect.catalog.service.TeacherService;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         //this annotation means that this class will be a Bean (managed by spring) and will contain endpoints (an endpoint is a method that handles HTTP requests end returns a HTTP response)
@RequestMapping(value = "/teacher")     //base of the URLs of the endpoints from this class
public class TeacherController {

    //the controllers usually shouldn't have much logic in them
    //they should call services to retrieve needed data, perform validations
    //most of the logic should be in the services


    @Value("${test.value}")     //retrieves the 'test.value' property from application.yml file
    private String testValue;

    private final TeacherService teacherService;

    @Autowired  //injects (an instance) of TeacherService in the controller
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "/hello")       //GET endpoint; value will be part of the URL
    public String hello() {
        return testValue;
    }

    @GetMapping(value = "/")            //GET endpoint; the format of the response will be JSON
    public TeacherDto getTeacher() {
        return teacherService.getTeacher();
    }
}
