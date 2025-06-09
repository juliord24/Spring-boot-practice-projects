package com.juliord24.springDataJPACourse.repositories;

import com.juliord24.springDataJPACourse.models.Video;
import org.aspectj.apache.bcel.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
