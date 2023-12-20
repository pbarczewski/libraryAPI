package com.pbarczewski.books.rest.response;

import com.pbarczewski.books.domain.model.VolumeInfoModel;
import com.pbarczewski.common.ResponseBody;
import lombok.Data;

import java.util.List;

@Data
public class BookResponseList extends ResponseBody {
    private List<VolumeInfoModel> volumeInfoModel;
}
