package com.pbarczewski.authorService;

import java.util.List;

import com.pbarczewski.entity.Author;

public interface sortAuthors extends findAllAuthors {
	List<Author> sortedAuthors();
}
