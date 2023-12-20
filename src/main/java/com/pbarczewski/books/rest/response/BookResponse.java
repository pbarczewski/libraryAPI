package com.pbarczewski.books.rest.response;

import com.pbarczewski.books.domain.model.VolumeInfoModel;
import com.pbarczewski.common.ResponseBody;
import lombok.Data;

import java.util.List;

@Data
public class BookResponse extends ResponseBody {
    private VolumeInfoModel volumeInfoModel;
}
