package com.pbarczewski.books.domain;

import com.pbarczewski.books.domain.model.VolumeInfoModel;

import java.util.List;

public interface BooksRepositoryInterface {
    List<VolumeInfoModel> getVolumeInfoList(String category);
    VolumeInfoModel getVolumeInfoModelByIsbn(String isbn);
}
