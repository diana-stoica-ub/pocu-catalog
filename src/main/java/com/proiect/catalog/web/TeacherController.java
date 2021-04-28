package com.proiect.catalog.web;

import com.proiect.catalog.converter.TeacherBasicInfoConverter;
import com.proiect.catalog.converter.TeacherConverter;
import com.proiect.catalog.model.Teacher;
import com.proiect.catalog.service.TeacherService;
import com.proiect.catalog.web.dto.TeacherBasicInfoDto;
import com.proiect.catalog.web.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController         //this annotation means that this class will be a Bean (managed by spring) and will contain endpoints (an endpoint is a method that handles HTTP requests end returns a HTTP response)
@RequestMapping(value = "/teacher")     //base of the URLs of the endpoints from this class
public class TeacherController {

    //the controllers usually shouldn't have much logic in them
    //they should call services to retrieve needed data, perform validations
    //most of the logic should be in the services


    private final TeacherService teacherService;
    private final TeacherConverter teacherConverter;
    private final TeacherBasicInfoConverter teacherBasicInfoConverter;

    @Autowired  //injects (an instance) of TeacherService in the controller
    public TeacherController(TeacherService teacherService, TeacherConverter teacherConverter,
                             TeacherBasicInfoConverter teacherBasicInfoConverter) {
        this.teacherService = teacherService;
        this.teacherConverter = teacherConverter;
        this.teacherBasicInfoConverter = teacherBasicInfoConverter;
    }


    @GetMapping(value = "")
    public List<TeacherDto> getAll() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        return teacherConverter.fromEntitiesToDtos(allTeachers);
    }

    @GetMapping(value = "/basic")
    public List<TeacherBasicInfoDto> getAllBasicInfo() {
        List<Teacher> allTeachers = teacherService.getAllTeachers();

        return teacherBasicInfoConverter.fromEntitiesToDtos(allTeachers);
    }

}
