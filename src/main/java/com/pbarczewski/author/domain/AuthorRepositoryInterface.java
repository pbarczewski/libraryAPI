package com.pbarczewski.author.domain;

import com.pbarczewski.author.domain.model.AuthorModel;
import java.util.List;

public interface AuthorRepositoryInterface {
    List<AuthorModel> getAuthorModelList();
}
