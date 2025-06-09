package com.juliord24.springDataJPACourse.repositories;

import com.juliord24.springDataJPACourse.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {



    List<Author> findByNamedQuery(@Param("age") int age);

    List<Author> findAllByFirstNameIgnoreCase(String fn);

    //asi se implementa una query para updatear un objeto
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthors(int age);
}
