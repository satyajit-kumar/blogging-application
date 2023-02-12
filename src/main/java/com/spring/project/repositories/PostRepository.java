package com.spring.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.project.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
