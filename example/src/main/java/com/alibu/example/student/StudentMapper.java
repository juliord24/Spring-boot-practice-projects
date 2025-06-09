package com.alibu.example.student;

import com.alibu.example.school.School;
import org.springframework.stereotype.Service;

//El mapper es un servicio que contiene los metodos para transformar objetos
@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto) {

        if(dto == null){
            throw new NullPointerException("The student dto should not be null");
        }

        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }
}
