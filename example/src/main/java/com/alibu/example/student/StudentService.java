package com.alibu.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Este servicio nos sirve para separar la logica de negocio del controlador el cual solo debe dedicarse a gestionar las peticiones http
@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    //Esta es la manera de usar nuestro mapper para transformar la lista de Student a una lista de StudentResponseDto
    public List<StudentResponseDto> findAllStudent() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    //Aqui no hace falta abrir un stream porque no tenemos que devolver una lista
    public StudentResponseDto findById(Integer id) {
        return repository
                .findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentsByName(String name) {
        return repository.findAllByFirstNameContaining(name)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
