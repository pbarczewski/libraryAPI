package com.pbarczewski.books.service;

import com.pbarczewski.books.domain.BookServiceInterface;
import com.pbarczewski.books.domain.BooksRepositoryInterface;
import com.pbarczewski.books.domain.model.VolumeInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements BookServiceInterface {

    @Autowired
    private BooksRepositoryInterface booksRepositoryInterface;


    @Override
    public List<VolumeInfoModel> getVolumeInfoList(String category) {
        return booksRepositoryInterface.getVolumeInfoList(category);
    }

    @Override
    public VolumeInfoModel getVolumeInfoModelByIsbn(String isbn) {
        if (isbn != null) {
            return booksRepositoryInterface.getVolumeInfoModelByIsbn(isbn);
        }
        return null;
    }
}
