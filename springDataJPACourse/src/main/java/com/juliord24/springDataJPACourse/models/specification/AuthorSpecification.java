package com.juliord24.springDataJPACourse.models.specification;

import com.juliord24.springDataJPACourse.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age){
        return (
                Root<Author> root,
                CriteriaQuery<?> query,
                CriteriaBuilder criteriaBuilder
        ) -> {
            if (age < 0){
                return null;
            }
            return criteriaBuilder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author>
}
