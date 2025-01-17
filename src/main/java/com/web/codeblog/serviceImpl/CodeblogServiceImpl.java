package com.web.codeblog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.codeblog.model.Post;
import com.web.codeblog.repository.CodeblogRepository;
import com.web.codeblog.service.CodeblogService;

@Service
public class CodeblogServiceImpl implements CodeblogService {

	@Autowired
	CodeblogRepository codeblogRepository;
	
	@Override
	public List<Post> findAll() {
		return codeblogRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}

}
