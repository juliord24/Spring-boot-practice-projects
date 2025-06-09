package com.alibu.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // que servicio queremos testear
    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_student(){

        // Recrear objetos necesarios
        StudentDto dto = new StudentDto(
                "Jhon",
                "Doe",
                "jhonemail",
                1
        );
        Student student = new Student(
                "Jhon",
                "Doe",
                "jhonemail",
                1);

        Student savedStudent = new Student(
                "Jhon",
                "Doe",
                "jhonemail",
                1);
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);

        when(studentRepository.save(student))
                .thenReturn(savedStudent);

        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "Jhon",
                        "Doe",
                        "jhonemail"));


        StudentResponseDto responseDto = studentService.saveStudent(dto);

        // Asserts
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(studentRepository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);

    }

    @Test
    public void should_successfully_find_all_students(){

        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Jhon",
                "Doe",
                "jhonemail",
                1));


        when(studentRepository.findAll()).thenReturn(students);

        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                "Jhon",
                "Doe",
                "jhonemail"));

        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        assertEquals(students.size(), responseDtos.size());
    }

    @Test
    public void should_successfully_find_students_by_id(){

        //Given
        Integer id = 1;

        Student student = new Student(
                "Jhon",
                "Doe",
                "jhonemail",
                1);

        student.setId(id);


        //Mock the calls
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto(
                "Jhon",
                "Doe",
                "jhonemail"));

        // When
        StudentResponseDto dto = studentService.findById(id);

        //Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

        verify(studentRepository, times(1)).findById(id);
    }

    @Test
    public void should_find_students_by_name(){
        //Given

        String name = "Julio";

        List<Student> students = new ArrayList<>();
        students.add(new Student(
                name,
                "Doe",
                "jhonemail",
                1));

        //Mock the calls
        when(studentRepository.findAllByFirstNameContaining(name)).thenReturn(students);

        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(any(StudentResponseDto.class));

        //When

        var responseDto = studentService.findStudentsByName(name);

        //Then
        assertEquals(students.size(), responseDto.size());

        verify(studentRepository, times(1)).findAllByFirstNameContaining(name);
    }

    @Test
    public void should_delete_by_id(){

        Integer id = 1;

        studentService.deleteById(1);

        verify(studentRepository,times(1)).deleteById(1);


    }
}