package com.pbarczewski.author.service;

import com.pbarczewski.author.domain.AuthorRepositoryInterface;
import com.pbarczewski.author.domain.AuthorServiceInterface;
import com.pbarczewski.author.domain.model.AuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorRepositoryInterface authorRepositoryInterface;

    @Override
    public List<AuthorModel> getAuthorModelList() {
        return authorRepositoryInterface.getAuthorModelList();
    }
}
