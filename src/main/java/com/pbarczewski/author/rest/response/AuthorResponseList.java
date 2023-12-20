package com.pbarczewski.author.rest.response;

import com.pbarczewski.author.domain.model.AuthorModel;
import com.pbarczewski.common.ResponseBody;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponseList extends ResponseBody {
    private List<AuthorModel> authorModelList;
}
