package com.project_sms.studentapplication.controller;

import com.project_sms.studentapplication.entity.Student;
import com.project_sms.studentapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @GetMapping(path = "/students", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping(path = "/students/add")
    public ResponseEntity<String> saveStudentsToDB(@RequestParam String firstName, @RequestParam String lastName,
                                                   @RequestParam String email, @RequestParam String city){
        Student std = new Student(firstName.trim(),lastName.trim(),email.trim(),city.trim());
        studentRepository.save(std);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(path = "/students/search/firstname", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByFirstName(@RequestParam(value="firstname") String firstName) {
        return new ResponseEntity<>(studentRepository.findByFirstName(firstName.trim()), HttpStatus.OK);
    }
    @GetMapping(path = "/students/search/lastname", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByLastName(@RequestParam(value="lastname") String lastName) {
        return new ResponseEntity<>(studentRepository.findByLastName(lastName.trim()), HttpStatus.OK);
    }
    @GetMapping(path = "/students/search/email", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByEmail(@RequestParam(value="email") String email) {
        return new ResponseEntity<>(studentRepository.findByEmail(email.trim()), HttpStatus.OK);
    }
    @GetMapping(path = "/students/search/city", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByCity(@RequestParam(value="city") String city) {
        return new ResponseEntity<>(studentRepository.findByCity(city.trim()), HttpStatus.OK);
    }
    @GetMapping(path = "/students/search/rollnum", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsByRollNum(@RequestParam(value="rollnum") String rollNum) {
        return new ResponseEntity<>(studentRepository.findByRollNum(rollNum.trim()), HttpStatus.OK);
    }
    @DeleteMapping(path = "/students/delete/rollnum", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteByRollNum(@RequestParam(value="rollnum") String rollNum) {
        studentRepository.deleteById(rollNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/students/update/city")
    public ResponseEntity<String> updateCityByRollNum(@RequestParam(value="city") String city, @RequestParam(value="rollnum") String rollNum) {
        studentRepository.updateCityByRollNum(city, rollNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/students/update/firstname")
    public ResponseEntity<String> updateFirstnameByRollNum(@RequestParam(value="firstname") String firstName, @RequestParam(value="rollnum") String rollNum) {
        studentRepository.updateFirstnameByRollNum(firstName, rollNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/students/update/lastname")
    public ResponseEntity<String> updateLastnameByRollNum(@RequestParam(value="lastname") String lastName, @RequestParam(value="rollnum") String rollNum) {
        studentRepository.updateLastnameByRollNum(lastName, rollNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(path = "/students/update/email")
    public ResponseEntity<String> updateEmailByRollNum(@RequestParam(value="email") String email, @RequestParam(value="rollnum") String rollNum) {
        studentRepository.updateEmailByRollNum(email, rollNum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}