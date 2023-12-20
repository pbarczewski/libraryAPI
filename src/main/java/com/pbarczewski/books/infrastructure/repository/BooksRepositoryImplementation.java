package com.pbarczewski.books.infrastructure.repository;

import com.pbarczewski.books.domain.BooksRepositoryInterface;
import com.pbarczewski.books.domain.model.VolumeInfoModel;
import com.pbarczewski.books.infrastructure.mapper.BookMapper;
import com.pbarczewski.books.infrastructure.model.ItemEntity;
import com.pbarczewski.data.JsonDataMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BooksRepositoryImplementation implements BooksRepositoryInterface {

    private List<ItemEntity> itemEntities = JsonDataMapper.INSTANCE.readData();

    @Override
    public List<VolumeInfoModel> getVolumeInfoList(String category) {
        return itemEntities.stream().map(x -> BookMapper.convertToVolumeInfoModel(x, category)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public VolumeInfoModel getVolumeInfoModelByIsbn(String isbn) {
        Optional<VolumeInfoModel> volumeInfoModelOptional =  itemEntities.stream().map(x -> BookMapper.convertToVolumeInfoModel(x, null)).filter(x -> x.getIsbn().equals(isbn)).findFirst();
        if(volumeInfoModelOptional.isPresent()) {
            return volumeInfoModelOptional.get();
        }
        return null;
    }
}
