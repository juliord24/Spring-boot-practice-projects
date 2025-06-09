package com.alibu.example.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "Jhon",
                "Doe",
                "jhonemail",
                1
        );

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var msg = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals(msg.getMessage(), "The student dto should not be null");
    }

    @Test
    public void shouldMapStudentToStudentDto(){
        Student student = new Student(
                "Julio",
                "Diaz",
                "julioemail",
                20
        );

        StudentResponseDto dto = mapper.toStudentResponseDto(student);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

    }


}