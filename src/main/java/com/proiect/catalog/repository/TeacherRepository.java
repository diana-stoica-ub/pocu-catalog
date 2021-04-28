package com.proiect.catalog.repository;

import com.proiect.catalog.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByFirstName(String firstName);  //select * from teacher where first_name = '..'

    List<Teacher> findByFirstNameAndLastName(String firstName, String lastName);    //select * from teacher where first_name = '..' and last_name = '..'

    Optional<Teacher> findByCnp(String cnp);


}