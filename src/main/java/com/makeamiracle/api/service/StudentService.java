package com.makeamiracle.api.service;

import com.makeamiracle.api.config.exception.NotFoundException;
import com.makeamiracle.api.domain.Student;
import com.makeamiracle.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        if (!studentRepository.existsById(id)) throw new NotFoundException("Student does not exist with id " + id);
        return studentRepository.getOne(id);
    }

    public Long count(){
        return studentRepository.count();
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public Student update(Student student, Long id){
        if (!studentRepository.existsById(id)) throw new NotFoundException("Student does not exist with id " + id);
        Student updStudent = studentRepository.getOne(id);
        if (student.getDni() != null) updStudent.setDni(student.getDni());
        if (student.getName() != null) updStudent.setName(student.getName());
        if (student.getLastName() != null) updStudent.setLastName(student.getLastName());
        if (student.getGender() != null) updStudent.setGender(student.getGender());
        if (student.getDateOfBirth() != null) updStudent.setDateOfBirth(student.getDateOfBirth());
        if (student.getDistrict() != null) updStudent.setDistrict(student.getDistrict());
        if (student.getPhone() != null) updStudent.setPhone(student.getPhone());
        if (student.getAddress() != null) updStudent.setAddress(student.getAddress());
        if (student.getEmail() != null) updStudent.setEmail(student.getEmail());
        studentRepository.save(updStudent);
        return updStudent;
    }

    public Student changeStatus(Long id){
        if (!studentRepository.existsById(id)) throw new NotFoundException("Student does not exist with id " + id);
        Student updStudent = studentRepository.getOne(id);
        updStudent.setStatus(!updStudent.getStatus());
        studentRepository.save(updStudent);
        return updStudent;
    }

    public List<Student> findTop5(){
        return studentRepository.findTop5ByStatusIsTrueOrderByIdDesc();
    }
}
