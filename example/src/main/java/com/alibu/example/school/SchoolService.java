package com.alibu.example.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRespository;
    private final SchoolMapper schoolMapper;


    public SchoolService(SchoolRepository schoolRespository, SchoolMapper schoolMapper) {
        this.schoolRespository = schoolRespository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRespository.save(school);
        return dto;
    }

    public List<SchoolDto> findAll() {
        return schoolRespository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }


}
