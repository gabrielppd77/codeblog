package com.web.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long>{

}
